package com.lab5.compulsory;

import com.lab5.exceptions.InvalidMp3FileException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Song extends Item implements Playable{

    public Song(String path) throws InvalidMp3FileException {
        super(path);
        if (!isPlayable(path))
            throw new InvalidMp3FileException("Invalid file format exception. The file is not a song");
    }

    @Override
    public boolean isPlayable(String str) {
        String regex
                = "([^\\s]+(\\.(?i)(mp3))$)";
        Pattern p = Pattern.compile(regex);

        if (str == null) {
            return true;
        }

        Matcher m = p.matcher(str);
        return m.matches();
    }
}
