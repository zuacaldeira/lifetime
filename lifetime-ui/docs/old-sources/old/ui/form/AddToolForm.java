/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import lifetime.business.persistence.Achievement;
import lifetime.business.persistence.JobOffer;
import old.ui.list.LifetimeList;
import old.ui.list.ToolsList;
import old.util.ServiceLocator;

/**
 *
 * @author azc
 */
public class AddToolForm<T> extends LifetimeForm<T>  {
    private ToolsList toolList;

    public AddToolForm(Integer userId, String language, T item, LifetimeList list) {
        super(userId, language, item, list);
        addTool();
    }
    
    private void addTool() {
        toolList = new ToolsList("Choose your tools", getUserId(), getLanguage());
        getMain().addComponent(toolList);
    }
    

    @Override
    public void fillItem() {
        if(getItem() instanceof Achievement) {
            ((Achievement)getItem()).getTools().size();
            ((Achievement) getItem()).setTools(toolList.getTools());
        }
        if(getItem() instanceof JobOffer) {
            ((JobOffer)getItem()).getTools().size();
            ((JobOffer) getItem()).setTools(toolList.getTools());
        }
    }

    @Override
    protected void commitItem() {
        if(getItem() instanceof Achievement) {
            ServiceLocator.findLifetimeService().update((Achievement) getItem());
        }
        if(getItem() instanceof JobOffer) {
            ServiceLocator.findLifetimeService().update((JobOffer) getItem());
        }
    }

}
