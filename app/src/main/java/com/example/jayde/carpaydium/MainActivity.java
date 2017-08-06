package com.example.jayde.carpaydium;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {

    String topic1 = "slot1";
    String topic2 = "slot2";
    String topic3 = "slot3";
    String topic4 = "slot4";
    String topic5 = "slot5";
    String topic6 = "slot6";
    String topic7 = "slot7";
    String topic8 = "slot8";

    Button s1, s2, s3, s4, s5, s6, s7, s8;
    Vibrator vibrator;
    int btnflag1=0;
    int btnflag2=0;
    int btnflag3=0;
    int btnflag4=0;
    int btnflag5=0;
    int btnflag6=0;
    int btnflag7=0;
    int btnflag8=0;



    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        s1 = (Button) findViewById(R.id.button1);
        s2 = (Button) findViewById(R.id.button2);
        s3 = (Button) findViewById(R.id.button3);
        s4 = (Button) findViewById(R.id.button4);
        s5 = (Button) findViewById(R.id.button5);
        s6 = (Button) findViewById(R.id.button6);
        s7 = (Button) findViewById(R.id.button7);
        s8 = (Button) findViewById(R.id.button8);


        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), "tcp://54.172.186.236:1883", clientId);

        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(MainActivity.this,"Connected Successfully",Toast.LENGTH_LONG).show();
                    setsubscription();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(MainActivity.this,"Connection Failure",Toast.LENGTH_LONG).show();

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
                if(msg.compareTo("10")==0 && s.compareTo("slot1")==0){
                    s1.setBackgroundColor(Color.GREEN); //green
                    s1.setTextColor(Color.BLACK);
                    btnflag1=0;

                        s1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v)
                            {
                                if(btnflag1==0)
                                {
                                    firstslotnotification();
                                }
                            }
                        });



                }
                else if(msg.compareTo("11")==0 && s.compareTo("slot1")==0){
                    s1.setBackgroundColor(Color.RED); //red
                    s1.setTextColor(Color.WHITE);
                    btnflag1=1;
                }
                else if(msg.compareTo("20")==0 && s.compareTo("slot2")==0){
                    s2.setBackgroundColor(Color.GREEN); //green
                    s2.setTextColor(Color.BLACK);
                    btnflag2=0;

                    s2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            if(btnflag2==0)
                            {
                                secondslotnotification();
                            }
                        }
                    });
                }
                else if(msg.compareTo("21")==0 && s.compareTo("slot2")==0){
                    s2.setBackgroundColor(Color.RED); //red
                    s2.setTextColor(Color.WHITE);
                    btnflag2=1;
                }
                else if(msg.compareTo("30")==0 && s.compareTo("slot3")==0){
                    s3.setBackgroundColor(Color.GREEN); //green
                    s3.setTextColor(Color.BLACK);
                    btnflag3=0;

                    s3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            if(btnflag3==0)
                            {
                                thirdslotnotification();
                            }

                        }
                    });
                }
                else if(msg.compareTo("31")==0 && s.compareTo("slot3")==0){
                    s3.setBackgroundColor(Color.RED); //red
                    s3.setTextColor(Color.WHITE);
                    btnflag3=1;
                }
                else if(msg.compareTo("40")==0 && s.compareTo("slot4")==0){
                    s4.setBackgroundColor(Color.GREEN); //green
                    s4.setTextColor(Color.BLACK);
                    btnflag4=0;

                    s4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            if(btnflag4==0)
                            {
                                fourthslotnotification();
                            }
                        }
                    });
                }
                else if(msg.compareTo("41")==0 && s.compareTo("slot4")==0){
                    s4.setBackgroundColor(Color.RED); //red
                    s4.setTextColor(Color.WHITE);
                    btnflag4=1;
                }
                else if(msg.compareTo("50")==0 && s.compareTo("slot5")==0){
                    s5.setBackgroundColor(Color.GREEN);  //green
                    s5.setTextColor(Color.BLACK);
                    btnflag5=0;

                    s5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            if(btnflag5==0)
                            {
                                fifthslotnotification();
                            }

                        }
                    });
                }
                else if(msg.compareTo("51")==0 && s.compareTo("slot5")==0){
                    s5.setBackgroundColor(Color.RED); //red
                    s5.setTextColor(Color.WHITE);
                    btnflag5=1;
                }
                else if(msg.compareTo("60")==0 && s.compareTo("slot6")==0){
                    s6.setBackgroundColor(Color.GREEN); //green
                    s6.setTextColor(Color.BLACK);
                    btnflag6=0;

                    s6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            if(btnflag6==0)
                            {
                                sixthslotnotification();
                            }

                        }
                    });
                }
                else if(msg.compareTo("61")==0 && s.compareTo("slot6")==0){
                    s6.setBackgroundColor(Color.RED); //red
                    s6.setTextColor(Color.WHITE);
                    btnflag6=1;
                }
                else if(msg.compareTo("70")==0 && s.compareTo("slot7")==0){
                    s7.setBackgroundColor(Color.GREEN); //green
                    s7.setTextColor(Color.BLACK);
                    btnflag7=0;

                    s7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            if(btnflag7==0)
                            {
                                seventhslotnotification();
                            }
                        }
                    });
                }
                else if(msg.compareTo("71")==0 && s.compareTo("slot7")==0){
                    s7.setBackgroundColor(Color.RED);  //red
                    s7.setTextColor(Color.WHITE);
                    btnflag7=1;
                }
                else if(msg.compareTo("80")==0 && s.compareTo("slot8")==0){
                    s8.setBackgroundColor(Color.GREEN); //green
                    s8.setTextColor(Color.BLACK);
                    btnflag8=0;

                    s8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            if(btnflag8==0)
                            {
                                eigthslotnotification();
                            }

                        }
                    });
                }
                else if(msg.compareTo("81")==0 && s.compareTo("slot8")==0){
                    s8.setBackgroundColor(Color.RED); //red
                    s8.setTextColor(Color.WHITE);
                    btnflag8=1;
                }
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });
    }

    private void firstslotnotification()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Slot 1 chosen to park!");
        Intent intent = new Intent(this, Bookingscreen.class);
        intent.putExtra("flag1",1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Bookingscreen.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());

    }

    private void secondslotnotification()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Slot 2 chosen to park!");
        Intent intent = new Intent(this, Bookingscreen.class);
        intent.putExtra("flag2",1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Bookingscreen.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());

    }

    private void thirdslotnotification()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Slot 3 chosen to park!");
        Intent intent = new Intent(this, Bookingscreen.class);
        intent.putExtra("flag3",1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Bookingscreen.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());

    }

    private void fourthslotnotification()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Slot 4 chosen to park!");
        Intent intent = new Intent(this, Bookingscreen.class);
        intent.putExtra("flag4",1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Bookingscreen.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());

    }

    private void fifthslotnotification()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Slot 5 chosen to park!");
        Intent intent = new Intent(this, Bookingscreen.class);
        intent.putExtra("flag5",1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Bookingscreen.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());

    }

    private void sixthslotnotification()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Slot 6 chosen to park!");
        Intent intent = new Intent(this, Bookingscreen.class);
        intent.putExtra("flag6",1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Bookingscreen.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());

    }

    private void seventhslotnotification()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Slot 7 chosen to park!");
        Intent intent = new Intent(this, Bookingscreen.class);
        intent.putExtra("flag7",1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Bookingscreen.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());

    }
    private void eigthslotnotification()
    {
        vibrator.vibrate(500);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("CarPaydium Notification");
        builder.setContentText("Slot 8 chosen to park!");
        Intent intent = new Intent(this, Bookingscreen.class);
        intent.putExtra("flag8",1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Bookingscreen.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());

    }

    private void setsubscription(){
        try{
            client.subscribe(topic1,0);
            client.subscribe(topic2,0);
            client.subscribe(topic3,0);
            client.subscribe(topic4,0);
            client.subscribe(topic5,0);
            client.subscribe(topic6,0);
            client.subscribe(topic7,0);
            client.subscribe(topic8,0);
        } catch (MqttException e){
            e.printStackTrace();
        }
    }
}
