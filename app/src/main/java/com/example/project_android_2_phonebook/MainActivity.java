package com.example.project_android_2_phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PhoneBook> phoneBookList;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        PhoneBook phoneBook1 = new PhoneBook(
                "http://post.phinf.naver.net/MjAxNzEyMDhfNDIg/MDAxNTEyNzIxNDUyMzc4.Vo9sfxImkLvkGHRC9XdDL24GKu47He19K-2CN-tfpmcg.UB3tvdcrSGLB1FUP5Njgx724jG1G7l_Ph56xZBY52XIg.JPEG/IcFL8dbgYvPz4T_yqWEoDWEIdGUw.jpg",
                "홍길동",
                "010-1111-1111");

        PhoneBook phoneBook2 = new PhoneBook(
                "https://t1.daumcdn.net/cfile/tistory/991B36425DC0FF5408",
                "홍길동2",
                "010-1111-2222");

        PhoneBook phoneBook3 = new PhoneBook(
                "http://image.dongascience.com/Photo/2018/01/15159739972169[1].jpg",
                "홍길동3",
                "010-1111-3333");

        PhoneBook phoneBook4 = new PhoneBook(
                "https://pds.joins.com/news/component/htmlphoto_mmdata/201902/14/4cfe5c49-facc-4f98-8955-23772078dfc2.jpg",
                "홍길동4",
                "010-1111-4444");

        PhoneBook phoneBook5 = new PhoneBook(
                "https://images.mypetlife.co.kr/content/uploads/2019/09/04222847/dog-panting-1024x683.jpg",
                "홍길동5",
                "010-1111-5555");

        PhoneBook phoneBook6 = new PhoneBook(
                "https://pds.joins.com/news/component/htmlphoto_mmdata/201911/14/e0a8cabd-fc4e-4d41-aa9c-2d03371081c6.jpg",
                "홍길동6",
                "010-1111-6666");



        phoneBookList = new ArrayList<>();
        phoneBookList.add(phoneBook1);
        phoneBookList.add(phoneBook2);
        phoneBookList.add(phoneBook3);
        phoneBookList.add(phoneBook4);
        phoneBookList.add(phoneBook5);
        phoneBookList.add(phoneBook6);


        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        for(int i = 0; i < phoneBookList.size(); i++){
            View view = layoutInflater.inflate(R.layout.phonebook_item_view, null , false);
            TextView name = view.findViewById(R.id.name);
            TextView number = view.findViewById(R.id.number);
            ImageView imageView = view.findViewById(R.id.imageView);

            name.setText(phoneBookList.get(i).name);
            number.setText(phoneBookList.get(i).phone);

            RequestOptions circleOption = new RequestOptions().circleCrop();
            Glide.with(MainActivity.this)
                    .load(phoneBookList.get(i).url)
                    .apply(circleOption)
                    .into(imageView);


            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    String phone = phoneBookList.get(finalI).phone;
                    Log.d("test", phone);

                }
            });

            container.addView(view);
        }



    }
}
