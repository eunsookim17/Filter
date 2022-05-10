package com.example.shape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private ListView listView;
    private Button filterButton;
    private LinearLayout filterView1;
    private LinearLayout filterView2;
    private LinearLayout filterView3;
    private LinearLayout filterView4;
    private LinearLayout filterView5;

    boolean filterHidden = true;

    private Button allButton, istjButton, istpButton, isfjButton, isfpButton,
            intjButton, infjButton, intpButton, infpButton,
            estjButton, esfjButton, estpButton, esfpButton,
            entjButton, enfjButton, entpButton, enfpButton;


    private ArrayList<String> selectedFilters = new ArrayList<String>();
    private String currentSearchText = "";
    private SearchView searchView;

    private int white, darkGray, red;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSearchWidgets();
        initWidgets();
        setupData();
        setUpList();
        setUpOnclickListener();
        hideFilter();
        initColors();
        lookSelected(allButton);
        selectedFilters.add("all");
    }

    private void initColors()
    {
        white = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
        red = ContextCompat.getColor(getApplicationContext(), R.color.red);
        darkGray = ContextCompat.getColor(getApplicationContext(), R.color.darkerGray);
    }


    private void unSelectAllFilterButtons()
    {
        lookUnSelected(allButton);

        lookUnSelected(istjButton);
        lookUnSelected(istpButton);
        lookUnSelected(isfjButton);
        lookUnSelected(isfpButton);

        lookUnSelected(intjButton);
        lookUnSelected(infjButton);
        lookUnSelected(intpButton);
        lookUnSelected(infpButton);

        lookUnSelected(estjButton);
        lookUnSelected(esfjButton);
        lookUnSelected(estpButton);
        lookUnSelected(esfpButton);

        lookUnSelected(entjButton);
        lookUnSelected(enfjButton);
        lookUnSelected(entpButton);
        lookUnSelected(enfpButton);
    }

    private void lookSelected(Button parsedButton)
    {
        parsedButton.setTextColor(white);
        parsedButton.setBackgroundColor(red);
    }

    private void lookUnSelected(Button parsedButton)
    {
        parsedButton.setTextColor(red);
        parsedButton.setBackgroundColor(darkGray);
    }

    private void initWidgets()
    {
        filterButton = (Button) findViewById(R.id.filterButton);
        filterView1 = (LinearLayout) findViewById(R.id.filterTabsLayout);
        filterView2 = (LinearLayout) findViewById(R.id.filterTabsLayout2);
        filterView3 = (LinearLayout) findViewById(R.id.filterTabsLayout3);
        filterView4 = (LinearLayout) findViewById(R.id.filterTabsLayout4);
        filterView5 = (LinearLayout) findViewById(R.id.filterTabsLayout5);

        allButton  = (Button) findViewById(R.id.allFilter);

        istjButton  = (Button) findViewById(R.id.istjFilter);
        istpButton = (Button) findViewById(R.id.istpFilter);
        isfjButton = (Button) findViewById(R.id.isfjFilter);
        isfpButton = (Button) findViewById(R.id.isfpFilter);

        intjButton  = (Button) findViewById(R.id.intjFilter);
        infjButton = (Button) findViewById(R.id.infjFilter);
        intpButton = (Button) findViewById(R.id.intpFilter);
        infpButton = (Button) findViewById(R.id.infpFilter);

        estjButton = (Button) findViewById(R.id.estjFilter);
        esfjButton = (Button) findViewById(R.id.esfjFilter);
        estpButton = (Button) findViewById(R.id.estpFilter);
        esfpButton = (Button) findViewById(R.id.esfpFilter);

        entjButton = (Button) findViewById(R.id.entjFilter);
        enfjButton = (Button) findViewById(R.id.enfjFilter);
        entpButton = (Button) findViewById(R.id.entpFilter);
        enfpButton = (Button) findViewById(R.id.enfpFilter);
    }

    private void initSearchWidgets()
    {
        searchView = (SearchView) findViewById(R.id.shapeListSearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                currentSearchText = s;
                ArrayList<Shape> filteredShapes = new ArrayList<Shape>();

                for(Shape shape: shapeList)
                {
                    if(shape.getName().toLowerCase().contains(s.toLowerCase()))
                    {
                        if(selectedFilters.contains("all"))
                        {
                            filteredShapes.add(shape);
                        }
                        else
                        {
                            for(String filter: selectedFilters)
                            {
                                if (shape.getName().toLowerCase().contains(filter))
                                {
                                    filteredShapes.add(shape);
                                }
                            }
                        }
                    }
                }
                setAdapter(filteredShapes);

                return false;
            }
        });
    }

    private void setupData()
    {
        Shape istj = new Shape("0","ISTJ", R.drawable.ic_account_circle);
        shapeList.add(istj);
        Shape istp = new Shape("1","ISTP", R.drawable.ic_account_circle);
        shapeList.add(istp);
        Shape isfj = new Shape("2","ISFJ", R.drawable.ic_account_circle);
        shapeList.add(isfj);
        Shape isfp = new Shape("3","ISFP", R.drawable.ic_account_circle);
        shapeList.add(isfp);

        Shape intj = new Shape("4","INTJ", R.drawable.ic_account_circle);
        shapeList.add(intj);
        Shape infj = new Shape("5","INFJ", R.drawable.ic_account_circle);
        shapeList.add(infj);
        Shape intp = new Shape("6", "INTP", R.drawable.ic_account_circle);
        shapeList.add(intp);
        Shape infp = new Shape("7", "INFP", R.drawable.ic_account_circle);
        shapeList.add(infp);

        Shape estj = new Shape("8", "ESTJ", R.drawable.ic_account_circle);
        shapeList.add(estj);
        Shape esfj = new Shape("9", "ESFJ", R.drawable.ic_account_circle);
        shapeList.add(esfj);
        Shape estp = new Shape("10", "ESTP", R.drawable.ic_account_circle);
        shapeList.add(estp);
        Shape esfp = new Shape("11", "ESFP", R.drawable.ic_account_circle);
        shapeList.add(esfp);

        Shape entj = new Shape("11", "ENTJ", R.drawable.ic_account_circle);
        shapeList.add(entj);
        Shape enfj = new Shape("11", "ENFJ", R.drawable.ic_account_circle);
        shapeList.add(enfj);
        Shape entp = new Shape("11", "ENTP", R.drawable.ic_account_circle);
        shapeList.add(entp);
        Shape enfp = new Shape("11", "ENFP", R.drawable.ic_account_circle);
        shapeList.add(enfp);
    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        setAdapter(shapeList);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }


