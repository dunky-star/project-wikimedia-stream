package com.wikisconsume.repository;

import com.wikisconsume.payload.WikimediaData;
import org.springframework.data.repository.ListCrudRepository;

public interface WikimediaDataRepository extends ListCrudRepository<WikimediaData, Long> {
}
