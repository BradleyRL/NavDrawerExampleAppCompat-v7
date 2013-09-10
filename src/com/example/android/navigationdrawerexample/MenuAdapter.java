package com.example.android.navigationdrawerexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] Ids;    
    
    static class ViewHolder { 
    	TextView text;
    	public ImageView image;
    }

    public MenuAdapter(Context context, String[] objects) {
        super(context, R.layout.drawer_list_item, objects);
        this.context = context;
        this.Ids = objects;      
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	View rowView = convertView;
    	ViewHolder viewHolder;
    	if (rowView == null) {
    	      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	      rowView = inflater.inflate(R.layout.drawer_list_item, null);
    	      viewHolder = new ViewHolder();
    	      viewHolder.text = (TextView) rowView.findViewById(R.id.text1);
    	      viewHolder.image = (ImageView) rowView.findViewById(R.id.imageView);
    	      rowView.setTag(viewHolder);
    		} 
    		else { 
    			viewHolder = (ViewHolder) rowView.getTag(); 
        } 
    	    	       
        int id = Integer.parseInt(Ids[position]);
        int imageFile = MainMenu.GetbyId(id).IconFile;        
        viewHolder.text.setText(MainMenu.GetbyId(id).Name);        
        viewHolder.image.setImageDrawable(context.getResources().getDrawable(imageFile));
        return rowView;       
    }

}