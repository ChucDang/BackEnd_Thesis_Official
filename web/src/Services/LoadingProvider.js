import React, { createContext, useContext, useState } from "react";
const UserContext = createContext();

const LoadingProvider = ({ children }) => {

    const [isLoading, setIsLoading] = useState(true);
    const value = { isLoading, setIsLoading };
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
