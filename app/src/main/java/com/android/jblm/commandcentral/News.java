package com.android.jblm.commandcentral;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.AbsListView;
import android.widget.ExpandableListView;

import com.android.jblm.commandcentral.adapters.NewsAdapter;
import com.android.jblm.commandcentral.generators.NewsBuilder;
import com.android.jblm.commandcentral.objects.Post;

import java.util.List;

/**
 * Created by Brian 2014
 *
 * Reads RSS feed from website and lists posts by title and date with expandable
 * sub-views containing brief description and web link.
 *
 * Based on example @http://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/
 */
public class News extends Activity {

    NewsAdapter listAdapter;//Adapter to handle Post View creation
    ExpandableListView listView;//View widget to display posts from adapter
    InnerNewsBuilder builder;//Builds the news from XML
    List<Post> myPosts;//Posts to be displayed in this activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        /**
         * The news builder is an asychronous task so as to keep the
         * UI responsive while the posts are built from XML source
         */

        builder = new InnerNewsBuilder();
        builder.execute("");//News builder executes its thread

    }

    /**
     * Receives a list of Post objects to display using adapter
     * and expandable list view activities.
     *
     * This method is called by inner class innerNewsBuilder
     *
     * @param theList List of Post objects
     */
    protected void setupListView(List<Post> theList){

        //Swipe layout for displaying the news list so it can swept down for a refresh
        final SwipeRefreshLayout swipeView = (SwipeRefreshLayout) findViewById(R.id.swipeNews);

        myPosts = theList;//assign list passed in as current news activity list of posts

        swipeView.setEnabled(false);//swipe refresh is disbaled until list is fully built

        //Expandable list view widget newsList in news layout
        listView = (ExpandableListView) findViewById(R.id.newsList);

        listAdapter = new NewsAdapter(this, myPosts);

        listView.setAdapter(listAdapter);

        swipeView.setColorScheme(android.R.color.holo_blue_dark, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_green_light);
        swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeView.setRefreshing(true);//set refresh animation start
                ( new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        builder.refreshList();//currently does nothing

                        //stop animation after refresh of information
                        swipeView.setRefreshing(false);

                    }
                }, 3000);//3 second delay
            }
        });

        /**
         * Scroll listener that detects when the top item is first visible.
         * Otherwise refresh gets started on every swipe down
         */
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            //Controls the checking for first item
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem == 0)//is first item visible the first post?
                    swipeView.setEnabled(true);
                else
                    swipeView.setEnabled(false);
            }
        });

    }

    /**
     * Asynchronous inner class that handles fetching of posts in separate thread
     * onPostExecute is called when post thread completes, passing the list
     * back to the method setupListView in news activity
     */
    class InnerNewsBuilder extends AsyncTask<String, Integer, List<Post>>{

        NewsBuilder list;

        protected List<Post> doInBackground(String... params) {
            list = new NewsBuilder();

            return list.getThePosts();
        }

        @Override
        protected void onPostExecute(List<Post> result){
            //TODO

            setupListView(result);

        }

        @Override
        protected void onProgressUpdate(Integer... values){

            //Nothing
        }

        public void refreshList(){
            list = new NewsBuilder();
            myPosts = list.getThePosts();
        }
    }

}
