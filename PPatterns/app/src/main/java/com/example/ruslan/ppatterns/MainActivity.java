package com.example.ruslan.ppatterns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ruslan.ppatterns.lists.User;
import com.example.ruslan.ppatterns.lists.UserAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUsers();

        recyclerView = (RecyclerView) findViewById(R.id.rv_user_list);
        adapter = new UserAdapter(users);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initUsers() {
        users = new ArrayList<>();

        users.add(new User("Вася","Попов","vp@email.ru"));
        users.add(new User("Жан","Клод","jk@email.ru"));
        users.add(new User("Арнольд","Шварцнеггер","as@email.ru"));
        users.add(new User("Чак","Норрис","cn@email.ru"));
        users.add(new User("Парень","Стретьегоподъезда","ps@email.ru"));
        users.add(new User("Мухаммед","Али","ma@email.ru"));
        users.add(new User("Майк","Тайсон","mt@email.ru"));
        users.add(new User("Джимми","Хендрикс","jh@email.ru"));
        users.add(new User("Чак","Берри","cb@email.ru"));
        users.add(new User("Кирк","Хаммет","kh@email.ru"));
        users.add(new User("Джаварахвал","Неру","jn@email.ru"));
    }
}
