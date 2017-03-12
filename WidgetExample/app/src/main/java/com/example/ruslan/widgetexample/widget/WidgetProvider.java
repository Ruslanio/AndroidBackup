package com.example.ruslan.widgetexample.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.ruslan.widgetexample.R;

/**
 * Created by Ruslan on 27.01.2017.
 */

public class WidgetProvider extends AppWidgetProvider {

    public final static String ACTION_WIDGET_RECEIVER = "ActionReceiverWidget";
    private static int COUNT = 1;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);

        Intent intent = new Intent(context,WidgetProvider.class);
        intent.setAction(ACTION_WIDGET_RECEIVER);
        intent.putExtra("count","Button pressed : " + COUNT);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);

        remoteViews.setOnClickPendingIntent(R.id.btn,pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetIds,remoteViews);

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if(ACTION_WIDGET_RECEIVER.equals(action)){
            String count = "null";
            try {
                count = intent.getStringExtra("count");
            }catch (NullPointerException e){
                Toast.makeText(context,"Error!",Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(context,count,Toast.LENGTH_LONG).show();
            COUNT += 1;
        }
        super.onReceive(context, intent);
    }
}
