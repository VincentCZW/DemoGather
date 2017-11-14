package com.example.annotation_tool.demogather.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.annotation_tool.demogather.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by VincentChen on 2016/12/21.
 */
public class RetrofitActivity extends Activity {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_main_layout);
        initViews();
        bindListerners();
    }

    private void initViews() {
        btn1 = (Button) findViewById(R.id.btn_1);
    }

    private void bindListerners() {
        btn1.setOnClickListener(clickListener);
    }

    private void testNetRequestOne() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<ResponseBody> call = service.contributeBySimpleGetCall("square", "retrofit");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("Vincent", "response = " + response.body());
                Gson gson = new Gson();
                ArrayList<Contributor> contributorsList = null;
                try {
                    contributorsList = gson.fromJson(response.body().string(), new TypeToken<List<Contributor>>(){}.getType());
                    for (Contributor contributor : contributorsList){
                        Log.d("login",contributor.getLogin());
                        Log.d("contributions",contributor.getContributions()+"");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Vincent", "加载失败 onFailure()" + t.toString() +"      " + t.getMessage());
            }
        });
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_1:
                    testNetRequestOne();
                    break;
            }
        }
    };


    public interface GitHubService {
        @GET("repos/{owner}/{repo}/contributors")
        Call<ResponseBody> contributeBySimpleGetCall(@Path("owner") String owner, @Path("repo") String repo);
    }

    public class Contributor {
        private String login;
        private Integer contributions;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public Integer getContributions() {
            return contributions;
        }

        public void setContributions(Integer contributions) {
            this.contributions = contributions;
        }
    }
}
