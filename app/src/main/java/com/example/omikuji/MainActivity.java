package com.example.omikuji;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	// イメージリソースを管理する配列
	int imgResources[] = {R.drawable.daikichi, R.drawable.kichi, R.drawable.kyou};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//ボタンのイベントリスナーとしてFortuneBtnClickLitenerを登録
		Button fortuneBtn = (Button) findViewById(R.id.fortuneBtn);
		fortuneBtn.setOnClickListener(new FortuneBtnClickListener());
	}



	//ボタンのイベントリスナー
	public class FortuneBtnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v){
			//0から2までの乱数を求める
			Random random = new Random();
			int randomNum = random.nextInt(3);

			//ImageViewを取得
			ImageView fortuneView = (ImageView) findViewById(R.id.fortuneView);

			//イメージを表示
			fortuneView.setImageResource(imgResources[randomNum]);

			//アニメーションを設定
			Animation fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
			fortuneView.startAnimation(fadeIn);
		}
	}
}