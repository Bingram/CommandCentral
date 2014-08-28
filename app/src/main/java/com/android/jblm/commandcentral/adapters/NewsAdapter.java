package com.android.jblm.commandcentral.adapters;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.android.jblm.commandcentral.R;
import com.android.jblm.commandcentral.objects.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Brian 2014
 * Based on example @http://www.tutorialspoint.com/android/android_xml_parsers.htm,
 * http://www.vogella.com/tutorials/AndroidListView/article.html#exercise_listsactivity_simple
 */
public class NewsAdapter extends BaseExpandableListAdapter{

    private Context context;//parent view
    public LayoutInflater inflater;//view inflater
    public Activity activity;//parent activity
    List<String> postTitles;//list of post titles
    HashMap<String, Post> postItems;//hash map of posts to titles


    //News Adapter class, process XML file for listview information
    //Using the ViewHolder pattern, each item on a list can be "recycled"
    //by storing them in a hash map after their view has been removed
    public NewsAdapter(Context c, List<Post> objects) {

        this.context = c;
        postTitles = new ArrayList<String>();
        postItems = new HashMap<String, Post>();

        for(int i = 0; i < objects.size(); i++){

            readPost(objects.get(i).getPostTitle(),objects.get(i));

        }
    }

    /**
     * Reads a post into the list
     * @param s Title of post
     * @param p Post object
     */
    private void readPost(String s, Post p) {

        postTitles.add(p.getPostTitle());
        postItems.put(s,p);

    }

    /**
     * Returns the post with the given group/title position on main list
     * @param groupPosition//position on ExpandableListview, with post title
     * @param childPosition//not used, kept for consistency
     * @return child post object in postItems
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return postItems.get(postTitles.get(groupPosition));
    }

    /**
     *
     * @param groupPosition//position on main list
     * @param childPosition//always zero as their is only one object per title
     * @return ZERO
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * Using ViewHolder pattern the child view is only created if it is not
     * initialized yet, creates it and adds to the NewsViewHolder HashMap
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        if (convertView == null)//if view not set yet, create and add
        {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);

        }

        final Post p = postItems.get(postTitles.get(groupPosition));//get corresponding post
        TextView desc = (TextView) convertView.findViewById(R.id.postDesc);//set views description
        TextView link = (TextView) convertView.findViewById(R.id.postLink);//set link from post
        desc.setText(p.getPostDesc());
        link.setText("Visit Website");

        //set onclicklistener description in child view to take user to website link.
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent internetIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(p.getPostURL()));
                internetIntent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
                internetIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(internetIntent);

            }
        });

        return convertView;
    }

    /**
     * Returns 1 as only 1 post per title on main list
     * @param groupPosition//position on main list
     * @return 1
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    /**
     *
     * @param groupPosition
     * @return
     */
    @Override
    public Object getGroup(int groupPosition) {
        return postItems.get(groupPosition);
    }

    /**
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        return (postItems == null)? 0 : postItems.size();
    }

    /**
     *
     * @param groupPosition
     */
    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    /**
     *
     * @param groupPosition
     */
    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    /**
     *
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * Ses up the view for a post in the un-expanded list, takes the position
     * then sets the title and date from list of titles and posts
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_groupped, parent, false);

        }


        TextView theTitle = (TextView) convertView.findViewById(R.id.headerText);
        TextView theDate = (TextView) convertView.findViewById(R.id.dateText);
        theTitle.setText(postTitles.get(groupPosition));
        theDate.setText(postItems.get(postTitles.get(groupPosition)).getPostDate());

        return convertView;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
