package com.san.my.dataobj;

import java.util.HashSet;
import java.util.Set;

/**
 * SeedDO generated by MyEclipse Persistence Tools
 */

public class SeedDO implements java.io.Serializable {

	// Fields

	private Long seedId;

	private String name;

	private Set slips = new HashSet(0);

	// Constructors

	/** default constructor */
	public SeedDO() {
	}

	/** minimal constructor */
	public SeedDO(Long seedId, String name) {
		this.seedId = seedId;
		this.name = name;
	}

	/** full constructor */
	public SeedDO(Long seedId, String name, Set slips) {
		this.seedId = seedId;
		this.name = name;
		this.slips = slips;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getSlips() {
		return this.slips;
	}

	public void setSlips(Set slips) {
		this.slips = slips;
	}

    public Long getSeedId()
    {
        return seedId;
    }

    public void setSeedId(Long seedId)
    {
        this.seedId = seedId;
    }

}