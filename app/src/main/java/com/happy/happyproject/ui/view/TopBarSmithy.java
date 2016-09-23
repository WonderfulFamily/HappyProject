package com.happy.happyproject.ui.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.happy.happyproject.R;
import com.happy.happyproject.ui.SmithyShoppingCartActivity;

public class TopBarSmithy extends RelativeLayout implements View.OnClickListener {
    private static final String TAG = TopBarSmithy.class.getSimpleName();
    private ImageView mShoppingCart;
    private ImageView mSearch;



    public TopBarSmithy(Context context) {
        this(context,null);
    }

    public TopBarSmithy(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopBarSmithy(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.topbar_smithy, this,true);

        mShoppingCart = ((ImageView) view.findViewById(R.id.topar_shopping_cart));
        mSearch = ((ImageView) view.findViewById(R.id.topbar_search_home));
        mShoppingCart.setOnClickListener(this);
        mSearch.setOnClickListener(this);

}


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.topar_shopping_cart:

                Intent intent = new Intent(getContext(),SmithyShoppingCartActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.topbar_search:
                Toast.makeText(getContext(), "此功能暂时没有开放", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
