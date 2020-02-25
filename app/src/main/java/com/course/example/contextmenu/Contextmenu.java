package com.course.example.contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;
import android.widget.Toast;

public class Contextmenu extends Activity {

	private ImageView ImView;

	//Menu.FIRST is a constant of the Menu class used to define first menu item,
	//used by convention
	final int PICK1 = Menu.FIRST;
	final int PICK2 = Menu.FIRST + 1;
	final int PICK3 = Menu.FIRST + 2;
	final int PICK4 = Menu.FIRST + 3;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImView = (ImageView)findViewById(R.id.image);
        ImView.setImageResource(R.drawable.trek);
        
        registerForContextMenu(ImView);
    }
    
    @Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {		
		super.onCreateContextMenu(menu, v, menuInfo);
		//add a couple of options to the context menu
		menu.setHeaderTitle("Select Special Action");
		menu.add(0, PICK1, Menu.NONE, "Option-1 ONE ");
		menu.add(0, PICK2, Menu.NONE, "Option-2 TWO ");
		menu.add(0, PICK3, Menu.NONE, "Option-3 THREE ");
    }

	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		String title = item.getTitle().toString(); //get menu item title
		int itemId = item.getItemId();             //get menu item id
		Toast.makeText(this, title + " " + itemId, Toast.LENGTH_LONG).show();
		return false;
	}
}