package com.gitmad.local_gigs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thedekel on 10/28/13.
 */
public class ArtistDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "artists.sqlite";
    private static final int VERSION = 1;

    private static final String TABLE_ARTIST = "artist";
    private static final String COLUMN_ARTIST_NAME = "name";
    private static final String COLUMN_ARTIST_AGE = "age";
    private static final String COLUMN_ARTIST_INFO = "info";

    public ArtistCursor queryArtists() {
        Cursor wrapped = getReadableDatabase().rawQuery("select * from artist", new String[]{});
        return new ArtistCursor(wrapped);
    }

    public ArtistDatabaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table artist ("+
          "_id integer primary key autoincrement, name varchar(128)," +
                "age integer, info varchar(256))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // not needed right now, but will be used when upgrading from one VERSION to another
    }

    public long insertArtist(Artist artist) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ARTIST_AGE, artist.age);
        cv.put(COLUMN_ARTIST_INFO, artist.info);
        cv.put(COLUMN_ARTIST_NAME, artist.name);
        return getWritableDatabase().insert(TABLE_ARTIST, null, cv);
    }

    public static class ArtistCursor  extends CursorWrapper {
        public ArtistCursor(Cursor c) {
            super(c);
        }

        public Artist getArtist() {
            if (isBeforeFirst() || isAfterLast()){
                return null;
            }
            Artist artist = new Artist();
            artist.age = getInt(getColumnIndex(COLUMN_ARTIST_AGE));
            artist.name = getString(getColumnIndex(COLUMN_ARTIST_NAME));
            artist.info = getString(getColumnIndex(COLUMN_ARTIST_INFO));
            return artist;
        }
    }
}
