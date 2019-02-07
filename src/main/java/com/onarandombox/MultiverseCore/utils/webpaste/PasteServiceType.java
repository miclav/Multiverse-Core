package com.onarandombox.MultiverseCore.utils.webpaste;

/**
 * An enum containing all known {@link PasteService}s.
 *
 * @see PasteService
 * @see PasteServiceFactory
 */
public enum PasteServiceType {
    /**
     * @see PastebinPasteService
     */
    PASTEBIN,
    /**
     * @see HastebinPasteService
     */
    HASTEBIN,
    /**
     * @see GithubPasteService
     */
    GITHUB
}
