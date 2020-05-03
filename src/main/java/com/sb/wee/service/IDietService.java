/**
 *
 */
package com.sb.wee.service;

import com.sb.wee.model.DietDTO;

import java.util.List;

/**
 * @author Suraj
 *
 */
public interface IDietService {

	DietDTO create(DietDTO dietDTO);

	List<DietDTO> getAll();

	void remove(DietDTO dietDTO);

}
