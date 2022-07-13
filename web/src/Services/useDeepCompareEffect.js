import { useEffect, useRef } from "react"

function deepCompareEquals(object1, object2) {
    // TODO: implement deep comparison here
    // something like lodash
    // return _.isEqual(a, b);
}

function useDeepCompare(value) {
    const ref = useRef(null)
    // it can be done by using useMemo as well
    // but useRef is rather cleaner and easier

    if (!deepCompareEquals(value, ref.current)) {
        ref.current = value
    }

    return ref.current
}

function useDeepCompareEffect(callback, dependencies) {
    useEffect(
        callback,
        dependencies.map(useDeepCompare)
    )
}

export { useDeepCompareEffect };