//필터리스트 - 상태
    private void filterList(String status)
    {
        if(status != null && !selectedFilters.contains(status))
            selectedFilters.add(status);

        ArrayList<Shape> filteredShapes = new ArrayList<Shape>();

        for(Shape shape: shapeList)
        {
            for(String filter: selectedFilters)
            {
                if(shape.getName().toLowerCase().contains(filter))
                {
                    if(currentSearchText == "")
                    {
                        filteredShapes.add(shape);
                    }
                    else
                    {
                        if(shape.getName().toLowerCase().contains(currentSearchText.toLowerCase()))
                        {
                            filteredShapes.add(shape);
                        }
                    }
                }
            }
        }

        setAdapter(filteredShapes);
    }

//button click
    public void allFilterTapped(View view)
    {
        selectedFilters.clear();
        selectedFilters.add("all");

        unSelectAllFilterButtons();
        lookSelected(allButton);

        setAdapter(shapeList);
    }

    public void istjFilterTapped(View view)
    {
        filterList("istj");
        lookSelected(istjButton);
        lookUnSelected(allButton);
    }

    public void istpFilterTapped(View view)
    {
        filterList("istp");
        lookSelected(istpButton);
        lookUnSelected(allButton);
    }

    public void isfjFilterTapped(View view)
    {
        filterList("isfj");
        lookSelected(isfjButton);
        lookUnSelected(allButton);
    }

    public void isfpFilterTapped(View view)
    {
        filterList("isfp");
        lookSelected(isfpButton);
        lookUnSelected(allButton);
    }

    public void intjFilterTapped(View view)
    {
        filterList("intj");
        lookSelected(intjButton);
        lookUnSelected(allButton);
    }

    public void infjFilterTapped(View view)
    {
        filterList("infj");
        lookSelected(infjButton);
        lookUnSelected(allButton);
    }

    public void intpFilterTapped(View view)
    {
        filterList("intp");
        lookSelected(intpButton);
        lookUnSelected(allButton);
    }

    public void infpFilterTapped(View view)
    {
        filterList("infp");
        lookSelected(infpButton);
        lookUnSelected(allButton);
    }

    public void estjFilterTapped(View view)
    {
        filterList("estj");
        lookSelected(estjButton);
        lookUnSelected(allButton);
    }
    public void esfjFilterTapped(View view)
    {
        filterList("esfj");
        lookSelected(esfjButton);
        lookUnSelected(allButton);
    }
    public void estpFilterTapped(View view)
    {
        filterList("estp");
        lookSelected(estpButton);
        lookUnSelected(allButton);
    }
    public void esfpFilterTapped(View view)
    {
        filterList("esfp");
        lookSelected(esfpButton);
        lookUnSelected(allButton);
    }

    public void entjFilterTapped(View view)
    {
        filterList("entj");
        lookSelected(entjButton);
        lookUnSelected(allButton);
    }
    public void enfjFilterTapped(View view)
    {
        filterList("enfj");
        lookSelected(enfjButton);
        lookUnSelected(allButton);
    }
    public void entpFilterTapped(View view)
    {
        filterList("entp");
        lookSelected(entpButton);
        lookUnSelected(allButton);
    }
    public void enfpFilterTapped(View view)
    {
        filterList("enfp");
        lookSelected(enfpButton);
        lookUnSelected(allButton);
    }


    public void showFilterTapped(View view)
    {
        if(filterHidden == true)
        {
            filterHidden = false;
            showFilter();
        }
        else
        {
            filterHidden = true;
            hideFilter();
        }
    }

    private void hideFilter()
    {
        searchView.setVisibility(View.GONE);
        filterView1.setVisibility(View.GONE);
        filterView2.setVisibility(View.GONE);
        filterView3.setVisibility(View.GONE);
        filterView4.setVisibility(View.GONE);
        filterView5.setVisibility(View.GONE);
        filterButton.setText("FILTER");
    }

    private void showFilter()
    {
        searchView.setVisibility(View.VISIBLE);
        filterView1.setVisibility(View.VISIBLE);
        filterView2.setVisibility(View.VISIBLE);
        filterView3.setVisibility(View.VISIBLE);
        filterView4.setVisibility(View.VISIBLE);
        filterView5.setVisibility(View.VISIBLE);
        filterButton.setText("HIDE");
    }

    private void setAdapter(ArrayList<Shape> shapeList)
    {
        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }
}