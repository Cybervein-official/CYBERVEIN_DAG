package com.cvt.iri.controllers;

import com.cvt.iri.model.Bundle;
import com.cvt.iri.model.Hash;
import com.cvt.iri.storage.Indexable;
import com.cvt.iri.storage.Persistable;
import com.cvt.iri.storage.Tangle;
import com.cvt.iri.utils.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by paul on 5/15/17.
 */
public class BundleViewModel implements HashesViewModel {
    private Bundle self;
    private Indexable hash;

    public BundleViewModel(Hash hash) {
        this.hash = hash;
    }

    private BundleViewModel(Bundle hashes, Indexable hash) {
        self = hashes == null || hashes.set == null ? new Bundle(): hashes;
        this.hash = hash;
    }

    public static BundleViewModel load(Tangle tangle, Indexable hash) throws Exception {
        return new BundleViewModel((Bundle) tangle.load(Bundle.class, hash), hash);

    }

    public static Map.Entry<Indexable, Persistable> getEntry(Hash hash, Hash hashToMerge) throws Exception {
        Bundle hashes = new Bundle();
        hashes.set.add(hashToMerge);
        return new HashMap.SimpleEntry<>(hash, hashes);
    }

    /*
    public static boolean merge(Hash hash, Hash hashToMerge) throws Exception {
        Bundle hashes = new Bundle();
        hashes.set = new HashSet<>(Collections.singleton(hashToMerge));
        return Tangle.instance().merge(hashes, hash);
    }
    */




}