package com.example.menusample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //リストビューを表すフィールド
    private ListView _lvMenu;
    //リストビューに表示するリストデータ
    private List<Map<String,Object>>_menuList;
    //SimpleAdapterの第4引数fromニスようする定数フィールド
    private static final String[] FROM = {"name","price"};
    //SimpleAdapterの第5引数toに使用する定数フィールド
    private static final int[] TO = {R.id.tvMenuNameRow, R.id.tvMenuPriceRow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //画面部品ListViewを取得し、フィールドに格納。
        _lvMenu = findViewById(R.id.lvMenu);
        //定食メニューListオブジェクトをprivateメソッドを利用して用意し、フィールドに格納
        _menuList = createTeishokuList();
        //SimpleAdapterを生成
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,_menuList,R.layout.row,FROM,TO);
            //アダプタ登録
            _lvMenu.setAdapter(adapter);
            //リストタップのリスナクラス登録
            _lvMenu.setOnItemClickListener(new ListItemClickListener());

    }


    @NonNull
    private List<Map<String, Object>> createTeishokuList(){
    //定食メニューリスト用のListオブジェクトを用意。
    List<Map<String, Object>> menuList = new ArrayList<>();
    //唐揚げ定食のデータ格納するMapオブジェクトの作成とmenuListへのデータ登録
    Map<String, Object> menu = new HashMap<>();
        menu.put("name", "唐揚げ定食");
        menu.put("price", 800);
        menu.put("desc", "若鳥のから揚げにサラダとごはんとみそ汁がつきます");
        menuList.add(menu);

    //ハンバーグのデータ格納と登録
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねハンバーグとサラダと、ごはんと味噌汁がつきます");
        menuList.add(menu);

    //生姜焼き定食の格納と登録
        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc", "生姜焼きとサラダと、ごはんと味噌汁がつきます");
        menuList.add(menu);

        //ステーキ定食
        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("desc", "ステーキとサラダと、ごはんと味噌汁がつきます");
        menuList.add(menu);

    //野菜炒め定食
        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 750);
        menu.put("desc", "野菜炒めとサラダと、ごはんと味噌汁がつきます");
        menuList.add(menu);

    //とんかつ定食
        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("desc", "とんかつとサラダと、ごはんと味噌汁がつきます");
        menuList.add(menu);

    //ミンチカツ定食
        menu = new HashMap<>();
        menu.put("name", "ミンチカツ定食");
        menu.put("price", 850);
        menu.put("desc", "ミンチカツとサラダと、ごはんと味噌汁がつきます");
        menuList.add(menu);

    //チキンカツ定食
        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("desc", "チキンカツとサラダと、ごはんと味噌汁がつきます");
        menuList.add(menu);

    //コロッケ定食
        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 850);
        menu.put("desc", "コロッケとサラダと、ごはんと味噌汁がつきます");
        menuList.add(menu);

    //回鍋肉定食
        menu = new HashMap<>();
        menu.put("name", "回鍋肉定食");
        menu.put("price", 750);
        menu.put("desc", "回鍋肉定食とサラダと、ごはんとスープがつきます");
        menuList.add(menu);

    //麻婆豆腐定食
        menu = new HashMap<>();
        menu.put("name", "麻婆豆腐定食");
        menu.put("price", 1000);
        menu.put("desc", "麻婆豆腐とサラダと、ごはんとスープがつきます");
        menuList.add(menu);

        return menuList;
    }

    //リストがタップされたときの処理
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //タップされた行のデータ取得。SimpleAdapterでは1行分のデータはMap型
            Map<String, Object> item = (Map<String, Object>)
                    parent.getItemAtPosition(position);
            //定食名と金額取得
            String menuName = (String) item.get("name");
            Integer menuPrice = (Integer) item.get("price");

            //インテントとオブジェクトを生成
            Intent intent = new Intent(MainActivity.this, MenuThankActivity.class);

            //第2画面に送るデータを格納
            intent.putExtra("menuName", menuName);

            //MenuThanksActivityでデータ受け取りと合わせるために、金額にここで円を追加する
            intent.putExtra("menuPrice", menuPrice+"円");
            //第2画面の起動
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //メニューインフレーター取得
        MenuInflater inflater = getMenuInflater();

        //オプションメニュー用。xmlファイルをインフレート
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        return true;
    }
    private List<Map<String, Object>>createCurryList(){
        //カレーメニューリスト用のListオブジェクトを用意
        List<Map<String, Object>>menuList = new ArrayList<>();

        //ビーフカレーのデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        Map<String, Object>menu = new HashMap<>();
            menu.put("name","ビーフカレー");
            menu.put("price",520);
            menu.put("desc", "特選スパイスを聞かせた国産ビーフ100%のカレーです");
            menuList.add(menu);

        //ポークカレー
        menu = new HashMap<>();
        menu.put("name","ポークカレー");
        menu.put("price",420);
        menu.put("desc","特選スパイスを聞かせた国産100%のポークカレーです");
        menuList.add(menu);
        return menuList;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        boolean returnVal = true;

        int itemId = item.getItemId();

        switch(itemId){
            case R.id.menuListOptionTeishoku:
                _menuList = createTeishokuList();
                break;

            case R.id.menuListOptionCurry:
                _menuList = createCurryList();
                break;
            default:
                returnVal = super.onOptionsItemSelected(item);
                break;
        }
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menuList, R.layout.row, FROM, TO);
        _lvMenu.setAdapter(adapter);
        return returnVal;
    }
}