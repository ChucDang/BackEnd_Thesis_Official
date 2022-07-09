import React, { createContext, useContext, useState } from "react";
import { useLocalState } from "./useLocalStorage";
const UserContext = createContext();

const LoadingProvider = ({ children }) => {

    const [isLoading, setIsLoading] = useState(true);
    //count để đếm số lượng order có trong cart hiện tại
    const [count, setCount] = useLocalState('count', 0)
    const [displayName, setDisplayName] = useLocalState('displayName', '')
    const value = { isLoading, setIsLoading, count, setCount, displayName, setDisplayName };
    return <UserContext.Provider value={value}>{children}</UserContext.Provider>;
};

function useLoading() {
    const context = useContext(UserContext);
    if (context === undefined) {
        throw new Error("useUser must be used within a UserProvider");
    }

    return context;
}

export { useLoading, LoadingProvider };
