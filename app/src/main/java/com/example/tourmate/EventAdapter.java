package com.example.tourmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class EventAdapter {
    private List<Event> eventList;
    private Context context;
    private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private DatabaseReference eventRef;
    private FirebaseUser user;

    public EventAdapter(Context context, List<Event> eventList) {
        this.eventList = eventList;
        this.context = context;
        user = FirebaseAuth.getInstance().getCurrentUser();
        rootRef = FirebaseDatabase.getInstance().getReference();
        userRef = rootRef.child(user.getUid());
        eventRef = userRef.child("Events");
    }

}
