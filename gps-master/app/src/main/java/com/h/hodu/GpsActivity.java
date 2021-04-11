package com.h.hodu;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GpsActivity extends FragmentActivity implements OnMapReadyCallback {

    //GoogleMap 객체
    GoogleMap googleMap;

    //위도 경도
    final static double mLatitude = 37.5197889;   //위도
    final static double mLongitude = 126.9403083;  //경도


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //맵생성
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        //콜백클래스 설정
        mapFragment.getMapAsync(this);
    }

    //구글맵 생성 콜백
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        //지도타입 - 일반
        this.googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //기본위치(단국대)
        LatLng position = new LatLng(mLatitude , mLongitude);

        //화면중앙의 위치와 카메라 줌비율
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 14));

        onAddMarker();
    }

    //마커 , 원추가
    public void onAddMarker(){
        LatLng position = new LatLng(mLatitude , mLongitude);

        //나의위치 마커
        MarkerOptions mymarker = new MarkerOptions()
                .position(position);   //마커위치

        // 반경 1KM원
        CircleOptions circle1KM = new CircleOptions().center(position) //원점
                .radius(1000)      //반지름 단위 : m
                .strokeWidth(0f)  //선너비 0f : 선없음
                .fillColor(Color.parseColor("#880000ff")); //배경색

        //마커추가
        this.googleMap.addMarker(mymarker);

        //원추가
        this.googleMap.addCircle(circle1KM);
    }
}

