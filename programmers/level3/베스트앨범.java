import java.util.*;
class Solution {
	class Song{
		int id;
		int play;
		String genre;
		
		Song(int id, int play, String genre){
			this.id = id;
			this.play = play;
			this.genre = genre;
		}
	}
	public int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> genresMap = new HashMap<>();
		List<Song> songList = new ArrayList<>();
		
		for(int i = 0; i < genres.length; i++) {
			songList.add(new Song(i, plays[i], genres[i]));
			genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0)+plays[i]);
		}
		System.out.println(genresMap);

		for(Song song : songList) {
			System.out.print("id : " + song.id + " ");
			System.out.print("play : " + song.play + " ");
			System.out.println("genre : " + song.genre);
		}
		
		Collections.sort(songList, new Comparator<Song>() {
			@Override
			public int compare(Song s1, Song s2) {
				if(s1.genre.equals(s2.genre)) {
					if(s1.play == s2.play) {
						return s1.id - s2.id;
					}
					
					return -(s1.play - s2.play);
				}
				
				return -(genresMap.get(s1.genre) - genresMap.get(s2.genre));
			}
		});
		System.out.println("===================== sorted ===============================");
		
		for(Song song : songList) {
			System.out.print("id : " + song.id + " ");
			System.out.print("play : " + song.play + " ");
			System.out.println("genre : " + song.genre);
		}
		
		List<Integer> bestAlbum = new ArrayList<>();
		Map<String, Integer> albumMap = new HashMap<>();
		for(Song song : songList) {
			if(!albumMap.containsKey(song.genre)) {
				bestAlbum.add(song.id);
				albumMap.put(song.genre, 1);
			}
			else {
				if(albumMap.get(song.genre)>=2) {
					continue;
				}
				albumMap.put(song.genre, albumMap.getOrDefault(song.genre, 0)+1);
				bestAlbum.add(song.id);
				
			}
		}
		System.out.println(bestAlbum);
		
		int[] result = new int[bestAlbum.size()];
		for(int i= 0; i< result.length; i++) {
			result[i] = bestAlbum.get(i);
		}
		
		return result;
	}
}
