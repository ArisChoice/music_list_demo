package controler;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import adapter.AudioItemAdapter;
import music.player.recyclar.com.R;

public class MainActivity extends Activity {

    private AudioItemAdapter audioItemAdapter;

    // POJO to hold data about audio items
    public static class AudioItem {
        // raw resource id of audio cell
        final int audioResId;

        private AudioItem(int audioResId) {
            this.audioResId = audioResId;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);

        // arrange cells in vertical column
        rv.setLayoutManager(new LinearLayoutManager(this));

        // add 256 stub audio items
        ArrayList<AudioItem> audioItems = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            audioItems.add(new AudioItem(R.raw.mp3));
        }
        audioItemAdapter = new AudioItemAdapter(audioItems, this);
        rv.setAdapter(audioItemAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        audioItemAdapter.stopPlayer();
    }


}
