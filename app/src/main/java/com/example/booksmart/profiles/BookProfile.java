package com.example.booksmart.profiles;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.booksmart.Elements.Book;
import com.example.booksmart.R;
import com.example.booksmart.entry.MainActivity;

public class BookProfile extends AppCompatActivity {

    Book book;

    public void removeBook(View view) {
        MainActivity.data.removeBook(book);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_profile);

        int bookId = getIntent().getIntExtra("bookId", -1);
        Button remover = findViewById(R.id.removeButton);
        remover.setEnabled(false);

        if (bookId != -1) {
            book = MainActivity.data.getBookFromId(bookId);
            if (book != null) {
                TextView bName = findViewById(R.id.name);
                TextView bAuthor = findViewById(R.id.bAuthor);
                TextView bYear = findViewById(R.id.bYear);
                TextView bCat = findViewById(R.id.bCat);

                TextView giverFName = findViewById(R.id.giverFName1);
                TextView giverEmail = findViewById(R.id.giverEmail);
                TextView giverMobile = findViewById(R.id.giverMobile);

                if (MainActivity.data.getCurrentUser().getUniqueId() == book.getGiverId()) {
                    remover.setEnabled(true);
                }

                Log.i("Remove Button", Boolean.toString(remover.isEnabled()));

                bName.setText(book.getName());
                bAuthor.setText(book.getAuthor().getFullName());
                bYear.setText(Integer.toString(book.getYear()));
                bCat.setText(book.getCategory());

                giverFName.setText(book.getGiver().getName().getFullName());
                giverEmail.setText(book.getGiver().getEmail());
                giverMobile.setText(Long.toString(book.getGiver().getMobile()));

            } else {
                Log.i("Book ID received", "Invalid");
            }
        } else {
            Log.i("Book received", "NULL");
        }

    }
}