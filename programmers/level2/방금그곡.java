import java.util.*;
class Solution {
    class Song{
		int index;
		int playTime;
		String lyrics;
		String name;
		
		Song(int index, int playTime, String lyrics, String name){
			this.index = index;
			this.playTime = playTime;
			this.lyrics = lyrics;
			this.name = name;
		}
	}
    public String solution(String m, String[] musicinfos) {
        
        List<Song> list = new ArrayList<>();
        
        m = m.replace("A#", "H").replace("C#", "I").replace("D#", "J").replace("F#", "K").replace("G#", "L");

        for(int i = 0; i < musicinfos.length; i++) {
        	String[] split = musicinfos[i].split(",");
        	split[3] = split[3].replace("A#", "H").replace("C#", "I").replace("D#", "J").replace("F#", "K").replace("G#", "L");
        	int s = Integer.valueOf(split[0].substring(0, 2))*60 + Integer.valueOf(split[0].substring(3));
        	int e = Integer.valueOf(split[1].substring(0, 2))*60 + Integer.valueOf(split[1].substring(3));
        	int time = split[3].length();
        	String l = "";
        	for(int j = 0; j < e-s; j++) {
        		l += split[3].charAt(j%time);
        	}
        	if(l.indexOf(m) == -1) continue;
        	
        	list.add(new Song(i, e-s, l, split[2]));
        }
        
        Collections.sort(list, new Comparator<Song>() {
        	@Override
        	public int compare(Song s1, Song s2) {
        		if(s1.playTime == s2.playTime) {
        			return s1.index - s2.index;
        		}
        		return s2.playTime - s1.playTime;
        	}
        });
        
        
        if(list.size() == 0) {
        	return "(None)";
        }
        
        return list.get(0).name;
    }
}
