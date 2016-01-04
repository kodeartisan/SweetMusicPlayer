package com.huwei.sweetmusicplayer.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huwei.sweetmusicplayer.R;
import com.huwei.sweetmusicplayer.SweetApplication;
import com.huwei.sweetmusicplayer.baidumusic.po.Artist;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 歌手适配器
 *
 * @author jerry
 * @date 2016/01/05
 */
public class ArtistAdapter extends BaseAdapter {
    private Context mContext;
    private List<Artist> artists;

    ImageLoader imageLoader = SweetApplication.getImageLoader();

    public ArtistAdapter(Context context, List<Artist> artists) {
        this.mContext = context;
        this.artists = artists;
    }

    @Override
    public int getCount() {
        return artists.size();
    }

    @Override
    public Object getItem(int position) {
        return artists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listitem_online_artist, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_artist = (ImageView) convertView.findViewById(R.id.iv_artist);
            viewHolder.tv_artist = (TextView) convertView.findViewById(R.id.tv_artist);
            convertView.setTag(viewHolder);
        }

        final Artist artist = (Artist) getItem(position);
        viewHolder = (ViewHolder) convertView.getTag();

        imageLoader.displayImage(artist.avatar_middle, viewHolder.iv_artist);

        viewHolder.tv_artist.setText(artist.author);
        return convertView;
    }

    class ViewHolder {
        ImageView iv_artist;
        TextView tv_artist;
    }
}
