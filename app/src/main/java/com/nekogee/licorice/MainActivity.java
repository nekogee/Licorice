package com.nekogee.licorice;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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

public class MainActivity extends AppCompatActivity {

    private final int SINGLE = 0;
    private final int LOOP = 1;

    private boolean isPlaying = false;
    private boolean isPlaying2 = false;
    private boolean isPlaying3 = false;
    private boolean isPlaying4 = false;
    private boolean isPlaying5 = false;
    private boolean isPlaying6 = false;
    private boolean isPlaying7 = false;
    private boolean isEditing = false;

    private ImageView imageView;
    private ImageView imageViewLoop;
    private ImageView imageViewEdit;

    private SimpleExoPlayer exoPlayer1;
    private SimpleExoPlayer exoPlayer2;
    private SimpleExoPlayer exoPlayer3;
    private SimpleExoPlayer exoPlayer4;
    private SimpleExoPlayer exoPlayer5;
    private SimpleExoPlayer exoPlayer6;
    private SimpleExoPlayer exoPlayer7;

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
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        exoPlayer1 = newPlayer();
        exoPlayer2 = newPlayer();
        exoPlayer3 = newPlayer();
        exoPlayer4 = newPlayer();
        exoPlayer5 = newPlayer();
        exoPlayer6 = newPlayer();
        exoPlayer7 = newPlayer();

        ButtonInfo buttonInfo1 = new ButtonInfo(R.id.ImageView_1,exoPlayer1,R.raw.drum_break,SINGLE,false);
        ButtonInfo buttonInfo2 = new ButtonInfo(R.id.ImageView_2,exoPlayer2,R.raw.shaker,LOOP,false);
        ButtonInfo buttonInfo3 = new ButtonInfo(R.id.ImageView_3,exoPlayer3,R.raw.piano,SINGLE,false);
        ButtonInfo buttonInfo4 = new ButtonInfo(R.id.ImageView_4,exoPlayer4,R.raw.tappy_hats,SINGLE,false);
        ButtonInfo buttonInfo5 = new ButtonInfo(R.id.ImageView_5,exoPlayer5,R.raw.tiny_piano,SINGLE,false);
        ButtonInfo buttonInfo6 = new ButtonInfo(R.id.ImageView_6,exoPlayer6,R.raw.subs,SINGLE,false);
        ButtonInfo buttonInfo7 = new ButtonInfo(R.id.ImageView_7,exoPlayer7,R.raw.soft_pads,SINGLE,false);

        initPlayButton(buttonInfo1);
        initPlayButton(buttonInfo2);
        initPlayButton(buttonInfo3);
        initPlayButton(buttonInfo4);
        initPlayButton(buttonInfo5);
        initPlayButton(buttonInfo6);
        initPlayButton(buttonInfo7);

    }

    class ButtonInfo {
        private int resID;
        private SimpleExoPlayer exoPlayer;
        private int musicID;
        private int mode;
        private boolean isPlaying;

        ButtonInfo(int resID,SimpleExoPlayer exoPlayer,int musicID,int mode,boolean isPlaying) {
            this.resID = resID;
            this.exoPlayer = exoPlayer;
            this.musicID = musicID;
            this.mode = mode;
            this.isPlaying = isPlaying;
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

        public void setPlaying(boolean playing) {
            isPlaying = playing;
        }

        public void setResID(int resID) {
            this.resID = resID;
        }

        public boolean isPlaying() {
            return isPlaying;
        }

        public int getMusicID() {
            return musicID;
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
        switch (buttonInfo.getMode()){
            case SINGLE : {
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(buttonInfo.getExoPlayer().getPlaybackState()==Player.STATE_ENDED) {
                            //exoPlayer.setPlayWhenReady(true);
                            Log.d("neww", "onClick: ended");
                            singlePlay(buttonInfo.getExoPlayer(), buttonInfo.getMusicID());
                        }
                        else if(buttonInfo.isPlaying()) {
                            Log.d("neww", "onClick: "+buttonInfo.getExoPlayer().getPlaybackState());
                            buttonInfo.getExoPlayer().setPlayWhenReady(false);
                            //装箱
                            //isPlaying.
                            //isPlaying1 = !isPlaying1;
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
