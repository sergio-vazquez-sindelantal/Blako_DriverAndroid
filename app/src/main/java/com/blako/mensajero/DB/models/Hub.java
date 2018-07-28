package com.blako.mensajero.DB.models;

import android.content.ContentValues;
import android.database.Cursor;
import com.blako.mensajero.DB.DbContracts.HubEntry;

public class Hub {

    private String id;
    private String hubId;
    private String label;
    private Integer revision;

    public Hub(String hubId, String label, Integer revision) {
        this.hubId = hubId;
        this.label = label;
        this.revision = revision;
    }

    public Hub(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(HubEntry._ID));
        this.hubId = cursor.getString(cursor.getColumnIndexOrThrow(HubEntry.HUB_ID));
        this.label = cursor.getString(cursor.getColumnIndexOrThrow(HubEntry.LABEL));
        this.revision = cursor.getInt(cursor.getColumnIndexOrThrow(HubEntry.REVISION));
    }

    public ContentValues toContentValues(){
        ContentValues values= new ContentValues();
        values.put(HubEntry.HUB_ID,hubId);
        values.put(HubEntry.LABEL,label);
        values.put(HubEntry.REVISION,revision);
        return values;
    }

    public static String getTable(){
        return "CREATE TABLE "+HubEntry.TABLE_NAME+" ("+HubEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +HubEntry.HUB_ID+" TEXT,"
                +HubEntry.LABEL+" TEXT,"
                +HubEntry.REVISION+" INTEGER)";
    }

    public String getId() {
        return id;
    }

    public String getHubId() {
        return hubId;
    }

    public void setHubId(String hubId) {
        this.hubId = hubId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }
}