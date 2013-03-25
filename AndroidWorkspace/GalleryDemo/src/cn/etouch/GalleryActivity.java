package cn.etouch;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

public class GalleryActivity extends Activity
{

	private Gallery gallery;
    private ImageView btnLeft,btnRight,recent;
	private int[] resIds=new int[] {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,
			R.drawable.p6,R.drawable.p7};
    private String[] name  = {"喜爱的","最近","作者","按标签","按标题","文件树","更多"};
	//private Drawable[] resIds ;
    
    
public class ButtonAdapter extends BaseAdapter{
	LayoutInflater inflater;
	int mGalleryItemBackground;
    private Context mContext;
    Holder holder;

	public ButtonAdapter(Context c)
	{
		mContext=c;
		//TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
        //mGalleryItemBackground = typedArray.getResourceId(R.styleable.Gallery_android_galleryItemBackground, 0);  
	}
	
	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		inflater = LayoutInflater.from(mContext);
		if (convertView == null) {
			convertView = inflater.inflate(
					R.layout.toolbar_row, null);
			holder = new Holder();
			holder.img = (ImageView) convertView
					.findViewById(R.id.bar_img);
			holder.title = (TextView) convertView
					.findViewById(R.id.bar_title);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		holder.img.setBackgroundResource(resIds[position % resIds.length]);
		holder.title.setText(name[position % resIds.length]);
		
		return convertView;
//		ImageView imageView = new ImageView(mContext);
//		
//       
//		imageView.setImageResource(resIds[position % resIds.length]);
//		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//		imageView.setLayoutParams(new Gallery.LayoutParams(163, 106));
//		//imageView.setBackgroundResource(mGalleryItemBackground);
//		return imageView;
	}
}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnLeft = (ImageView)findViewById(R.id.BtnLeft);
        btnRight = (ImageView)findViewById(R.id.BtnRight);
        btnLeft.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//gallery.getLeft();
				int position = gallery.getSelectedItemPosition();
				if(position==0)
					position = 7;
				gallery.setSelection(position-1);
			}
		});
        btnRight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Toast.makeText(GalleryActivity.this, gallery.getNextFocusRightId(), Toast.LENGTH_SHORT).show();
				int position = gallery.getSelectedItemPosition();
				gallery.setSelection(position+1);
			}
		});
       // CutIcon cut = new CutIcon(resIds, "");
       //resIds = cut.cutIcon("50", "50);
        gallery=(Gallery)findViewById(R.id.gg);
        ButtonAdapter buttonadapter=new ButtonAdapter(this);
        gallery.setAdapter(buttonadapter);
        gallery.setBackgroundResource(R.drawable.gallerybg);
        
       // gallery.setOnItemSelectedListener(this);
  
    }
    class Holder {
    	ImageView img;
    	TextView title;
    }
	
	
}

