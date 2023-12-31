package br.com.uuu.redeyesmusics.nosql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.uuu.redeyesmusics.nosql.entity.Album;

public interface AlbumRepository extends MongoRepository<Album, String> {

	List<Album> findByArtistId(String artistId);

	List<Album> findByName(String name);
	
	@Query("{$where: 'for (var diskName in this.musicsIdsByDiskNames) for (var musicId in this.musicsIdsByDiskNames[diskName]) if (musicId === \"?0\") return true; return false;'}")
	List<Album> getByMusicId(String musicId);
}
