package com.company.hrtrainingplatform.web.employee;

import com.company.hrtrainingplatform.entity.Employee;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.EntityCombinedScreen;
import com.haulmont.cuba.gui.components.Table;
import com.vaadin.event.ItemClickEvent;

import javax.inject.Inject;
import java.util.Map;

public class EmployeeBrowse extends EntityCombinedScreen {
    @Inject
    private Table<Employee> table;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        com.vaadin.ui.Table vTable = table.unwrap(com.vaadin.ui.Table.class);
        vTable.addItemClickListener((ItemClickEvent.ItemClickListener) event ->
                showNotification("Item " + event.getItem())
        );
    }

    @Override
    public void initBrowseItemChangeListener(){
        /*CollectionDatasource browseDs = getTable().getDatasource();
        Datasource editDs = getFieldGroup().getDatasource();

        browseDs.addItemChangeListener(e -> {
            if (e.getItem() != null) {
                Entity reloadedItem = getDsContext().getDataSupplier().reload(e.getDs().getItem(), editDs.getView());
                editDs.setItem(reloadedItem);
            }
        });*/
    }


    public void onODataBtnClick() {

    }
}

/*
(╯°□°)╯︵ ┻━┻ FLIP THAT TABLE.

┻━┻ ︵ ヽ(°□°ヽ) FLIP THIS TABLE.

┻━┻ ︵ ＼\('0')/／ ︵ ┻━┻

FLIP ALL THE TABLES!

ಠ_ಠ Tom...

ಠ_ಠ Put.

ಠ__ಠ The tables.

ಠ___ಠ Back.

(╮°-°)╮┳━┳

(╯°□°)╯︵ ┻━┻ NEVER!﻿
*/
