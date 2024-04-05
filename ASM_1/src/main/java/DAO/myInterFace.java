package DAO;

import java.util.List;

public interface myInterFace<EntityType, Object> {

	EntityType insert(EntityType entity);

	EntityType update(EntityType entity);

	EntityType delete(Object id);

	EntityType findById(Object id);

	public void find(EntityType entity);

	List<EntityType> findPage(int page, int size, String categoryId);

	List<EntityType> findByKeyword(String keyword);

	List<EntityType> selectAll();

}
