package lj_3d.gearloadinglayout.gearViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import lj_3d.gearloadinglayout.R;
import lj_3d.gearloadinglayout.enums.ShowMode;
import lj_3d.gearloadinglayout.utils.DeviceScreenHelper;

/**
 * Created by LJ on 23.03.2016.
 */
public class OneGearLayout extends GearLoadingLayout{

    public static final String IDENTIFIER = "OneGearLayout";

    private GearView mFirstGearView;

    public OneGearLayout(Context context) {
        super(context);
        addChildView();
    }

    public OneGearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        addChildView();
        parseAttributes(attrs);
    }

    public OneGearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addChildView();
        parseAttributes(attrs);
    }

    private void addChildView() {
        final View childView = inflate(getContext(), R.layout.layout_one_gear, null);
        initUI(childView);
        addView(childView);
    }

    protected void initUI(View rootView) {
        super.initUI(rootView);
        initDimensions();
        mFirstGearView = (GearView) rootView.findViewById(R.id.gear_view);
    }

    private void initDimensions() {
        mDialogWidth = DeviceScreenHelper.mDeviceWidth;
        mDialogHeight = mResources.getDimensionPixelSize(R.dimen.three_gear_layout_wrapper_height);
    }

    public void start() {
        mFirstGearView.startSpinning(false);
    }

    public OneGearLayout setDuration(final int duration) {
        mFirstGearView.setDuration(duration);
        return this;
    }

    public OneGearLayout setFirstGearColor(int color) {
        mFirstGearView.setColor(color);
        return this;
    }

    public OneGearLayout setFirstGearInnerColor(int color) {
        setFirstGearInnerColor(color, false);
        return this;
    }

    private OneGearLayout setFirstGearInnerColor(int color, boolean enableCuttedCenter) {
        mFirstGearView.setInnerColor(color);
        mFirstGearView.enableCuttedCenter(enableCuttedCenter);
        return this;
    }

    public OneGearLayout setDialogBackgroundColor(int color) {
        super.setDialogBackgroundColor(color);
        return this;
    }

    public OneGearLayout setDialogBackgroundAlpha(float alpha) {
        super.setDialogBackgroundAlpha(alpha);
        return this;
    }

    public OneGearLayout setMainBackgroundColor(int color) {
        super.setMainBackgroundColor(color);
        return this;
    }

    public OneGearLayout setMainBackgroundAlpha(float alpha) {
        super.setMainBackgroundAlpha(alpha);
        return this;
    }

    public OneGearLayout enableCutLayout(boolean enable) {
        super.enableCutLayout(enable);
        return this;
    }

    public OneGearLayout setCutRadius(int radius) {
        super.setCutRadius(radius);
        return this;
    }

    public OneGearLayout setCutLayoutColor(int color) {
        super.setCutLayoutColor(color);
        return this;
    }

    public OneGearLayout setCutLayoutAlpha(float alpha) {
        super.setCutLayoutAlpha(alpha);
        return this;
    }

    public OneGearLayout setShowMode(ShowMode showMode) {
        super.setShowMode(showMode);
        return this;
    }

    public OneGearLayout setShowDialogDuration(int showDialogDuration) {
        super.setShowDialogDuration(showDialogDuration);
        return this;
    }

    public OneGearLayout blurBackground(boolean enable) {
        super.blurBackground(enable);
        return this;
    }

    public OneGearLayout setCancelable(boolean cancelable) {
        super.setCancelable(cancelable);
        return this;
    }

    protected void parseAttributes(AttributeSet attrs) {
        super.parseAttributes(attrs);
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.GearLoadingLayout);
        setFirstGearColor(a.getColor(R.styleable.GearLoadingLayout_firstGearColor, Color.GRAY));
        setFirstGearInnerColor(a.getColor(R.styleable.GearLoadingLayout_firstInnerGearColor, Color.WHITE), a.getBoolean(R.styleable.GearLoadingLayout_firstGearCuttedCenter, true));
        a.recycle();
        requestLayout();
    }

}
