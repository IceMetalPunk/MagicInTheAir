package com.icemetalpunk.mita.registry;

import java.util.HashMap;

import net.minecraftforge.event.RegistryEvent;

public abstract class MITARegistry<T> {
	protected final HashMap<String, T> registry = new HashMap<String, T>();

	public T get(String name) {
		return this.registry.get(name);
	}

	/**
	 * Adds an object to the registry under the given name; doesn't actually register it until registerAll() is called.
	 * 
	 * @param name
	 *            The lookup name of the object.
	 * @param value
	 *            The object to register.
	 */
	public void register(String name, T value) {
		this.registry.put(name, value);
	}

	public int size() {
		return this.registry.size();
	}

	/**
	 * Actually does whatever registration needs to be handled for each object in the registry.
	 * 
	 * @param ev
	 *            The registry event during which these registrations are handled, for getting the proper Forge registry.
	 * @return The number of objects that were successfully registered.
	 */
	public abstract int registerAll(RegistryEvent.Register ev);

	/**
	 * Registers the models for every object in the registry.
	 * 
	 * @return The number of objects whose models were successfully registered.
	 */
	public abstract int registerModels();
}
