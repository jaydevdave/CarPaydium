package com.example.jayde.carpaydium;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;


/**
 * Created by jayde on 08/05/2017.
 */

public class Bookingscreen extends AppCompatActivity {

    String topic1 = "slot1";
    String topic2 = "slot2";
    String topic3 = "slot3";
    String topic4 = "slot4";
    String topic5 = "slot5";
    String topic6 = "slot6";
    String topic7 = "slot7";
    String topic8 = "slot8";

    TextView text, lowertext;
    int counter = 60;
    Vibrator vibrator;
    boolean counterflag = false;

    int fail1=0;
    int fail2=0;
    int fail3=0;
    int fail4=0;
    int fail5=0;
    int fail6=0;
    int fail7=0;
    int fail8=0;


    MqttAndroidClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_screen);
        text = (TextView) findViewById(R.id.textView6);
        lowertext = (TextView) findViewById(R.id.textView8);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        final int flag1 = getIntent().getIntExtra("flag1", 0);
        final int flag2 = getIntent().getIntExtra("flag2", 0);
        final int flag3 = getIntent().getIntExtra("flag3", 0);
        final int flag4 = getIntent().getIntExtra("flag4", 0);
        final int flag5 = getIntent().getIntExtra("flag5", 0);
        final int flag6 = getIntent().getIntExtra("flag6", 0);
        final int flag7 = getIntent().getIntExtra("flag7", 0);
        final int flag8 = getIntent().getIntExtra("flag8", 0);




        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), "tcp://54.172.186.236:1883", clientId);

        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken)
                {
                    fail1=0;
                    fail2=0;
                    fail3=0;
                    fail4=0;
                    fail5=0;
                    fail6=0;
                    fail7=0;
                    fail8=0;
                    setsubscription();
                    counterflag=false;
                    counting();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(Bookingscreen.this, "Connection Failure", Toast.LENGTH_LONG).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }

        client.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {

            }

            @Override
            public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                String msg = mqttMessage.toString();
                if ((msg.compareTo("10") == 0) && (s.compareTo("slot1") == 0) && (counter<=0) && (flag1==1) && (fail1==0))
                {

                    oneparkedfail();

                }
                else if ((msg.compareTo("11") == 0) && (s.compareTo("slot1") == 0) && (counter>0) && (flag1==1))
                {
                   counterflag = true;
                    counting();
                   oneparkedsuccess();

                }
                else if ((msg.compareTo("20") == 0) && (s.compareTo("slot2") == 0) && (counter<=0) && (flag2==1) &&(fail2==0))
                {

                    twoparkedfail();

                }
                else if ((msg.compareTo("21") == 0) && (s.compareTo("slot2") == 0) && (counter>0) && (flag2==1))
                {
                    counterflag = true;
                    counting();
                    twoparkedsuccess();
                }

                else if ((msg.compareTo("30") == 0) && (s.compareTo("slot3") == 0) && (counter<=0) && (flag3==1) &&(fail3==0))
                {

                    threeparkedfail();

                }
                else if ((msg.compareTo("31") == 0) && (s.compareTo("slot3") == 0) && (counter>0) && (flag3==1))
                {
                    counterflag = true;
                    counting();
                    threeparkedsuccess();
                }

                else if ((msg.compareTo("40") == 0) && (s.compareTo("slot4") == 0) && (counter<=0) && (flag4==1) &&(fail4==0))
                {

                    fourparkedfail();

                }
                else if ((msg.compareTo("41") == 0) && (s.compareTo("slot4") == 0) && (counter>0) && (flag4==1))
                {
                    counterflag = true;
                    counting();
                    fourparkedsuccess();
                }

                else if ((msg.compareTo("50") == 0) && (s.compareTo("slot5") == 0) && (counter<=0) && (flag5==1) &&(fail5==0))
                {

                    fiveparkedfail();

                }
                else if ((msg.compareTo("51") == 0) && (s.compareTo("slot5") == 0) && (counter>0) && (flag5==1))
                {
                    counterflag = true;
                    counting();
                    fiveparkedsuccess();
                }

                else if ((msg.compareTo("60") == 0) && (s.compareTo("slot6") == 0) && (counter<=0) && (flag6==1) &&(fail6==0))
                {

                    sixparkedfail();

                }
                else if ((msg.compareTo("61") == 0) && (s.compareTo("slot6") == 0) && (counter>0) && (flag6==1))
                {
                    counterflag = true;
                    counting();
                    sixparkedsuccess();
                }

                else if ((msg.compareTo("70") == 0) && (s.compareTo("slot7") == 0) && (counter<=0) && (flag7==1) &&(fail7==0))
                {

                    sevenparkedfail();

                }
                else if ((msg.compareTo("71") == 0) && (s.compareTo("slot7") == 0) && (counter>0) && (flag7==1))
                {
                    counterflag = true;
                    counting();
                    sevenparkedsuccess();
                }

                else if ((msg.compareTo("80") == 0) && (s.compareTo("slot8") == 0) && (counter<=0) && (flag8==1) &&(fail8==0))
                {

                    eightparkedfail();

                }
                else if ((msg.compareTo("81") == 0) && (s.compareTo("slot8") == 0) && (counter>0) && (flag8==1))
                {
                    counterflag = true;
                    counting();
                    eightparkedsuccess();
                }

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });
    }


    private void counting()
    {

            new CountDownTimer(62000,1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    if(counterflag==false)
                    {
                        text.setText(String.valueOf(counter));
                        counter--;
                    }
                    else if(counterflag==true)
                    {
                        counter=0;
                        cancel();
                        text.setTextSize(20);
                        text.setText("Parked Successfully!");
                        lowertext.setText("            ");
                    }

                }
                public void onFinish()
                {

                }

            }.start();
    }


    private void oneparkedsuccess()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Parked successfully at slot 1");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void oneparkedfail()
    {
        vibrator.vibrate(500);
        fail1=1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Not parked in defined time at slot 1");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void twoparkedsuccess()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Parked successfully at slot 2");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void twoparkedfail()
    {
        vibrator.vibrate(500);
        fail2=1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Not parked in defined time at slot 2");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void threeparkedsuccess()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Parked successfully at slot 3");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void threeparkedfail()
    {
        vibrator.vibrate(500);
        fail3=1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Not parked in defined time at slot 3");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void fourparkedsuccess()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Parked successfully at slot 4");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void fourparkedfail()
    {
        vibrator.vibrate(500);
        fail4=1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Not parked in defined time at slot 4");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void fiveparkedsuccess()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Parked successfully at slot 5");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void fiveparkedfail()
    {
        vibrator.vibrate(500);
        fail5=1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Not parked in defined time at slot 5");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void sixparkedsuccess()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Parked successfully at slot 6");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void sixparkedfail()
    {
        vibrator.vibrate(500);
        fail6=1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Not parked in defined time at slot 6");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void sevenparkedsuccess()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Parked successfully at slot 7");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void sevenparkedfail()
    {
        vibrator.vibrate(500);
        fail7=1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Not parked in defined time at slot 7");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void eightparkedsuccess()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Parked successfully at slot 8");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }

    private void eightparkedfail()
    {
        vibrator.vibrate(500);
        fail8=1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Not parked in defined time at slot 8");
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
    }




    private void setsubscription() {
        try {
            client.subscribe(topic1, 0);
            client.subscribe(topic2, 0);
            client.subscribe(topic3, 0);
            client.subscribe(topic4, 0);
            client.subscribe(topic5, 0);
            client.subscribe(topic6, 0);
            client.subscribe(topic7, 0);
            client.subscribe(topic8, 0);

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}