package com.kdtax.web.rest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;
import org.jodah.typetools.TypeResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxonline.core.domain.AbstractIdEntity;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public abstract class AbstractCrudRest<T extends AbstractIdEntity, DTO> {

   private static final Log LOG = LogFactory.getLog(AbstractCrudRest.class);

   @Resource
   protected Mapper mapper;

   protected Class<T> clazz;

   protected Class<DTO> clazzDto;

   @SuppressWarnings("unchecked")
   protected AbstractCrudRest() {
      Class<?>[] typeArguments = TypeResolver.resolveArguments(getClass(), AbstractCrudRest.class);
      this.clazz = (Class<T>) typeArguments[0];
      this.clazzDto = (Class<DTO>) typeArguments[1];
   }

   @ResponseBody
   @RequestMapping(method = { RequestMethod.GET })
   public Set<DTO> find() {
      Set<T> set = new HashSet<T>(getRepo().findAll());
      LOG.debug("Found " + set.size() + " " + clazz.getSimpleName() + " (s).");
      Set<DTO> dtos = new HashSet<DTO>();
      for (T item : set) {
         dtos.add(map2Dto(item));
      }
      return dtos;
   }

   @ResponseBody
   @RequestMapping(value = "/{id}", method = { RequestMethod.GET })
   public DTO findById(@PathVariable Long id) {
      T t = getRepo().findOne(id);
      LOG.debug("Found an enity: " + t);
      return map2Dto(t);
   }

   @ResponseBody
   @RequestMapping(method = { RequestMethod.PUT, RequestMethod.POST })
   public DTO createOrUpdate(@RequestBody DTO dto) {
      T t = getRepo().save(map2T(dto));
      LOG.debug("Persited entity: " + t);
      return map2Dto(t);
   }

   @ResponseBody
   @RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
   public void delete(@PathVariable Long id) {
      getRepo().delete(id);
      LOG.debug("Deleted entity by Id = " + id);
   }

   @SuppressWarnings("unchecked")
   protected DTO map2Dto(T t) {
      return (DTO) (clazzDto.equals(clazz) ? t : mapper.map(t, clazzDto));
   }

   protected Set<DTO> map2Dto(Collection<T> collection) {
      Set<DTO> dtos = new HashSet<DTO>();
      for (T t : collection) {
         dtos.add(map2Dto(t));
      }
      return dtos;
   }

   // protected Set<DTO> map2Dto(List<T> list) {
   // Set<DTO> dtos = new HashSet<DTO>();
   // for (T t : list) {
   // dtos.add(map2Dto(t));
   // }
   // return dtos;
   // }

   @SuppressWarnings("unchecked")
   protected T map2T(DTO dto) {
      return (T) (clazz.equals(clazzDto) ? dto : mapper.map(dto, clazz));
   }

   public abstract JpaRepository<T, Long> getRepo();

}
