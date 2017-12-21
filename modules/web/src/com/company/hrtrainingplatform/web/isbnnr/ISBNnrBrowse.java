package com.company.hrtrainingplatform.web.isbnnr;

import com.company.hrtrainingplatform.entity.ISBNnr;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.EntityCombinedScreen;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;

import javax.inject.Inject;

public class ISBNnrBrowse extends EntityCombinedScreen {

    @Inject
    private Table<ISBNnr> table;

    public void onShowBookClick(Component source) {
        try {
            ISBNnr i = table.getSingleSelected();
            String url = "https://books.google.com/books?vid=ISBN" + i.getIsbn();
            showWebPage(url, ParamsMap.of("target", "_blank"));
        }
        catch (NullPointerException e){showNotification("No selection has been made.");}
    }
}