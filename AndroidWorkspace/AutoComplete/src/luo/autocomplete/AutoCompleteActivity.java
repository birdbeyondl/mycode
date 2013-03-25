package luo.autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteActivity extends Activity implements TextWatcher{
	
	TextView selection;
	AutoCompleteTextView editor;
	String[] items = {
		"wust","wo","luo","tingsheng","xufangfang","daijianjun","daiximeng"	
	};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        selection = (TextView)findViewById(R.id.con_str);
        editor = (AutoCompleteTextView) findViewById(R.id.editor);
        editor.addTextChangedListener(this);
        editor.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,items));     
    }

	public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
	}

	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		selection.setText(editor.getText());
	}
}