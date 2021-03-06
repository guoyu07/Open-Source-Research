    /** The level of access protection given by a flag set,
     *  where PRIVATE is highest and PUBLIC is lowest.
     */
    static int protection(long flags) {
    	//当(flags & AccessFlags)是0时，表示的是“包访问级别”，
    	//“包访问级别”比“PROTECTED”的限制还大，所以数字也大
        switch ((short)(flags & AccessFlags)) {
        case PRIVATE: return 3;
        case PROTECTED: return 1;
        default:
        case PUBLIC: return 0;
        case 0: return 2;
        }
    }

	/** A string describing the access permission given by a flag set.
     *  This always returns a space-separated list of Java Keywords.
     */
    private static String protectionString(long flags) {
		long flags1 = flags & AccessFlags;
		return (flags1 == 0) ? "package" : TreeInfo.flagNames(flags1);
    }