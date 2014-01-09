package com.noor.login.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

import com.noor.login.Database;

public class MyContentProvider extends ContentProvider 
{
	
	private String TAG="MyContentProvider";
	
	public final String AUTHORIY="com.noor.login.provider.MyContentProvider";
	private static final String Table="signup";
	public final Uri CONTENT_URI=Uri.parse("content://"+AUTHORIY);
	public  UriMatcher sUriMather;
	Database db;
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) 
	{
		
		Log.i(TAG, uri.toString());
		return AUTHORIY;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() 
	{
		Log.i(TAG,"Create() Method called.");
		// TODO Auto-generated method stub
		db = new Database(getContext());
		
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		Log.i(TAG, "From Query Method");
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables(Database.DB_TABLE);
		
		Cursor cursor = queryBuilder.query(db.getReadableDatabase(),
			     projection, selection, selectionArgs, null, null, sortOrder);
			cursor.setNotificationUri(getContext().getContentResolver(), uri);
			return cursor;	
		
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
