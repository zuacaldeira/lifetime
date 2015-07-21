/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.list;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.Marker;
import com.vaadin.addon.charts.model.PlotOptionsLine;
import com.vaadin.event.LayoutEvents;
import old.ui.item.ItemView;
import old.ui.button.LifetimeChartButton;
import old.ui.button.LifetimeButtonLink;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.LinkedList;
import java.util.List;
import lifetime.business.persistence.Achievement;
import old.ui.form.LifetimeForm;
import old.ui.window.LifetimeWindow;
import old.util.ServiceLocator;

/**
 *
 * @author azc
 */
public abstract class LifetimeList<T> extends Panel implements LayoutClickListener, Button.ClickListener {

    private ItemView selected;
    private final VerticalLayout base;
    private final VerticalLayout main;
    private final HorizontalLayout stats;
    private List<T> data;
    private LifetimeButtonLink addButton;
    //private Set<String> filters;
    private final Integer userId;
    private final String language;
    private LifetimeChartButton chartButton;

    public LifetimeList(Integer userId, String language) {
        setSizeFull();
        this.userId = userId;
        this.language = language;
        base = new VerticalLayout();
        base.setMargin(true);
        base.setSpacing(true);
        //base.setSizeFull();
        base.setWidth("100%");
        base.setStyleName("a-list");
        setContent(base);
        //
        stats = new HorizontalLayout();
        stats.setStyleName("stats");
        //stats.setSizeFull();
        //
        main = new VerticalLayout();
        //main.setSizeFull();
        initAllComponents();
        //
        base.addComponents(stats, main);
        base.setExpandRatio(main, .9f);
        base.setExpandRatio(stats, .1f);
        base.setComponentAlignment(main, Alignment.TOP_CENTER);
        base.setComponentAlignment(stats, Alignment.MIDDLE_LEFT);
        //
        setStyleName("a-list");
    }

    public VerticalLayout getMain() {
        return main;
    }

    public HorizontalLayout getStats() {
        return stats;
    }

    public VerticalLayout getBase() {
        return base;
    }

    private void initAllComponents() {
        initMain();
        initStats();
    }

    public void initMain() {
        main.removeAllComponents();
        setData(getDataFromServer());
        //Collections.sort((List<T>) getAchievements(), new DescendantComparator());
        for (T item : getData()) {
            ItemView itemView = getItemView(item);
            itemView.addLayoutClickListener(this);
            main.addComponent(itemView);
            if (selected == null) {
                selected = itemView;
                selected.select();
            } else {
                itemView.unselect();
            }
        }
    }

    @Override
    public void layoutClick(LayoutEvents.LayoutClickEvent event) {
        if (event.getSource() instanceof ItemView) {
            ItemView clickedItem = (ItemView) event.getSource();
            if (clickedItem != selected) {
                selected.setStyleName("item");
                selected.unselect();
                //selected.collapse();
                clickedItem.setStyleName("item-selected");
                clickedItem.select();
                //clickedItem.expand();
            }
            selected = clickedItem;
        }
    }

    protected void initStats() {
        stats.removeAllComponents();
        addButton = new LifetimeButtonLink("New", FontAwesome.PLUS);
        addButton.addClickListener(this);

        chartButton = new LifetimeChartButton();
        chartButton.addClickListener(this);
        stats.addComponents(addButton, chartButton);

    }

    protected void setData(List<T> data) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("#achievements = " + data.size());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public LifetimeButtonLink getAddButton() {
        return addButton;
    }

    /*    public Set<String> getFilters() {
     return filters;
     }*/
    protected abstract ItemView getItemView(T item);

    public ItemView getSelected() {
        return selected;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }

    protected abstract List<T> getDataFromServer();

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if (event.getButton().equals(getAddButton())) {
            LifetimeForm<T> form = getFormNew();
            form.setSizeFull();
            Window window = new LifetimeWindow(userId, language, "Add achievement");
            window.setContent(form);
            getUI().addWindow(window);
        }
        if (event.getButton() == chartButton) {
            Chart chart = getChart();
            chart.setSizeFull();
            Window window = new LifetimeWindow(userId, language, "Charts");
            window.setContent(chart);
            getUI().addWindow(window);
        }
    }

    protected abstract LifetimeForm<T> getFormNew();

    protected Chart getChart() {
        Chart chart = new Chart(ChartType.LINE);

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Test Line Chart");

        PlotOptionsLine plotOptions = new PlotOptionsLine();
        plotOptions.setMarker(new Marker(false));

        conf.setPlotOptions(plotOptions);

        ListSeries series = new ListSeries("Diameter");
        series.setData(4900, 12100, 12800,
                6800, 143000, 125000,
                51100, 49500);
        conf.addSeries(series);
        return chart;
    }

    private List<String> getUserLanguagues(Integer userId, String language) {
        return new LinkedList(ServiceLocator.findLifetimeService().getUserLanguages(userId));
    }

    void hideAddButton() {
        addButton.setVisible(false);
    }

    public void update() {
        initMain();
    }

    public void setSelected(ItemView selected) {
        this.selected = selected;
        this.selected.select();
    }

}
