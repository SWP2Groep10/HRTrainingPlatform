package com.company.hrtrainingplatform.web.login;

import com.company.hrtrainingplatform.entity.Employee;
import com.company.hrtrainingplatform.service.ODataService;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.PasswordField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.security.entity.Group;
import com.haulmont.cuba.security.entity.Role;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.entity.UserRole;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.UUID;

public class RegisterScreen extends AbstractWindow {
    private ODataService oDataService = AppBeans.get(ODataService.NAME);
    //Uit de database halen!
    private static final String COMPANY_GROUP_ID = "0fa2b1a5-1d68-4d69-9fbd-dff348347f93";

    //Ook uit database halen
    private static final String DEFAULT_ROLE_ID = "0c018061-b26f-4de2-a5be-dff348347f93";

    @Inject
    private TextField loginField;

    @Inject
    private PasswordField passwordField;

    @Inject
    private DataManager dataManager;

    @Inject
    private Metadata metadata;

    @Inject
    private PasswordEncryption passwordEncryption;

    public void onCancelBtnClick(){
        close(CLOSE_ACTION_ID);
    }

    public void onOkBtnClick() {
        // Check if a user with the same login already exists
        long existing = dataManager.getCount(LoadContext.create(User.class).setQuery(
                LoadContext.createQuery("select u from sec$User u where u.loginLowerCase = :login")
                        .setParameter("login", getLogin()+"")));
        if (existing > 0) {
            showNotification("A user with the same login already exists", NotificationType.TRAY);
        } else {
            if(oDataService != null) {
                ArrayList<Employee> empList = oDataService.getEmployees("http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
                if(getLogin() > empList.size()) {
                    showNotification("No employee with that ID could be found in the OData. Please contact an admin", NotificationType.TRAY);
                } else {
                    Employee newEmp = empList.get(getLogin()-1);
                    // Load group and role to be assigned to the new user
                    Group group = dataManager.load(LoadContext.create(Group.class).setId(UUID.fromString(COMPANY_GROUP_ID)));
                    Role role = dataManager.load(LoadContext.create(Role.class).setId(UUID.fromString(DEFAULT_ROLE_ID)));
                    // Create a user instance
                    User user = metadata.create(User.class);
                    newEmp.setUser(user);
                    user.setFirstName(newEmp.getFirstName());
                    user.setLastName(newEmp.getLastName());
                    user.setName(newEmp.getFirstName() + " " + user.getLastName());
                    user.setLogin(getLogin()+"");
                    user.setPassword(passwordEncryption.getPasswordHash(user.getId(), getPassword()));
                    user.setGroup(group);
                    // Create a link to the role
                    UserRole userRole = metadata.create(UserRole.class);
                    userRole.setUser(user);
                    userRole.setRole(role);
                    // Save new entities
                    dataManager.commit(new CommitContext(user, userRole, newEmp));


                    showNotification("Created user " + user.getLogin(), NotificationType.TRAY);
                    close(COMMIT_ACTION_ID);
                }
            }
        }
    }

    public int getLogin() { return loginField.getValue(); }

    public String getPassword() {
        return passwordField.getValue();
    }
}