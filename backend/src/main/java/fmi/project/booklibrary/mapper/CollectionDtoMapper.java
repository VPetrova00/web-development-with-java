package fmi.project.booklibrary.mapper;

import fmi.project.booklibrary.dto.CollectionDto;
import fmi.project.booklibrary.model.Collection;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CollectionDtoMapper {

    public Collection convertToEntity(CollectionDto collectionDto) {
        return new Collection(collectionDto.getId(), collectionDto.getCollectionName(), collectionDto.getUser());
    }

    public CollectionDto convertToDto(Collection collection) {
        return new CollectionDto(collection.getId(), collection.getCollectionName(), collection.getUser());
    }

    public Set<CollectionDto> convertToDtos(Set<Collection> collections) {
        return collections
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }
}
