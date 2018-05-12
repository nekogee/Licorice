package com.nekogee.licorice;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;

/**
 * Created by hui jie on 2018/4/26.
 */

public class PerformActivity extends AppCompatActivity {

    private final int SINGLE = 0;
    private final int LOOP = 1;
    private final int SHORT = 0;
    private final int LONG = 1;

    private ImageView imageView;
    private ImageView imageViewLoop;
    private ImageView imageViewEdit;

    LottieAnimationView animationView;
    LottieAnimationView animationView1;

    RawResourceDataSource rawResourceDataSource;

    private Player.EventListener eventListener = new Player.EventListener() {
        @Override
        public void onTimelineChanged(Timeline timeline, Object manifest) {

        }

        @Override
        public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

        }

        @Override
        public void onLoadingChanged(boolean isLoading) {

        }

        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

        }

        @Override
        public void onRepeatModeChanged(int repeatMode) {

        }

        @Override
        public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

        }

        @Override
        public void onPlayerError(ExoPlaybackException error) {

        }

        @Override
        public void onPositionDiscontinuity(int reason) {

        }

        @Override
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

        }

        @Override
        public void onSeekProcessed() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perform);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        SimpleExoPlayer exoPlayer1;
        SimpleExoPlayer exoPlayer2;
        SimpleExoPlayer exoPlayer3;
        SimpleExoPlayer exoPlayer4;
        SimpleExoPlayer exoPlayer5;
        SimpleExoPlayer exoPlayer6;
        SimpleExoPlayer exoPlayer7;
        SimpleExoPlayer exoPlayer11;
        SimpleExoPlayer  exoPlayer10;
        SimpleExoPlayer exoPlayer12;
        SimpleExoPlayer exoPlayer17;
        SimpleExoPlayer exoPlayer18;
        SimpleExoPlayer exoPlayer23;
        SimpleExoPlayer exoPlayer24;


        exoPlayer1 = newPlayer();
        exoPlayer2 = newPlayer();
        exoPlayer3 = newPlayer();
        exoPlayer4 = newPlayer();
        exoPlayer5 = newPlayer();
        exoPlayer6 = newPlayer();
        exoPlayer7 = newPlayer();
        exoPlayer10 = newPlayer();
        exoPlayer11 = newPlayer();
        exoPlayer12 = newPlayer();
        exoPlayer17 = newPlayer();
        exoPlayer18 = newPlayer();
        exoPlayer23 = newPlayer();
        exoPlayer24 = newPlayer();

        //Piano low
        ButtonInfo buttonInfo6 = new ButtonInfo(R.id.ImageView_6,exoPlayer6,R.raw.piano_b3,R.raw.rejection,SINGLE,SHORT);
        ButtonInfo buttonInfo12 = new ButtonInfo(R.id.ImageView_12,exoPlayer12,R.raw.piano_d4,R.raw.dyslexia,SINGLE,SHORT);
        ButtonInfo buttonInfo18 = new ButtonInfo(R.id.ImageView_18,exoPlayer18,R.raw.piano_g3,R.raw.estimate,SINGLE,SHORT);
        ButtonInfo buttonInfo24 = new ButtonInfo(R.id.ImageView_24,exoPlayer24,R.raw.piano_e4,R.raw.articulation,SINGLE,SHORT);
        ButtonInfo buttonInfo5 = new ButtonInfo(R.id.ImageView_5,exoPlayer5,R.raw.piano_g4,R.raw.mnemonics,SINGLE,SHORT);
        ButtonInfo buttonInfo11 = new ButtonInfo(R.id.ImageView_11,exoPlayer11,R.raw.piano_a3,R.raw.dyslexia,SINGLE,SHORT);

        ButtonInfo buttonInfo17 = new ButtonInfo(R.id.ImageView_17,exoPlayer17,R.raw.piano_d3,R.raw.rejection,SINGLE,SHORT);
        ButtonInfo buttonInfo23 = new ButtonInfo(R.id.ImageView_23,exoPlayer23,R.raw.piano_e3,R.raw.estimate,SINGLE,SHORT);

        initPlayButton(buttonInfo6);
        initPlayButton(buttonInfo12);
        initPlayButton(buttonInfo18);
        initPlayButton(buttonInfo24);
        initPlayButton(buttonInfo5);
        initPlayButton(buttonInfo11);

        initPlayButton(buttonInfo17);
        initPlayButton(buttonInfo23);

        //Piano high
        ButtonInfo buttonInfo4 = new ButtonInfo(R.id.ImageView_4,exoPlayer4,R.raw.piano_b_high,R.raw.estimate,SINGLE,LONG);
        ButtonInfo buttonInfo10 = new ButtonInfo(R.id.ImageView_10,exoPlayer10,R.raw.piano_high,R.raw.estimate,SINGLE,LONG);

        initPlayButton(buttonInfo4);
        initPlayButton(buttonInfo10);
        /*
        ButtonInfo buttonInfo1 = new ButtonInfo(R.id.ImageView_1,exoPlayer1,R.raw.drum_break,R.raw.articulation,SINGLE);
        ButtonInfo buttonInfo2 = new ButtonInfo(R.id.ImageView_2,exoPlayer2,R.raw.shaker,R.raw.dyslexia,LOOP);
        ButtonInfo buttonInfo3 = new ButtonInfo(R.id.ImageView_3,exoPlayer3,R.raw.piano,R.raw.estimate,SINGLE);
        ButtonInfo buttonInfo4 = new ButtonInfo(R.id.ImageView_4,exoPlayer4,R.raw.tappy_hats,R.raw.mnemonics,SINGLE);
        ButtonInfo buttonInfo7 = new ButtonInfo(R.id.ImageView_7,exoPlayer7,R.raw.soft_pads,R.raw.articulation,SINGLE);
*/
    }

    class ButtonInfo {
        private int resID;
        private SimpleExoPlayer exoPlayer;
        private int musicID;
        private int mode;
        private int animationID;
        private boolean isPlaying = false;
        private int kind;

        ButtonInfo(int resID,SimpleExoPlayer exoPlayer,int musicID,int animationID,int mode,int kind) {
            this.resID = resID;
            this.exoPlayer = exoPlayer;
            this.musicID = musicID;
            this.animationID = animationID;
            this.mode = mode;
            this.kind = kind;
            //this.isPlaying = isPlaying;
        }

        public void setExoPlayer(SimpleExoPlayer exoPlayer) {
            this.exoPlayer = exoPlayer;
        }

        public void setMode(int mode) {
            this.mode = mode;
        }

        public void setMusicID(int musicID) {
            this.musicID = musicID;
        }

        public void setAnimationID(int animationID) {
            this.animationID = animationID;
        }
        public void setPlaying(boolean playing) {
            isPlaying = playing;
        }

        public void setResID(int resID) {
            this.resID = resID;
        }

        public void setKind(int kind) {
            this.kind = kind;
        }

        public boolean isPlaying() {
            return isPlaying;
        }

        public int getMusicID() {
            return musicID;
        }
        public int getKind(){return kind;}
        public int getAnimationID() {
            return animationID;
        }
        public int getMode() {
            return mode;
        }

        public int getResID() {
            return resID;
        }

        public SimpleExoPlayer getExoPlayer() {
            return exoPlayer;
        }

    }
    private void initPlayButton(final ButtonInfo buttonInfo) {
        imageView = findViewById(buttonInfo.getResID());
        //imageView.requestFocus();
        animationView = findViewById(R.id.animationView);
        animationView1 = findViewById(R.id.animationView1);
        switch (buttonInfo.getMode()){
            case SINGLE : {
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        animationView.setAnimation(buttonInfo.getAnimationID());
                        animationView.playAnimation();
                        if(buttonInfo.kind==SHORT||buttonInfo.getExoPlayer().getPlaybackState()==Player.STATE_ENDED) {
                            //exoPlayer.setPlayWhenReady(true);
                            Log.d("neww", "onClick: ended");
                            singlePlay(buttonInfo.getExoPlayer(), buttonInfo.getMusicID());
                        }
                        else if(buttonInfo.isPlaying()) {
                            Log.d("neww", "onClick: "+buttonInfo.getExoPlayer().getPlaybackState());
                            buttonInfo.getExoPlayer().setPlayWhenReady(false);
                            buttonInfo.setPlaying(false);
                        }
                        else {
                            singlePlay(buttonInfo.getExoPlayer(), buttonInfo.getMusicID());
                           buttonInfo.setPlaying(true);
                        }
                    }
                });
            } break;
            case LOOP : {
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        animationView1.setAnimation(buttonInfo.getAnimationID());
                        animationView1.playAnimation();
                        if(buttonInfo.isPlaying) {
                            buttonInfo.getExoPlayer().setPlayWhenReady(false);
                            buttonInfo.setPlaying(false);
                        }
                        else {
                            loopPlay(buttonInfo.getExoPlayer(), buttonInfo.getMusicID());
                            buttonInfo.setPlaying(true);
                        }
                    }
                });
            } break;
            default:
        }

    }

    private SimpleExoPlayer newPlayer() {
        SimpleExoPlayer exoPlayer;
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory selectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(selectionFactory);
        exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
        return exoPlayer;
    }

    private void loopPlay(SimpleExoPlayer exoPlayer, int resID) {
        try {
            DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(resID));
            rawResourceDataSource = new RawResourceDataSource(this);
            rawResourceDataSource.open(dataSpec);
            DataSource.Factory factory = new DataSource.Factory() {
                @Override
                public DataSource createDataSource() {
                    return rawResourceDataSource;
                }
            };

            ExtractorMediaSource mediaSource = new ExtractorMediaSource(rawResourceDataSource.getUri(),
                    factory, new DefaultExtractorsFactory(), null, null);
            LoopingMediaSource loopingMediaSource = new LoopingMediaSource(mediaSource);
            exoPlayer.prepare(loopingMediaSource);
            exoPlayer.addListener(this.eventListener);
            exoPlayer.setPlayWhenReady(true);
        } catch (RawResourceDataSource.RawResourceDataSourceException e) {
            e.printStackTrace();
        }
    }

    private void singlePlay(SimpleExoPlayer exoPlayer, int resID) {
        try {
            DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(resID));
            rawResourceDataSource = new RawResourceDataSource(this);
            rawResourceDataSource.open(dataSpec);
            DataSource.Factory factory = new DataSource.Factory() {
                @Override
                public DataSource createDataSource() {
                    return rawResourceDataSource;
                }
            };

            ExtractorMediaSource mediaSource = new ExtractorMediaSource(rawResourceDataSource.getUri(),
                    factory, new DefaultExtractorsFactory(), null, null);

            exoPlayer.prepare(mediaSource);
            exoPlayer.addListener(this.eventListener);
            exoPlayer.setPlayWhenReady(true);
        } catch (RawResourceDataSource.RawResourceDataSourceException e) {
            e.printStackTrace();
        }
    }
}
