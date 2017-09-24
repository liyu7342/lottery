/*
 * jQuery JavaScript Library v1.4.2
 * Copyright 2010, John Resig, http://jquery.com/
 * Distributed in whole under the terms of the MIT license
 * http://www.opensource.org/licenses/mit-license.php
 *
 * Includes Sizzle.js
 * http://sizzlejs.com/
 * Copyright 2010, The Dojo Foundation
 * Released under the MIT, BSD, and GPL Licenses.
 */
(function(A, w) {
        function ma() {
            if (!c.isReady) {
                try {
                    s.documentElement.doScroll("left")
                } catch (a) {
                    setTimeout(ma, 1);
                    return
                }
                c.ready()
            }
        }
        function Qa(a, b) {
            b.src ? c.ajax({
                    url: b.src,
                    async: false,
                    dataType: "script"
                }) : c.globalEval(b.text || b.textContent || b.innerHTML || "");
            b.parentNode && b.parentNode.removeChild(b)
        }
        function X(a, b, d, f, e, j) {
            var i = a.length;
            if (typeof b === "object") {
                for (var o in b)
                    X(a, o, b[o], f, e, d);
                return a
            }
            if (d !== w) {
                f = !j && f && c.isFunction(d);
                for (o = 0; o < i; o++)
                    e(a[o], b, f ? d.call(a[o], o, e(a[o], b)) : d, j);
                return a
            }
            return i ?
                e(a[0], b) : w
        }
        function J() {
            return (new Date).getTime()
        }
        function Y() {
            return false
        }
        function Z() {
            return true
        }
        function na(a, b, d) {
            d[0].type = a;
            return c.event.handle.apply(b, d)
        }
        function oa(a) {
            var b, d = [], f = [], e = arguments, j, i, o, k, n, r;
            i = c.data(this, "events");
            if (!(a.liveFired === this || !i || !i.live || a.button && a.type === "click")) {
                a.liveFired = this;
                var u = i.live.slice(0);
                for (k = 0; k < u.length; k++) {
                    i = u[k];
                    i.origType.replace(O, "") === a.type ? f.push(i.selector) : u.splice(k--, 1)
                }
                j = c(a.target).closest(f, a.currentTarget);
                n = 0;
                for (r =
                         j.length; n < r; n++)
                    for (k = 0; k < u.length; k++) {
                        i = u[k];
                        if (j[n].selector === i.selector) {
                            o = j[n].elem;
                            f = null ;
                            if (i.preType === "mouseenter" || i.preType === "mouseleave")
                                f = c(a.relatedTarget).closest(i.selector)[0];
                            if (!f || f !== o)
                                d.push({
                                    elem: o,
                                    handleObj: i
                                })
                        }
                    }
                n = 0;
                for (r = d.length; n < r; n++) {
                    j = d[n];
                    a.currentTarget = j.elem;
                    a.data = j.handleObj.data;
                    a.handleObj = j.handleObj;
                    if (j.handleObj.origHandler.apply(j.elem, e) === false) {
                        b = false;
                        break
                    }
                }
                return b
            }
        }
        function pa(a, b) {
            return "live." + (a && a !== "*" ? a + "." : "") + b.replace(/\./g, "`").replace(/ /g,
                    "&")
        }
        function qa(a) {
            return !a || !a.parentNode || a.parentNode.nodeType === 11
        }
        function ra(a, b) {
            var d = 0;
            b.each(function() {
                    if (this.nodeName === (a[d] && a[d].nodeName)) {
                        var f = c.data(a[d++])
                            , e = c.data(this, f);
                        if (f = f && f.events) {
                            delete e.handle;
                            e.events = {};
                            for (var j in f)
                                for (var i in f[j])
                                    c.event.add(this, j, f[j][i], f[j][i].data)
                        }
                    }
                }
            )
        }
        function sa(a, b, d) {
            var f, e, j;
            b = b && b[0] ? b[0].ownerDocument || b[0] : s;
            if (a.length === 1 && typeof a[0] === "string" && a[0].length < 512 && b === s && !ta.test(a[0]) && (c.support.checkClone || !ua.test(a[0]))) {
                e =
                    true;
                if (j = c.fragments[a[0]])
                    if (j !== 1)
                        f = j
            }
            if (!f) {
                f = b.createDocumentFragment();
                c.clean(a, b, f, d)
            }
            if (e)
                c.fragments[a[0]] = j ? f : 1;
            return {
                fragment: f,
                cacheable: e
            }
        }
        function K(a, b) {
            var d = {};
            c.each(va.concat.apply([], va.slice(0, b)), function() {
                    d[this] = a
                }
            );
            return d
        }
        function wa(a) {
            return "scrollTo" in a && a.document ? a : a.nodeType === 9 ? a.defaultView || a.parentWindow : false
        }
        var c = function(a, b) {
                return new c.fn.init(a,b)
            }
            , Ra = A.jQuery, Sa = A.$, s = A.document, T, Ta = /^[^<]*(<[\w\W]+>)[^>]*$|^#([\w-]+)$/, Ua = /^.[^:#\[\.,]*$/, Va = /\S/,
            Wa = /^(\s|\u00A0)+|(\s|\u00A0)+$/g, Xa = /^<(\w+)\s*\/?>(?:<\/\1>)?$/, P = navigator.userAgent, xa = false, Q = [], L, $ = Object.prototype.toString, aa = Object.prototype.hasOwnProperty, ba = Array.prototype.push, R = Array.prototype.slice, ya = Array.prototype.indexOf;
        c.fn = c.prototype = {
            init: function(a, b) {
                var d, f;
                if (!a)
                    return this;
                if (a.nodeType) {
                    this.context = this[0] = a;
                    this.length = 1;
                    return this
                }
                if (a === "body" && !b) {
                    this.context = s;
                    this[0] = s.body;
                    this.selector = "body";
                    this.length = 1;
                    return this
                }
                if (typeof a === "string")
                    if ((d = Ta.exec(a)) &&
                        (d[1] || !b))
                        if (d[1]) {
                            f = b ? b.ownerDocument || b : s;
                            if (a = Xa.exec(a))
                                if (c.isPlainObject(b)) {
                                    a = [s.createElement(a[1])];
                                    c.fn.attr.call(a, b, true)
                                } else
                                    a = [f.createElement(a[1])];
                            else {
                                a = sa([d[1]], [f]);
                                a = (a.cacheable ? a.fragment.cloneNode(true) : a.fragment).childNodes
                            }
                            return c.merge(this, a)
                        } else {
                            if (b = s.getElementById(d[2])) {
                                if (b.id !== d[2])
                                    return T.find(a);
                                this.length = 1;
                                this[0] = b
                            }
                            this.context = s;
                            this.selector = a;
                            return this
                        }
                    else if (!b && /^\w+$/.test(a)) {
                        this.selector = a;
                        this.context = s;
                        a = s.getElementsByTagName(a);
                        return c.merge(this,
                            a)
                    } else
                        return !b || b.jquery ? (b || T).find(a) : c(b).find(a);
                else if (c.isFunction(a))
                    return T.ready(a);
                if (a.selector !== w) {
                    this.selector = a.selector;
                    this.context = a.context
                }
                return c.makeArray(a, this)
            },
            selector: "",
            jquery: "1.4.2",
            length: 0,
            size: function() {
                return this.length
            },
            toArray: function() {
                return R.call(this, 0)
            },
            get: function(a) {
                return a == null  ? this.toArray() : a < 0 ? this.slice(a)[0] : this[a]
            },
            pushStack: function(a, b, d) {
                var f = c();
                c.isArray(a) ? ba.apply(f, a) : c.merge(f, a);
                f.prevObject = this;
                f.context = this.context;
                if (b ===
                    "find")
                    f.selector = this.selector + (this.selector ? " " : "") + d;
                else if (b)
                    f.selector = this.selector + "." + b + "(" + d + ")";
                return f
            },
            each: function(a, b) {
                return c.each(this, a, b)
            },
            ready: function(a) {
                c.bindReady();
                if (c.isReady)
                    a.call(s, c);
                else
                    Q && Q.push(a);
                return this
            },
            eq: function(a) {
                return a === -1 ? this.slice(a) : this.slice(a, +a + 1)
            },
            first: function() {
                return this.eq(0)
            },
            last: function() {
                return this.eq(-1)
            },
            slice: function() {
                return this.pushStack(R.apply(this, arguments), "slice", R.call(arguments).join(","))
            },
            map: function(a) {
                return this.pushStack(c.map(this,
                    function(b, d) {
                        return a.call(b, d, b)
                    }
                ))
            },
            end: function() {
                return this.prevObject || c(null )
            },
            push: ba,
            sort: [].sort,
            splice: [].splice
        };
        c.fn.init.prototype = c.fn;
        c.extend = c.fn.extend = function() {
            var a = arguments[0] || {}, b = 1, d = arguments.length, f = false, e, j, i, o;
            if (typeof a === "boolean") {
                f = a;
                a = arguments[1] || {};
                b = 2
            }
            if (typeof a !== "object" && !c.isFunction(a))
                a = {};
            if (d === b) {
                a = this;
                --b
            }
            for (; b < d; b++)
                if ((e = arguments[b]) != null )
                    for (j in e) {
                        i = a[j];
                        o = e[j];
                        if (a !== o)
                            if (f && o && (c.isPlainObject(o) || c.isArray(o))) {
                                i = i && (c.isPlainObject(i) ||
                                c.isArray(i)) ? i : c.isArray(o) ? [] : {};
                                a[j] = c.extend(f, i, o)
                            } else if (o !== w)
                                a[j] = o
                    }
            return a
        }
        ;
        c.extend({
            noConflict: function(a) {
                A.$ = Sa;
                if (a)
                    A.jQuery = Ra;
                return c
            },
            isReady: false,
            ready: function() {
                if (!c.isReady) {
                    if (!s.body)
                        return setTimeout(c.ready, 13);
                    c.isReady = true;
                    if (Q) {
                        for (var a, b = 0; a = Q[b++]; )
                            a.call(s, c);
                        Q = null
                    }
                    c.fn.triggerHandler && c(s).triggerHandler("ready")
                }
            },
            bindReady: function() {
                if (!xa) {
                    xa = true;
                    if (s.readyState === "complete")
                        return c.ready();
                    if (s.addEventListener) {
                        s.addEventListener("DOMContentLoaded",
                            L, false);
                        A.addEventListener("load", c.ready, false)
                    } else if (s.attachEvent) {
                        s.attachEvent("onreadystatechange", L);
                        A.attachEvent("onload", c.ready);
                        var a = false;
                        try {
                            a = A.frameElement == null
                        } catch (b) {}
                        s.documentElement.doScroll && a && ma()
                    }
                }
            },
            isFunction: function(a) {
                return $.call(a) === "[object Function]"
            },
            isArray: function(a) {
                return $.call(a) === "[object Array]"
            },
            isPlainObject: function(a) {
                if (!a || $.call(a) !== "[object Object]" || a.nodeType || a.setInterval)
                    return false;
                if (a.constructor && !aa.call(a, "constructor") && !aa.call(a.constructor.prototype,
                        "isPrototypeOf"))
                    return false;
                var b;
                for (b in a)
                    ;
                return b === w || aa.call(a, b)
            },
            isEmptyObject: function(a) {
                for (var b in a)
                    return false;
                return true
            },
            error: function(a) {
                throw a;
            },
            parseJSON: function(a) {
                if (typeof a !== "string" || !a)
                    return null ;
                a = c.trim(a);
                if (/^[\],:{}\s]*$/.test(a.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, "")))
                    return A.JSON && A.JSON.parse ? A.JSON.parse(a) : (new Function("return " +
                            a))();
                else
                    c.error("Invalid JSON: " + a)
            },
            noop: function() {},
            globalEval: function(a) {
                if (a && Va.test(a)) {
                    var b = s.getElementsByTagName("head")[0] || s.documentElement
                        , d = s.createElement("script");
                    d.type = "text/javascript";
                    if (c.support.scriptEval)
                        d.appendChild(s.createTextNode(a));
                    else
                        d.text = a;
                    b.insertBefore(d, b.firstChild);
                    b.removeChild(d)
                }
            },
            nodeName: function(a, b) {
                return a.nodeName && a.nodeName.toUpperCase() === b.toUpperCase()
            },
            each: function(a, b, d) {
                var f, e = 0, j = a.length, i = j === w || c.isFunction(a);
                if (d)
                    if (i)
                        for (f in a) {
                            if (b.apply(a[f],
                                    d) === false)
                                break
                        }
                    else
                        for (; e < j; ) {
                            if (b.apply(a[e++], d) === false)
                                break
                        }
                else if (i)
                    for (f in a) {
                        if (b.call(a[f], f, a[f]) === false)
                            break
                    }
                else
                    for (d = a[0]; e < j && b.call(d, e, d) !== false; d = a[++e])
                        ;
                return a
            },
            trim: function(a) {
                return (a || "").replace(Wa, "")
            },
            makeArray: function(a, b) {
                b = b || [];
                if (a != null )
                    a.length == null  || typeof a === "string" || c.isFunction(a) || typeof a !== "function" && a.setInterval ? ba.call(b, a) : c.merge(b, a);
                return b
            },
            inArray: function(a, b) {
                if (b.indexOf)
                    return b.indexOf(a);
                for (var d = 0, f = b.length; d < f; d++)
                    if (b[d] ===
                        a)
                        return d;
                return -1
            },
            merge: function(a, b) {
                var d = a.length
                    , f = 0;
                if (typeof b.length === "number")
                    for (var e = b.length; f < e; f++)
                        a[d++] = b[f];
                else
                    for (; b[f] !== w; )
                        a[d++] = b[f++];
                a.length = d;
                return a
            },
            grep: function(a, b, d) {
                for (var f = [], e = 0, j = a.length; e < j; e++)
                    !d !== !b(a[e], e) && f.push(a[e]);
                return f
            },
            map: function(a, b, d) {
                for (var f = [], e, j = 0, i = a.length; j < i; j++) {
                    e = b(a[j], j, d);
                    if (e != null )
                        f[f.length] = e
                }
                return f.concat.apply([], f)
            },
            guid: 1,
            proxy: function(a, b, d) {
                if (arguments.length === 2)
                    if (typeof b === "string") {
                        d = a;
                        a = d[b];
                        b = w
                    } else if (b &&
                        !c.isFunction(b)) {
                        d = b;
                        b = w
                    }
                if (!b && a)
                    b = function() {
                        return a.apply(d || this, arguments)
                    }
                    ;
                if (a)
                    b.guid = a.guid = a.guid || b.guid || c.guid++;
                return b
            },
            uaMatch: function(a) {
                a = a.toLowerCase();
                a = /(webkit)[ \/]([\w.]+)/.exec(a) || /(opera)(?:.*version)?[ \/]([\w.]+)/.exec(a) || /(msie) ([\w.]+)/.exec(a) || !/compatible/.test(a) && /(mozilla)(?:.*? rv:([\w.]+))?/.exec(a) || [];
                return {
                    browser: a[1] || "",
                    version: a[2] || "0"
                }
            },
            browser: {}
        });
        P = c.uaMatch(P);
        if (P.browser) {
            c.browser[P.browser] = true;
            c.browser.version = P.version
        }
        if (c.browser.webkit)
            c.browser.safari =
                true;
        if (ya)
            c.inArray = function(a, b) {
                return ya.call(b, a)
            }
            ;
        T = c(s);
        if (s.addEventListener)
            L = function() {
                s.removeEventListener("DOMContentLoaded", L, false);
                c.ready()
            }
            ;
        else if (s.attachEvent)
            L = function() {
                if (s.readyState === "complete") {
                    s.detachEvent("onreadystatechange", L);
                    c.ready()
                }
            }
            ;
        (function() {
                c.support = {};
                var a = s.documentElement
                    , b = s.createElement("script")
                    , d = s.createElement("div")
                    , f = "script" + J();
                d.style.display = "none";
                d.innerHTML = "   <link/><table></table><a href='/a' style='color:red;float:left;opacity:.55;'>a</a><input type='checkbox'/>";
                var e = d.getElementsByTagName("*")
                    , j = d.getElementsByTagName("a")[0];
                if (!(!e || !e.length || !j)) {
                    c.support = {
                        leadingWhitespace: d.firstChild.nodeType === 3,
                        tbody: !d.getElementsByTagName("tbody").length,
                        htmlSerialize: !!d.getElementsByTagName("link").length,
                        style: /red/.test(j.getAttribute("style")),
                        hrefNormalized: j.getAttribute("href") === "/a",
                        opacity: /^0.55$/.test(j.style.opacity),
                        cssFloat: !!j.style.cssFloat,
                        checkOn: d.getElementsByTagName("input")[0].value === "on",
                        optSelected: s.createElement("select").appendChild(s.createElement("option")).selected,
                        parentNode: d.removeChild(d.appendChild(s.createElement("div"))).parentNode === null ,
                        deleteExpando: true,
                        checkClone: false,
                        scriptEval: false,
                        noCloneEvent: true,
                        boxModel: null
                    };
                    b.type = "text/javascript";
                    try {
                        b.appendChild(s.createTextNode("window." + f + "=1;"))
                    } catch (i) {}
                    a.insertBefore(b, a.firstChild);
                    if (A[f]) {
                        c.support.scriptEval = true;
                        delete A[f]
                    }
                    try {
                        delete b.test
                    } catch (o) {
                        c.support.deleteExpando = false
                    }
                    a.removeChild(b);
                    if (d.attachEvent && d.fireEvent) {
                        d.attachEvent("onclick", function k() {
                                c.support.noCloneEvent =
                                    false;
                                d.detachEvent("onclick", k)
                            }
                        );
                        d.cloneNode(true).fireEvent("onclick")
                    }
                    d = s.createElement("div");
                    d.innerHTML = "<input type='radio' name='radiotest' checked='checked'/>";
                    a = s.createDocumentFragment();
                    a.appendChild(d.firstChild);
                    c.support.checkClone = a.cloneNode(true).cloneNode(true).lastChild.checked;
                    c(function() {
                            var k = s.createElement("div");
                            k.style.width = k.style.paddingLeft = "1px";
                            s.body.appendChild(k);
                            c.boxModel = c.support.boxModel = k.offsetWidth === 2;
                            s.body.removeChild(k).style.display = "none"
                        }
                    );
                    a = function(k) {
                        var n =
                            s.createElement("div");
                        k = "on" + k;
                        var r = k in n;
                        if (!r) {
                            n.setAttribute(k, "return;");
                            r = typeof n[k] === "function"
                        }
                        return r
                    }
                    ;
                    c.support.submitBubbles = a("submit");
                    c.support.changeBubbles = a("change");
                    a = b = d = e = j = null
                }
            }
        )();
        c.props = {
            "for": "htmlFor",
            "class": "className",
            readonly: "readOnly",
            maxlength: "maxLength",
            cellspacing: "cellSpacing",
            rowspan: "rowSpan",
            colspan: "colSpan",
            tabindex: "tabIndex",
            usemap: "useMap",
            frameborder: "frameBorder"
        };
        var G = "jQuery" + J()
            , Ya = 0
            , za = {};
        c.extend({
            cache: {},
            expando: G,
            noData: {
                embed: true,
                object: true,
                applet: true
            },
            data: function(a, b, d) {
                if (!(a.nodeName && c.noData[a.nodeName.toLowerCase()])) {
                    a = a == A ? za : a;
                    var f = a[G]
                        , e = c.cache;
                    if (!f && typeof b === "string" && d === w)
                        return null ;
                    f || (f = ++Ya);
                    if (typeof b === "object") {
                        a[G] = f;
                        e[f] = c.extend(true, {}, b)
                    } else if (!e[f]) {
                        a[G] = f;
                        e[f] = {}
                    }
                    a = e[f];
                    if (d !== w)
                        a[b] = d;
                    return typeof b === "string" ? a[b] : a
                }
            },
            removeData: function(a, b) {
                if (!(a.nodeName && c.noData[a.nodeName.toLowerCase()])) {
                    a = a == A ? za : a;
                    var d = a[G]
                        , f = c.cache
                        , e = f[d];
                    if (b) {
                        if (e) {
                            delete e[b];
                            c.isEmptyObject(e) && c.removeData(a)
                        }
                    } else {
                        if (c.support.deleteExpando)
                            delete a[c.expando];
                        else
                            a.removeAttribute && a.removeAttribute(c.expando);
                        delete f[d]
                    }
                }
            }
        });
        c.fn.extend({
            data: function(a, b) {
                if (typeof a === "undefined" && this.length)
                    return c.data(this[0]);
                else if (typeof a === "object")
                    return this.each(function() {
                            c.data(this, a)
                        }
                    );
                var d = a.split(".");
                d[1] = d[1] ? "." + d[1] : "";
                if (b === w) {
                    var f = this.triggerHandler("getData" + d[1] + "!", [d[0]]);
                    if (f === w && this.length)
                        f = c.data(this[0], a);
                    return f === w && d[1] ? this.data(d[0]) : f
                } else
                    return this.trigger("setData" + d[1] + "!", [d[0], b]).each(function() {
                            c.data(this,
                                a, b)
                        }
                    )
            },
            removeData: function(a) {
                return this.each(function() {
                        c.removeData(this, a)
                    }
                )
            }
        });
        c.extend({
            queue: function(a, b, d) {
                if (a) {
                    b = (b || "fx") + "queue";
                    var f = c.data(a, b);
                    if (!d)
                        return f || [];
                    if (!f || c.isArray(d))
                        f = c.data(a, b, c.makeArray(d));
                    else
                        f.push(d);
                    return f
                }
            },
            dequeue: function(a, b) {
                b = b || "fx";
                var d = c.queue(a, b)
                    , f = d.shift();
                if (f === "inprogress")
                    f = d.shift();
                if (f) {
                    b === "fx" && d.unshift("inprogress");
                    f.call(a, function() {
                            c.dequeue(a, b)
                        }
                    )
                }
            }
        });
        c.fn.extend({
            queue: function(a, b) {
                if (typeof a !== "string") {
                    b = a;
                    a = "fx"
                }
                if (b ===
                    w)
                    return c.queue(this[0], a);
                return this.each(function() {
                        var d = c.queue(this, a, b);
                        a === "fx" && d[0] !== "inprogress" && c.dequeue(this, a)
                    }
                )
            },
            dequeue: function(a) {
                return this.each(function() {
                        c.dequeue(this, a)
                    }
                )
            },
            delay: function(a, b) {
                a = c.fx ? c.fx.speeds[a] || a : a;
                b = b || "fx";
                return this.queue(b, function() {
                        var d = this;
                        setTimeout(function() {
                                c.dequeue(d, b)
                            }
                            , a)
                    }
                )
            },
            clearQueue: function(a) {
                return this.queue(a || "fx", [])
            }
        });
        var Aa = /[\n\t]/g
            , ca = /\s+/
            , Za = /\r/g
            , $a = /href|src|style/
            , ab = /(button|input)/i
            , bb = /(button|input|object|select|textarea)/i
            ,
            cb = /^(a|area)$/i
            , Ba = /radio|checkbox/;
        c.fn.extend({
            attr: function(a, b) {
                return X(this, a, b, true, c.attr)
            },
            removeAttr: function(a) {
                return this.each(function() {
                        c.attr(this, a, "");
                        this.nodeType === 1 && this.removeAttribute(a)
                    }
                )
            },
            addClass: function(a) {
                if (c.isFunction(a))
                    return this.each(function(n) {
                            var r = c(this);
                            r.addClass(a.call(this, n, r.attr("class")))
                        }
                    );
                if (a && typeof a === "string")
                    for (var b = (a || "").split(ca), d = 0, f = this.length; d < f; d++) {
                        var e = this[d];
                        if (e.nodeType === 1)
                            if (e.className) {
                                for (var j = " " + e.className + " ",
                                         i = e.className, o = 0, k = b.length; o < k; o++)
                                    if (j.indexOf(" " + b[o] + " ") < 0)
                                        i += " " + b[o];
                                e.className = c.trim(i)
                            } else
                                e.className = a
                    }
                return this
            },
            removeClass: function(a) {
                if (c.isFunction(a))
                    return this.each(function(k) {
                            var n = c(this);
                            n.removeClass(a.call(this, k, n.attr("class")))
                        }
                    );
                if (a && typeof a === "string" || a === w)
                    for (var b = (a || "").split(ca), d = 0, f = this.length; d < f; d++) {
                        var e = this[d];
                        if (e.nodeType === 1 && e.className)
                            if (a) {
                                for (var j = (" " + e.className + " ").replace(Aa, " "), i = 0, o = b.length; i < o; i++)
                                    j = j.replace(" " + b[i] + " ",
                                        " ");
                                e.className = c.trim(j)
                            } else
                                e.className = ""
                    }
                return this
            },
            toggleClass: function(a, b) {
                var d = typeof a
                    , f = typeof b === "boolean";
                if (c.isFunction(a))
                    return this.each(function(e) {
                            var j = c(this);
                            j.toggleClass(a.call(this, e, j.attr("class"), b), b)
                        }
                    );
                return this.each(function() {
                        if (d === "string")
                            for (var e, j = 0, i = c(this), o = b, k = a.split(ca); e = k[j++]; ) {
                                o = f ? o : !i.hasClass(e);
                                i[o ? "addClass" : "removeClass"](e)
                            }
                        else if (d === "undefined" || d === "boolean") {
                            this.className && c.data(this, "__className__", this.className);
                            this.className =
                                this.className || a === false ? "" : c.data(this, "__className__") || ""
                        }
                    }
                )
            },
            hasClass: function(a) {
                a = " " + a + " ";
                for (var b = 0, d = this.length; b < d; b++)
                    if ((" " + this[b].className + " ").replace(Aa, " ").indexOf(a) > -1)
                        return true;
                return false
            },
            val: function(a) {
                if (a === w) {
                    var b = this[0];
                    if (b) {
                        if (c.nodeName(b, "option"))
                            return (b.attributes.value || {}).specified ? b.value : b.text;
                        if (c.nodeName(b, "select")) {
                            var d = b.selectedIndex
                                , f = []
                                , e = b.options;
                            b = b.type === "select-one";
                            if (d < 0)
                                return null ;
                            var j = b ? d : 0;
                            for (d = b ? d + 1 : e.length; j < d; j++) {
                                var i =
                                    e[j];
                                if (i.selected) {
                                    a = c(i).val();
                                    if (b)
                                        return a;
                                    f.push(a)
                                }
                            }
                            return f
                        }
                        if (Ba.test(b.type) && !c.support.checkOn)
                            return b.getAttribute("value") === null  ? "on" : b.value;
                        return (b.value || "").replace(Za, "")
                    }
                    return w
                }
                var o = c.isFunction(a);
                return this.each(function(k) {
                        var n = c(this)
                            , r = a;
                        if (this.nodeType === 1) {
                            if (o)
                                r = a.call(this, k, n.val());
                            if (typeof r === "number")
                                r += "";
                            if (c.isArray(r) && Ba.test(this.type))
                                this.checked = c.inArray(n.val(), r) >= 0;
                            else if (c.nodeName(this, "select")) {
                                var u = c.makeArray(r);
                                c("option", this).each(function() {
                                        this.selected =
                                            c.inArray(c(this).val(), u) >= 0
                                    }
                                );
                                if (!u.length)
                                    this.selectedIndex = -1
                            } else
                                this.value = r
                        }
                    }
                )
            }
        });
        c.extend({
            attrFn: {
                val: true,
                css: true,
                html: true,
                text: true,
                data: true,
                width: true,
                height: true,
                offset: true
            },
            attr: function(a, b, d, f) {
                if (!a || a.nodeType === 3 || a.nodeType === 8)
                    return w;
                if (f && b in c.attrFn)
                    return c(a)[b](d);
                f = a.nodeType !== 1 || !c.isXMLDoc(a);
                var e = d !== w;
                b = f && c.props[b] || b;
                if (a.nodeType === 1) {
                    var j = $a.test(b);
                    if (b in a && f && !j) {
                        if (e) {
                            b === "type" && ab.test(a.nodeName) && a.parentNode && c.error("type property can't be changed");
                            a[b] = d
                        }
                        if (c.nodeName(a, "form") && a.getAttributeNode(b))
                            return a.getAttributeNode(b).nodeValue;
                        if (b === "tabIndex")
                            return (b = a.getAttributeNode("tabIndex")) && b.specified ? b.value : bb.test(a.nodeName) || cb.test(a.nodeName) && a.href ? 0 : w;
                        return a[b]
                    }
                    if (!c.support.style && f && b === "style") {
                        if (e)
                            a.style.cssText = "" + d;
                        return a.style.cssText
                    }
                    e && a.setAttribute(b, "" + d);
                    a = !c.support.hrefNormalized && f && j ? a.getAttribute(b, 2) : a.getAttribute(b);
                    return a === null  ? w : a
                }
                return c.style(a, b, d)
            }
        });
        var O = /\.(.*)$/
            , db = function(a) {
                return a.replace(/[^\w\s\.\|`]/g,
                    function(b) {
                        return "\\" + b
                    }
                )
            }
            ;
        c.event = {
            add: function(a, b, d, f) {
                if (!(a.nodeType === 3 || a.nodeType === 8)) {
                    if (a.setInterval && a !== A && !a.frameElement)
                        a = A;
                    var e, j;
                    if (d.handler) {
                        e = d;
                        d = e.handler
                    }
                    if (!d.guid)
                        d.guid = c.guid++;
                    if (j = c.data(a)) {
                        var i = j.events = j.events || {}
                            , o = j.handle;
                        if (!o)
                            j.handle = o = function() {
                                return typeof c !== "undefined" && !c.event.triggered ? c.event.handle.apply(o.elem, arguments) : w
                            }
                            ;
                        o.elem = a;
                        b = b.split(" ");
                        for (var k, n = 0, r; k = b[n++]; ) {
                            j = e ? c.extend({}, e) : {
                                    handler: d,
                                    data: f
                                };
                            if (k.indexOf(".") > -1) {
                                r = k.split(".");
                                k = r.shift();
                                j.namespace = r.slice(0).sort().join(".")
                            } else {
                                r = [];
                                j.namespace = ""
                            }
                            j.type = k;
                            j.guid = d.guid;
                            var u = i[k]
                                , z = c.event.special[k] || {};
                            if (!u) {
                                u = i[k] = [];
                                if (!z.setup || z.setup.call(a, f, r, o) === false)
                                    if (a.addEventListener)
                                        a.addEventListener(k, o, false);
                                    else
                                        a.attachEvent && a.attachEvent("on" + k, o)
                            }
                            if (z.add) {
                                z.add.call(a, j);
                                if (!j.handler.guid)
                                    j.handler.guid = d.guid
                            }
                            u.push(j);
                            c.event.global[k] = true
                        }
                        a = null
                    }
                }
            },
            global: {},
            remove: function(a, b, d, f) {
                if (!(a.nodeType === 3 || a.nodeType === 8)) {
                    var e, j = 0, i, o, k, n, r, u, z = c.data(a),
                        C = z && z.events;
                    if (z && C) {
                        if (b && b.type) {
                            d = b.handler;
                            b = b.type
                        }
                        if (!b || typeof b === "string" && b.charAt(0) === ".") {
                            b = b || "";
                            for (e in C)
                                c.event.remove(a, e + b)
                        } else {
                            for (b = b.split(" "); e = b[j++]; ) {
                                n = e;
                                i = e.indexOf(".") < 0;
                                o = [];
                                if (!i) {
                                    o = e.split(".");
                                    e = o.shift();
                                    k = new RegExp("(^|\\.)" + c.map(o.slice(0).sort(), db).join("\\.(?:.*\\.)?") + "(\\.|$)")
                                }
                                if (r = C[e])
                                    if (d) {
                                        n = c.event.special[e] || {};
                                        for (B = f || 0; B < r.length; B++) {
                                            u = r[B];
                                            if (d.guid === u.guid) {
                                                if (i || k.test(u.namespace)) {
                                                    f == null  && r.splice(B--, 1);
                                                    n.remove && n.remove.call(a, u)
                                                }
                                                if (f !=
                                                    null )
                                                    break
                                            }
                                        }
                                        if (r.length === 0 || f != null  && r.length === 1) {
                                            if (!n.teardown || n.teardown.call(a, o) === false)
                                                Ca(a, e, z.handle);
                                            delete C[e]
                                        }
                                    } else
                                        for (var B = 0; B < r.length; B++) {
                                            u = r[B];
                                            if (i || k.test(u.namespace)) {
                                                c.event.remove(a, n, u.handler, B);
                                                r.splice(B--, 1)
                                            }
                                        }
                            }
                            if (c.isEmptyObject(C)) {
                                if (b = z.handle)
                                    b.elem = null ;
                                delete z.events;
                                delete z.handle;
                                c.isEmptyObject(z) && c.removeData(a)
                            }
                        }
                    }
                }
            },
            trigger: function(a, b, d, f) {
                var e = a.type || a;
                if (!f) {
                    a = typeof a === "object" ? a[G] ? a : c.extend(c.Event(e), a) : c.Event(e);
                    if (e.indexOf("!") >= 0) {
                        a.type =
                            e = e.slice(0, -1);
                        a.exclusive = true
                    }
                    if (!d) {
                        a.stopPropagation();
                        c.event.global[e] && c.each(c.cache, function() {
                                this.events && this.events[e] && c.event.trigger(a, b, this.handle.elem)
                            }
                        )
                    }
                    if (!d || d.nodeType === 3 || d.nodeType === 8)
                        return w;
                    a.result = w;
                    a.target = d;
                    b = c.makeArray(b);
                    b.unshift(a)
                }
                a.currentTarget = d;
                (f = c.data(d, "handle")) && f.apply(d, b);
                f = d.parentNode || d.ownerDocument;
                try {
                    if (!(d && d.nodeName && c.noData[d.nodeName.toLowerCase()]))
                        if (d["on" + e] && d["on" + e].apply(d, b) === false)
                            a.result = false
                } catch (j) {}
                if (!a.isPropagationStopped() &&
                    f)
                    c.event.trigger(a, b, f, true);
                else if (!a.isDefaultPrevented()) {
                    f = a.target;
                    var i, o = c.nodeName(f, "a") && e === "click", k = c.event.special[e] || {};
                    if ((!k._default || k._default.call(d, a) === false) && !o && !(f && f.nodeName && c.noData[f.nodeName.toLowerCase()])) {
                        try {
                            if (f[e]) {
                                if (i = f["on" + e])
                                    f["on" + e] = null ;
                                c.event.triggered = true;
                                f[e]()
                            }
                        } catch (n) {}
                        if (i)
                            f["on" + e] = i;
                        c.event.triggered = false
                    }
                }
            },
            handle: function(a) {
                var b, d, f, e;
                a = arguments[0] = c.event.fix(a || A.event);
                a.currentTarget = this;
                b = a.type.indexOf(".") < 0 && !a.exclusive;
                if (!b) {
                    d = a.type.split(".");
                    a.type = d.shift();
                    f = new RegExp("(^|\\.)" + d.slice(0).sort().join("\\.(?:.*\\.)?") + "(\\.|$)")
                }
                e = c.data(this, "events");
                d = e[a.type];
                if (e && d) {
                    d = d.slice(0);
                    e = 0;
                    for (var j = d.length; e < j; e++) {
                        var i = d[e];
                        if (b || f.test(i.namespace)) {
                            a.handler = i.handler;
                            a.data = i.data;
                            a.handleObj = i;
                            i = i.handler.apply(this, arguments);
                            if (i !== w) {
                                a.result = i;
                                if (i === false) {
                                    a.preventDefault();
                                    a.stopPropagation()
                                }
                            }
                            if (a.isImmediatePropagationStopped())
                                break
                        }
                    }
                }
                return a.result
            },
            props: "altKey attrChange attrName bubbles button cancelable charCode clientX clientY ctrlKey currentTarget data detail eventPhase fromElement handler keyCode layerX layerY metaKey newValue offsetX offsetY originalTarget pageX pageY prevValue relatedNode relatedTarget screenX screenY shiftKey srcElement target toElement view wheelDelta which".split(" "),
            fix: function(a) {
                if (a[G])
                    return a;
                var b = a;
                a = c.Event(b);
                for (var d = this.props.length, f; d; ) {
                    f = this.props[--d];
                    a[f] = b[f]
                }
                if (!a.target)
                    a.target = a.srcElement || s;
                if (a.target.nodeType === 3)
                    a.target = a.target.parentNode;
                if (!a.relatedTarget && a.fromElement)
                    a.relatedTarget = a.fromElement === a.target ? a.toElement : a.fromElement;
                if (a.pageX == null  && a.clientX != null ) {
                    b = s.documentElement;
                    d = s.body;
                    a.pageX = a.clientX + (b && b.scrollLeft || d && d.scrollLeft || 0) - (b && b.clientLeft || d && d.clientLeft || 0);
                    a.pageY = a.clientY + (b && b.scrollTop ||
                        d && d.scrollTop || 0) - (b && b.clientTop || d && d.clientTop || 0)
                }
                if (!a.which && (a.charCode || a.charCode === 0 ? a.charCode : a.keyCode))
                    a.which = a.charCode || a.keyCode;
                if (!a.metaKey && a.ctrlKey)
                    a.metaKey = a.ctrlKey;
                if (!a.which && a.button !== w)
                    a.which = a.button & 1 ? 1 : a.button & 2 ? 3 : a.button & 4 ? 2 : 0;
                return a
            },
            guid: 1E8,
            proxy: c.proxy,
            special: {
                ready: {
                    setup: c.bindReady,
                    teardown: c.noop
                },
                live: {
                    add: function(a) {
                        c.event.add(this, a.origType, c.extend({}, a, {
                            handler: oa
                        }))
                    },
                    remove: function(a) {
                        var b = true
                            , d = a.origType.replace(O, "");
                        c.each(c.data(this,
                                "events").live || [], function() {
                                if (d === this.origType.replace(O, ""))
                                    return b = false
                            }
                        );
                        b && c.event.remove(this, a.origType, oa)
                    }
                },
                beforeunload: {
                    setup: function(a, b, d) {
                        if (this.setInterval)
                            this.onbeforeunload = d;
                        return false
                    },
                    teardown: function(a, b) {
                        if (this.onbeforeunload === b)
                            this.onbeforeunload = null
                    }
                }
            }
        };
        var Ca = s.removeEventListener ? function(a, b, d) {
                    a.removeEventListener(b, d, false)
                }
                : function(a, b, d) {
                    a.detachEvent("on" + b, d)
                }
            ;
        c.Event = function(a) {
            if (!this.preventDefault)
                return new c.Event(a);
            if (a && a.type) {
                this.originalEvent =
                    a;
                this.type = a.type
            } else
                this.type = a;
            this.timeStamp = J();
            this[G] = true
        }
        ;
        c.Event.prototype = {
            preventDefault: function() {
                this.isDefaultPrevented = Z;
                var a = this.originalEvent;
                if (a) {
                    a.preventDefault && a.preventDefault();
                    a.returnValue = false
                }
            },
            stopPropagation: function() {
                this.isPropagationStopped = Z;
                var a = this.originalEvent;
                if (a) {
                    a.stopPropagation && a.stopPropagation();
                    a.cancelBubble = true
                }
            },
            stopImmediatePropagation: function() {
                this.isImmediatePropagationStopped = Z;
                this.stopPropagation()
            },
            isDefaultPrevented: Y,
            isPropagationStopped: Y,
            isImmediatePropagationStopped: Y
        };
        var Da = function(a) {
                var b = a.relatedTarget;
                try {
                    for (; b && b !== this; )
                        b = b.parentNode;
                    if (b !== this) {
                        a.type = a.data;
                        c.event.handle.apply(this, arguments)
                    }
                } catch (d) {}
            }
            , Ea = function(a) {
                a.type = a.data;
                c.event.handle.apply(this, arguments)
            }
            ;
        c.each({
                mouseenter: "mouseover",
                mouseleave: "mouseout"
            }, function(a, b) {
                c.event.special[a] = {
                    setup: function(d) {
                        c.event.add(this, b, d && d.selector ? Ea : Da, a)
                    },
                    teardown: function(d) {
                        c.event.remove(this, b, d && d.selector ? Ea : Da)
                    }
                }
            }
        );
        if (!c.support.submitBubbles)
            c.event.special.submit =
                {
                    setup: function() {
                        if (this.nodeName.toLowerCase() !== "form") {
                            c.event.add(this, "click.specialSubmit", function(a) {
                                    var b = a.target
                                        , d = b.type;
                                    if ((d === "submit" || d === "image") && c(b).closest("form").length)
                                        return na("submit", this, arguments)
                                }
                            );
                            c.event.add(this, "keypress.specialSubmit", function(a) {
                                    var b = a.target
                                        , d = b.type;
                                    if ((d === "text" || d === "password") && c(b).closest("form").length && a.keyCode === 13)
                                        return na("submit", this, arguments)
                                }
                            )
                        } else
                            return false
                    },
                    teardown: function() {
                        c.event.remove(this, ".specialSubmit")
                    }
                };
        if (!c.support.changeBubbles) {
            var da = /textarea|input|select/i, ea, Fa = function(a) {
                    var b = a.type
                        , d = a.value;
                    if (b === "radio" || b === "checkbox")
                        d = a.checked;
                    else if (b === "select-multiple")
                        d = a.selectedIndex > -1 ? c.map(a.options, function(f) {
                                    return f.selected
                                }
                            ).join("-") : "";
                    else if (a.nodeName.toLowerCase() === "select")
                        d = a.selectedIndex;
                    return d
                }
                , fa = function(a, b) {
                    var d = a.target, f, e;
                    if (!(!da.test(d.nodeName) || d.readOnly)) {
                        f = c.data(d, "_change_data");
                        e = Fa(d);
                        if (a.type !== "focusout" || d.type !== "radio")
                            c.data(d, "_change_data",
                                e);
                        if (!(f === w || e === f))
                            if (f != null  || e) {
                                a.type = "change";
                                return c.event.trigger(a, b, d)
                            }
                    }
                }
                ;
            c.event.special.change = {
                filters: {
                    focusout: fa,
                    click: function(a) {
                        var b = a.target
                            , d = b.type;
                        if (d === "radio" || d === "checkbox" || b.nodeName.toLowerCase() === "select")
                            return fa.call(this, a)
                    },
                    keydown: function(a) {
                        var b = a.target
                            , d = b.type;
                        if (a.keyCode === 13 && b.nodeName.toLowerCase() !== "textarea" || a.keyCode === 32 && (d === "checkbox" || d === "radio") || d === "select-multiple")
                            return fa.call(this, a)
                    },
                    beforeactivate: function(a) {
                        a = a.target;
                        c.data(a,
                            "_change_data", Fa(a))
                    }
                },
                setup: function() {
                    if (this.type === "file")
                        return false;
                    for (var a in ea)
                        c.event.add(this, a + ".specialChange", ea[a]);
                    return da.test(this.nodeName)
                },
                teardown: function() {
                    c.event.remove(this, ".specialChange");
                    return da.test(this.nodeName)
                }
            };
            ea = c.event.special.change.filters
        }
        s.addEventListener && c.each({
                focus: "focusin",
                blur: "focusout"
            }, function(a, b) {
                function d(f) {
                    f = c.event.fix(f);
                    f.type = b;
                    return c.event.handle.call(this, f)
                }
                c.event.special[b] = {
                    setup: function() {
                        this.addEventListener(a,
                            d, true)
                    },
                    teardown: function() {
                        this.removeEventListener(a, d, true)
                    }
                }
            }
        );
        c.each(["bind", "one"], function(a, b) {
                c.fn[b] = function(d, f, e) {
                    if (typeof d === "object") {
                        for (var j in d)
                            this[b](j, f, d[j], e);
                        return this
                    }
                    if (c.isFunction(f)) {
                        e = f;
                        f = w
                    }
                    var i = b === "one" ? c.proxy(e, function(k) {
                                c(this).unbind(k, i);
                                return e.apply(this, arguments)
                            }
                        ) : e;
                    if (d === "unload" && b !== "one")
                        this.one(d, f, e);
                    else {
                        j = 0;
                        for (var o = this.length; j < o; j++)
                            c.event.add(this[j], d, i, f)
                    }
                    return this
                }
            }
        );
        c.fn.extend({
            unbind: function(a, b) {
                if (typeof a === "object" &&
                    !a.preventDefault)
                    for (var d in a)
                        this.unbind(d, a[d]);
                else {
                    d = 0;
                    for (var f = this.length; d < f; d++)
                        c.event.remove(this[d], a, b)
                }
                return this
            },
            delegate: function(a, b, d, f) {
                return this.live(b, d, f, a)
            },
            undelegate: function(a, b, d) {
                return arguments.length === 0 ? this.unbind("live") : this.die(b, null , d, a)
            },
            trigger: function(a, b) {
                return this.each(function() {
                        c.event.trigger(a, b, this)
                    }
                )
            },
            triggerHandler: function(a, b) {
                if (this[0]) {
                    a = c.Event(a);
                    a.preventDefault();
                    a.stopPropagation();
                    c.event.trigger(a, b, this[0]);
                    return a.result
                }
            },
            toggle: function(a) {
                for (var b = arguments, d = 1; d < b.length; )
                    c.proxy(a, b[d++]);
                return this.click(c.proxy(a, function(f) {
                        var e = (c.data(this, "lastToggle" + a.guid) || 0) % d;
                        c.data(this, "lastToggle" + a.guid, e + 1);
                        f.preventDefault();
                        return b[e].apply(this, arguments) || false
                    }
                ))
            },
            hover: function(a, b) {
                return this.mouseenter(a).mouseleave(b || a)
            }
        });
        var Ga = {
            focus: "focusin",
            blur: "focusout",
            mouseenter: "mouseover",
            mouseleave: "mouseout"
        };
        c.each(["live", "die"], function(a, b) {
                c.fn[b] = function(d, f, e, j) {
                    var i, o = 0, k, n, r = j || this.selector,
                        u = j ? this : c(this.context);
                    if (c.isFunction(f)) {
                        e = f;
                        f = w
                    }
                    for (d = (d || "").split(" "); (i = d[o++]) != null ; ) {
                        j = O.exec(i);
                        k = "";
                        if (j) {
                            k = j[0];
                            i = i.replace(O, "")
                        }
                        if (i === "hover")
                            d.push("mouseenter" + k, "mouseleave" + k);
                        else {
                            n = i;
                            if (i === "focus" || i === "blur") {
                                d.push(Ga[i] + k);
                                i += k
                            } else
                                i = (Ga[i] || i) + k;
                            b === "live" ? u.each(function() {
                                        c.event.add(this, pa(i, r), {
                                            data: f,
                                            selector: r,
                                            handler: e,
                                            origType: i,
                                            origHandler: e,
                                            preType: n
                                        })
                                    }
                                ) : u.unbind(pa(i, r), e)
                        }
                    }
                    return this
                }
            }
        );
        c.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error".split(" "),
            function(a, b) {
                c.fn[b] = function(d) {
                    return d ? this.bind(b, d) : this.trigger(b)
                }
                ;
                if (c.attrFn)
                    c.attrFn[b] = true
            }
        );
        A.attachEvent && !A.addEventListener && A.attachEvent("onunload", function() {
                for (var a in c.cache)
                    if (c.cache[a].handle)
                        try {
                            c.event.remove(c.cache[a].handle.elem)
                        } catch (b) {}
            }
        );
        (function() {
                function a(g) {
                    for (var h = "", l, m = 0; g[m]; m++) {
                        l = g[m];
                        if (l.nodeType === 3 || l.nodeType === 4)
                            h += l.nodeValue;
                        else if (l.nodeType !== 8)
                            h += a(l.childNodes)
                    }
                    return h
                }
                function b(g, h, l, m, q, p) {
                    q = 0;
                    for (var v = m.length; q < v; q++) {
                        var t = m[q];
                        if (t) {
                            t = t[g];
                            for (var y = false; t; ) {
                                if (t.sizcache === l) {
                                    y = m[t.sizset];
                                    break
                                }
                                if (t.nodeType === 1 && !p) {
                                    t.sizcache = l;
                                    t.sizset = q
                                }
                                if (t.nodeName.toLowerCase() === h) {
                                    y = t;
                                    break
                                }
                                t = t[g]
                            }
                            m[q] = y
                        }
                    }
                }
                function d(g, h, l, m, q, p) {
                    q = 0;
                    for (var v = m.length; q < v; q++) {
                        var t = m[q];
                        if (t) {
                            t = t[g];
                            for (var y = false; t; ) {
                                if (t.sizcache === l) {
                                    y = m[t.sizset];
                                    break
                                }
                                if (t.nodeType === 1) {
                                    if (!p) {
                                        t.sizcache = l;
                                        t.sizset = q
                                    }
                                    if (typeof h !== "string") {
                                        if (t === h) {
                                            y = true;
                                            break
                                        }
                                    } else if (k.filter(h, [t]).length > 0) {
                                        y = t;
                                        break
                                    }
                                }
                                t = t[g]
                            }
                            m[q] = y
                        }
                    }
                }
                var f = /((?:\((?:\([^()]+\)|[^()]+)+\)|\[(?:\[[^[\]]*\]|['"][^'"]*['"]|[^[\]'"]+)+\]|\\.|[^ >+~,(\[\\]+)+|[>+~])(\s*,\s*)?((?:.|\r|\n)*)/g
                    ,
                    e = 0
                    , j = Object.prototype.toString
                    , i = false
                    , o = true;
                [0, 0].sort(function() {
                        o = false;
                        return 0
                    }
                );
                var k = function(g, h, l, m) {
                        l = l || [];
                        var q = h = h || s;
                        if (h.nodeType !== 1 && h.nodeType !== 9)
                            return [];
                        if (!g || typeof g !== "string")
                            return l;
                        for (var p = [], v, t, y, S, H = true, M = x(h), I = g; (f.exec(""),
                            v = f.exec(I)) !== null ; ) {
                            I = v[3];
                            p.push(v[1]);
                            if (v[2]) {
                                S = v[3];
                                break
                            }
                        }
                        if (p.length > 1 && r.exec(g))
                            if (p.length === 2 && n.relative[p[0]])
                                t = ga(p[0] + p[1], h);
                            else
                                for (t = n.relative[p[0]] ? [h] : k(p.shift(), h); p.length; ) {
                                    g = p.shift();
                                    if (n.relative[g])
                                        g += p.shift();
                                    t = ga(g, t)
                                }
                        else {
                            if (!m && p.length > 1 && h.nodeType === 9 && !M && n.match.ID.test(p[0]) && !n.match.ID.test(p[p.length - 1])) {
                                v = k.find(p.shift(), h, M);
                                h = v.expr ? k.filter(v.expr, v.set)[0] : v.set[0]
                            }
                            if (h) {
                                v = m ? {
                                        expr: p.pop(),
                                        set: z(m)
                                    } : k.find(p.pop(), p.length === 1 && (p[0] === "~" || p[0] === "+") && h.parentNode ? h.parentNode : h, M);
                                t = v.expr ? k.filter(v.expr, v.set) : v.set;
                                if (p.length > 0)
                                    y = z(t);
                                else
                                    H = false;
                                for (; p.length; ) {
                                    var D = p.pop();
                                    v = D;
                                    if (n.relative[D])
                                        v = p.pop();
                                    else
                                        D = "";
                                    if (v == null )
                                        v = h;
                                    n.relative[D](y, v, M)
                                }
                            } else
                                y = []
                        }
                        y || (y = t);
                        y || k.error(D ||
                            g);
                        if (j.call(y) === "[object Array]")
                            if (H)
                                if (h && h.nodeType === 1)
                                    for (g = 0; y[g] != null ; g++) {
                                        if (y[g] && (y[g] === true || y[g].nodeType === 1 && E(h, y[g])))
                                            l.push(t[g])
                                    }
                                else
                                    for (g = 0; y[g] != null ; g++)
                                        y[g] && y[g].nodeType === 1 && l.push(t[g]);
                            else
                                l.push.apply(l, y);
                        else
                            z(y, l);
                        if (S) {
                            k(S, q, l, m);
                            k.uniqueSort(l)
                        }
                        return l
                    }
                    ;
                k.uniqueSort = function(g) {
                    if (B) {
                        i = o;
                        g.sort(B);
                        if (i)
                            for (var h = 1; h < g.length; h++)
                                g[h] === g[h - 1] && g.splice(h--, 1)
                    }
                    return g
                }
                ;
                k.matches = function(g, h) {
                    return k(g, null , null , h)
                }
                ;
                k.find = function(g, h, l) {
                    var m, q;
                    if (!g)
                        return [];
                    for (var p = 0, v = n.order.length; p < v; p++) {
                        var t = n.order[p];
                        if (q = n.leftMatch[t].exec(g)) {
                            var y = q[1];
                            q.splice(1, 1);
                            if (y.substr(y.length - 1) !== "\\") {
                                q[1] = (q[1] || "").replace(/\\/g, "");
                                m = n.find[t](q, h, l);
                                if (m != null ) {
                                    g = g.replace(n.match[t], "");
                                    break
                                }
                            }
                        }
                    }
                    m || (m = h.getElementsByTagName("*"));
                    return {
                        set: m,
                        expr: g
                    }
                }
                ;
                k.filter = function(g, h, l, m) {
                    for (var q = g, p = [], v = h, t, y, S = h && h[0] && x(h[0]); g && h.length; ) {
                        for (var H in n.filter)
                            if ((t = n.leftMatch[H].exec(g)) != null  && t[2]) {
                                var M = n.filter[H], I, D;
                                D = t[1];
                                y = false;
                                t.splice(1, 1);
                                if (D.substr(D.length -
                                        1) !== "\\") {
                                    if (v === p)
                                        p = [];
                                    if (n.preFilter[H])
                                        if (t = n.preFilter[H](t, v, l, p, m, S)) {
                                            if (t === true)
                                                continue
                                        } else
                                            y = I = true;
                                    if (t)
                                        for (var U = 0; (D = v[U]) != null ; U++)
                                            if (D) {
                                                I = M(D, t, U, v);
                                                var Ha = m ^ !!I;
                                                if (l && I != null )
                                                    if (Ha)
                                                        y = true;
                                                    else
                                                        v[U] = false;
                                                else if (Ha) {
                                                    p.push(D);
                                                    y = true
                                                }
                                            }
                                    if (I !== w) {
                                        l || (v = p);
                                        g = g.replace(n.match[H], "");
                                        if (!y)
                                            return [];
                                        break
                                    }
                                }
                            }
                        if (g === q)
                            if (y == null )
                                k.error(g);
                            else
                                break;
                        q = g
                    }
                    return v
                }
                ;
                k.error = function(g) {
                    throw "Syntax error, unrecognized expression: " + g;
                }
                ;
                var n = k.selectors = {
                    order: ["ID", "NAME", "TAG"],
                    match: {
                        ID: /#((?:[\w\u00c0-\uFFFF-]|\\.)+)/,
                        CLASS: /\.((?:[\w\u00c0-\uFFFF-]|\\.)+)/,
                        NAME: /\[name=['"]*((?:[\w\u00c0-\uFFFF-]|\\.)+)['"]*\]/,
                        ATTR: /\[\s*((?:[\w\u00c0-\uFFFF-]|\\.)+)\s*(?:(\S?=)\s*(['"]*)(.*?)\3|)\s*\]/,
                        TAG: /^((?:[\w\u00c0-\uFFFF\*-]|\\.)+)/,
                        CHILD: /:(only|nth|last|first)-child(?:\((even|odd|[\dn+-]*)\))?/,
                        POS: /:(nth|eq|gt|lt|first|last|even|odd)(?:\((\d*)\))?(?=[^-]|$)/,
                        PSEUDO: /:((?:[\w\u00c0-\uFFFF-]|\\.)+)(?:\((['"]?)((?:\([^\)]+\)|[^\(\)]*)+)\2\))?/
                    },
                    leftMatch: {},
                    attrMap: {
                        "class": "className",
                        "for": "htmlFor"
                    },
                    attrHandle: {
                        href: function(g) {
                            return g.getAttribute("href")
                        }
                    },
                    relative: {
                        "+": function(g, h) {
                            var l = typeof h === "string"
                                , m = l && !/\W/.test(h);
                            l = l && !m;
                            if (m)
                                h = h.toLowerCase();
                            m = 0;
                            for (var q = g.length, p; m < q; m++)
                                if (p = g[m]) {
                                    for (; (p = p.previousSibling) && p.nodeType !== 1; )
                                        ;
                                    g[m] = l || p && p.nodeName.toLowerCase() === h ? p || false : p === h
                                }
                            l && k.filter(h, g, true)
                        },
                        ">": function(g, h) {
                            var l = typeof h === "string";
                            if (l && !/\W/.test(h)) {
                                h = h.toLowerCase();
                                for (var m = 0, q = g.length; m < q; m++) {
                                    var p = g[m];
                                    if (p) {
                                        l = p.parentNode;
                                        g[m] = l.nodeName.toLowerCase() === h ? l : false
                                    }
                                }
                            } else {
                                m = 0;
                                for (q = g.length; m < q; m++)
                                    if (p = g[m])
                                        g[m] =
                                            l ? p.parentNode : p.parentNode === h;
                                l && k.filter(h, g, true)
                            }
                        },
                        "": function(g, h, l) {
                            var m = e++
                                , q = d;
                            if (typeof h === "string" && !/\W/.test(h)) {
                                var p = h = h.toLowerCase();
                                q = b
                            }
                            q("parentNode", h, m, g, p, l)
                        },
                        "~": function(g, h, l) {
                            var m = e++
                                , q = d;
                            if (typeof h === "string" && !/\W/.test(h)) {
                                var p = h = h.toLowerCase();
                                q = b
                            }
                            q("previousSibling", h, m, g, p, l)
                        }
                    },
                    find: {
                        ID: function(g, h, l) {
                            if (typeof h.getElementById !== "undefined" && !l)
                                return (g = h.getElementById(g[1])) ? [g] : []
                        },
                        NAME: function(g, h) {
                            if (typeof h.getElementsByName !== "undefined") {
                                var l = [];
                                h = h.getElementsByName(g[1]);
                                for (var m = 0, q = h.length; m < q; m++)
                                    h[m].getAttribute("name") === g[1] && l.push(h[m]);
                                return l.length === 0 ? null  : l
                            }
                        },
                        TAG: function(g, h) {
                            return h.getElementsByTagName(g[1])
                        }
                    },
                    preFilter: {
                        CLASS: function(g, h, l, m, q, p) {
                            g = " " + g[1].replace(/\\/g, "") + " ";
                            if (p)
                                return g;
                            p = 0;
                            for (var v; (v = h[p]) != null ; p++)
                                if (v)
                                    if (q ^ (v.className && (" " + v.className + " ").replace(/[\t\n]/g, " ").indexOf(g) >= 0))
                                        l || m.push(v);
                                    else if (l)
                                        h[p] = false;
                            return false
                        },
                        ID: function(g) {
                            return g[1].replace(/\\/g, "")
                        },
                        TAG: function(g) {
                            return g[1].toLowerCase()
                        },
                        CHILD: function(g) {
                            if (g[1] === "nth") {
                                var h = /(-?)(\d*)n((?:\+|-)?\d*)/.exec(g[2] === "even" && "2n" || g[2] === "odd" && "2n+1" || !/\D/.test(g[2]) && "0n+" + g[2] || g[2]);
                                g[2] = h[1] + (h[2] || 1) - 0;
                                g[3] = h[3] - 0
                            }
                            g[0] = e++;
                            return g
                        },
                        ATTR: function(g, h, l, m, q, p) {
                            h = g[1].replace(/\\/g, "");
                            if (!p && n.attrMap[h])
                                g[1] = n.attrMap[h];
                            if (g[2] === "~=")
                                g[4] = " " + g[4] + " ";
                            return g
                        },
                        PSEUDO: function(g, h, l, m, q) {
                            if (g[1] === "not")
                                if ((f.exec(g[3]) || "").length > 1 || /^\w/.test(g[3]))
                                    g[3] = k(g[3], null , null , h);
                                else {
                                    g = k.filter(g[3], h, l, true ^ q);
                                    l || m.push.apply(m,
                                        g);
                                    return false
                                }
                            else if (n.match.POS.test(g[0]) || n.match.CHILD.test(g[0]))
                                return true;
                            return g
                        },
                        POS: function(g) {
                            g.unshift(true);
                            return g
                        }
                    },
                    filters: {
                        enabled: function(g) {
                            return g.disabled === false && g.type !== "hidden"
                        },
                        disabled: function(g) {
                            return g.disabled === true
                        },
                        checked: function(g) {
                            return g.checked === true
                        },
                        selected: function(g) {
                            return g.selected === true
                        },
                        parent: function(g) {
                            return !!g.firstChild
                        },
                        empty: function(g) {
                            return !g.firstChild
                        },
                        has: function(g, h, l) {
                            return !!k(l[3], g).length
                        },
                        header: function(g) {
                            return /h\d/i.test(g.nodeName)
                        },
                        text: function(g) {
                            return "text" === g.type
                        },
                        radio: function(g) {
                            return "radio" === g.type
                        },
                        checkbox: function(g) {
                            return "checkbox" === g.type
                        },
                        file: function(g) {
                            return "file" === g.type
                        },
                        password: function(g) {
                            return "password" === g.type
                        },
                        submit: function(g) {
                            return "submit" === g.type
                        },
                        image: function(g) {
                            return "image" === g.type
                        },
                        reset: function(g) {
                            return "reset" === g.type
                        },
                        button: function(g) {
                            return "button" === g.type || g.nodeName.toLowerCase() === "button"
                        },
                        input: function(g) {
                            return /input|select|textarea|button/i.test(g.nodeName)
                        }
                    },
                    setFilters: {
                        first: function(g, h) {
                            return h === 0
                        },
                        last: function(g, h, l, m) {
                            return h === m.length - 1
                        },
                        even: function(g, h) {
                            return h % 2 === 0
                        },
                        odd: function(g, h) {
                            return h % 2 === 1
                        },
                        lt: function(g, h, l) {
                            return h < l[3] - 0
                        },
                        gt: function(g, h, l) {
                            return h > l[3] - 0
                        },
                        nth: function(g, h, l) {
                            return l[3] - 0 === h
                        },
                        eq: function(g, h, l) {
                            return l[3] - 0 === h
                        }
                    },
                    filter: {
                        PSEUDO: function(g, h, l, m) {
                            var q = h[1]
                                , p = n.filters[q];
                            if (p)
                                return p(g, l, h, m);
                            else if (q === "contains")
                                return (g.textContent || g.innerText || a([g]) || "").indexOf(h[3]) >= 0;
                            else if (q === "not") {
                                h =
                                    h[3];
                                l = 0;
                                for (m = h.length; l < m; l++)
                                    if (h[l] === g)
                                        return false;
                                return true
                            } else
                                k.error("Syntax error, unrecognized expression: " + q)
                        },
                        CHILD: function(g, h) {
                            var l = h[1]
                                , m = g;
                            switch (l) {
                                case "only":
                                case "first":
                                    for (; m = m.previousSibling; )
                                        if (m.nodeType === 1)
                                            return false;
                                    if (l === "first")
                                        return true;
                                    m = g;
                                case "last":
                                    for (; m = m.nextSibling; )
                                        if (m.nodeType === 1)
                                            return false;
                                    return true;
                                case "nth":
                                    l = h[2];
                                    var q = h[3];
                                    if (l === 1 && q === 0)
                                        return true;
                                    h = h[0];
                                    var p = g.parentNode;
                                    if (p && (p.sizcache !== h || !g.nodeIndex)) {
                                        var v = 0;
                                        for (m = p.firstChild; m; m =
                                            m.nextSibling)
                                            if (m.nodeType === 1)
                                                m.nodeIndex = ++v;
                                        p.sizcache = h
                                    }
                                    g = g.nodeIndex - q;
                                    return l === 0 ? g === 0 : g % l === 0 && g / l >= 0
                            }
                        },
                        ID: function(g, h) {
                            return g.nodeType === 1 && g.getAttribute("id") === h
                        },
                        TAG: function(g, h) {
                            return h === "*" && g.nodeType === 1 || g.nodeName.toLowerCase() === h
                        },
                        CLASS: function(g, h) {
                            return (" " + (g.className || g.getAttribute("class")) + " ").indexOf(h) > -1
                        },
                        ATTR: function(g, h) {
                            var l = h[1];
                            g = n.attrHandle[l] ? n.attrHandle[l](g) : g[l] != null  ? g[l] : g.getAttribute(l);
                            l = g + "";
                            var m = h[2];
                            h = h[4];
                            return g == null  ? m === "!=" : m ===
                                "=" ? l === h : m === "*=" ? l.indexOf(h) >= 0 : m === "~=" ? (" " + l + " ").indexOf(h) >= 0 : !h ? l && g !== false : m === "!=" ? l !== h : m === "^=" ? l.indexOf(h) === 0 : m === "$=" ? l.substr(l.length - h.length) === h : m === "|=" ? l === h || l.substr(0, h.length + 1) === h + "-" : false
                        },
                        POS: function(g, h, l, m) {
                            var q = n.setFilters[h[2]];
                            if (q)
                                return q(g, l, h, m)
                        }
                    }
                }
                    , r = n.match.POS;
                for (var u in n.match) {
                    n.match[u] = new RegExp(n.match[u].source + /(?![^\[]*\])(?![^\(]*\))/.source);
                    n.leftMatch[u] = new RegExp(/(^(?:.|\r|\n)*?)/.source + n.match[u].source.replace(/\\(\d+)/g, function(g,
                                                                                                                           h) {
                                return "\\" + (h - 0 + 1)
                            }
                        ))
                }
                var z = function(g, h) {
                        g = Array.prototype.slice.call(g, 0);
                        if (h) {
                            h.push.apply(h, g);
                            return h
                        }
                        return g
                    }
                    ;
                try {
                    Array.prototype.slice.call(s.documentElement.childNodes, 0)
                } catch (C) {
                    z = function(g, h) {
                        h = h || [];
                        if (j.call(g) === "[object Array]")
                            Array.prototype.push.apply(h, g);
                        else if (typeof g.length === "number")
                            for (var l = 0, m = g.length; l < m; l++)
                                h.push(g[l]);
                        else
                            for (l = 0; g[l]; l++)
                                h.push(g[l]);
                        return h
                    }
                }
                var B;
                if (s.documentElement.compareDocumentPosition)
                    B = function(g, h) {
                        if (!g.compareDocumentPosition ||
                            !h.compareDocumentPosition) {
                            if (g == h)
                                i = true;
                            return g.compareDocumentPosition ? -1 : 1
                        }
                        g = g.compareDocumentPosition(h) & 4 ? -1 : g === h ? 0 : 1;
                        if (g === 0)
                            i = true;
                        return g
                    }
                    ;
                else if ("sourceIndex" in s.documentElement)
                    B = function(g, h) {
                        if (!g.sourceIndex || !h.sourceIndex) {
                            if (g == h)
                                i = true;
                            return g.sourceIndex ? -1 : 1
                        }
                        g = g.sourceIndex - h.sourceIndex;
                        if (g === 0)
                            i = true;
                        return g
                    }
                    ;
                else if (s.createRange)
                    B = function(g, h) {
                        if (!g.ownerDocument || !h.ownerDocument) {
                            if (g == h)
                                i = true;
                            return g.ownerDocument ? -1 : 1
                        }
                        var l = g.ownerDocument.createRange()
                            , m =
                            h.ownerDocument.createRange();
                        l.setStart(g, 0);
                        l.setEnd(g, 0);
                        m.setStart(h, 0);
                        m.setEnd(h, 0);
                        g = l.compareBoundaryPoints(Range.START_TO_END, m);
                        if (g === 0)
                            i = true;
                        return g
                    }
                    ;
                (function() {
                        var g = s.createElement("div")
                            , h = "script" + (new Date).getTime();
                        g.innerHTML = "<a name='" + h + "'/>";
                        var l = s.documentElement;
                        l.insertBefore(g, l.firstChild);
                        if (s.getElementById(h)) {
                            n.find.ID = function(m, q, p) {
                                if (typeof q.getElementById !== "undefined" && !p)
                                    return (q = q.getElementById(m[1])) ? q.id === m[1] || typeof q.getAttributeNode !== "undefined" &&
                                        q.getAttributeNode("id").nodeValue === m[1] ? [q] : w : []
                            }
                            ;
                            n.filter.ID = function(m, q) {
                                var p = typeof m.getAttributeNode !== "undefined" && m.getAttributeNode("id");
                                return m.nodeType === 1 && p && p.nodeValue === q
                            }
                        }
                        l.removeChild(g);
                        l = g = null
                    }
                )();
                (function() {
                        var g = s.createElement("div");
                        g.appendChild(s.createComment(""));
                        if (g.getElementsByTagName("*").length > 0)
                            n.find.TAG = function(h, l) {
                                l = l.getElementsByTagName(h[1]);
                                if (h[1] === "*") {
                                    h = [];
                                    for (var m = 0; l[m]; m++)
                                        l[m].nodeType === 1 && h.push(l[m]);
                                    l = h
                                }
                                return l
                            }
                            ;
                        g.innerHTML = "<a href='#'></a>";
                        if (g.firstChild && typeof g.firstChild.getAttribute !== "undefined" && g.firstChild.getAttribute("href") !== "#")
                            n.attrHandle.href = function(h) {
                                return h.getAttribute("href", 2)
                            }
                            ;
                        g = null
                    }
                )();
                s.querySelectorAll && function() {
                    var g = k
                        , h = s.createElement("div");
                    h.innerHTML = "<p class='TEST'></p>";
                    if (!(h.querySelectorAll && h.querySelectorAll(".TEST").length === 0)) {
                        k = function(m, q, p, v) {
                            q = q || s;
                            if (!v && q.nodeType === 9 && !x(q))
                                try {
                                    return z(q.querySelectorAll(m), p)
                                } catch (t) {}
                            return g(m, q, p, v)
                        }
                        ;
                        for (var l in g)
                            k[l] = g[l];
                        h = null
                    }
                }
                ();
                (function() {
                        var g = s.createElement("div");
                        g.innerHTML = "<div class='test e'></div><div class='test'></div>";
                        if (!(!g.getElementsByClassName || g.getElementsByClassName("e").length === 0)) {
                            g.lastChild.className = "e";
                            if (g.getElementsByClassName("e").length !== 1) {
                                n.order.splice(1, 0, "CLASS");
                                n.find.CLASS = function(h, l, m) {
                                    if (typeof l.getElementsByClassName !== "undefined" && !m)
                                        return l.getElementsByClassName(h[1])
                                }
                                ;
                                g = null
                            }
                        }
                    }
                )();
                var E = s.compareDocumentPosition ? function(g, h) {
                            return !!(g.compareDocumentPosition(h) & 16)
                        }
                        :
                        function(g, h) {
                            return g !== h && (g.contains ? g.contains(h) : true)
                        }
                    , x = function(g) {
                        return (g = (g ? g.ownerDocument || g : 0).documentElement) ? g.nodeName !== "HTML" : false
                    }
                    , ga = function(g, h) {
                        var l = [], m = "", q;
                        for (h = h.nodeType ? [h] : h; q = n.match.PSEUDO.exec(g); ) {
                            m += q[0];
                            g = g.replace(n.match.PSEUDO, "")
                        }
                        g = n.relative[g] ? g + "*" : g;
                        q = 0;
                        for (var p = h.length; q < p; q++)
                            k(g, h[q], l);
                        return k.filter(m, l)
                    }
                    ;
                c.find = k;
                c.expr = k.selectors;
                c.expr[":"] = c.expr.filters;
                c.unique = k.uniqueSort;
                c.text = a;
                c.isXMLDoc = x;
                c.contains = E
            }
        )();
        var eb = /Until$/
            , fb = /^(?:parents|prevUntil|prevAll)/
            ,
            gb = /,/;
        R = Array.prototype.slice;
        var Ia = function(a, b, d) {
                if (c.isFunction(b))
                    return c.grep(a, function(e, j) {
                            return !!b.call(e, j, e) === d
                        }
                    );
                else if (b.nodeType)
                    return c.grep(a, function(e) {
                            return e === b === d
                        }
                    );
                else if (typeof b === "string") {
                    var f = c.grep(a, function(e) {
                            return e.nodeType === 1
                        }
                    );
                    if (Ua.test(b))
                        return c.filter(b, f, !d);
                    else
                        b = c.filter(b, f)
                }
                return c.grep(a, function(e) {
                        return c.inArray(e, b) >= 0 === d
                    }
                )
            }
            ;
        c.fn.extend({
            find: function(a) {
                for (var b = this.pushStack("", "find", a), d = 0, f = 0, e = this.length; f < e; f++) {
                    d = b.length;
                    c.find(a, this[f], b);
                    if (f > 0)
                        for (var j = d; j < b.length; j++)
                            for (var i = 0; i < d; i++)
                                if (b[i] === b[j]) {
                                    b.splice(j--, 1);
                                    break
                                }
                }
                return b
            },
            has: function(a) {
                var b = c(a);
                return this.filter(function() {
                        for (var d = 0, f = b.length; d < f; d++)
                            if (c.contains(this, b[d]))
                                return true
                    }
                )
            },
            not: function(a) {
                return this.pushStack(Ia(this, a, false), "not", a)
            },
            filter: function(a) {
                return this.pushStack(Ia(this, a, true), "filter", a)
            },
            is: function(a) {
                return !!a && c.filter(a, this).length > 0
            },
            closest: function(a, b) {
                if (c.isArray(a)) {
                    var d = [], f = this[0], e, j =
                        {}, i;
                    if (f && a.length) {
                        e = 0;
                        for (var o = a.length; e < o; e++) {
                            i = a[e];
                            j[i] || (j[i] = c.expr.match.POS.test(i) ? c(i, b || this.context) : i)
                        }
                        for (; f && f.ownerDocument && f !== b; ) {
                            for (i in j) {
                                e = j[i];
                                if (e.jquery ? e.index(f) > -1 : c(f).is(e)) {
                                    d.push({
                                        selector: i,
                                        elem: f
                                    });
                                    delete j[i]
                                }
                            }
                            f = f.parentNode
                        }
                    }
                    return d
                }
                var k = c.expr.match.POS.test(a) ? c(a, b || this.context) : null ;
                return this.map(function(n, r) {
                        for (; r && r.ownerDocument && r !== b; ) {
                            if (k ? k.index(r) > -1 : c(r).is(a))
                                return r;
                            r = r.parentNode
                        }
                        return null
                    }
                )
            },
            index: function(a) {
                if (!a || typeof a ===
                    "string")
                    return c.inArray(this[0], a ? c(a) : this.parent().children());
                return c.inArray(a.jquery ? a[0] : a, this)
            },
            add: function(a, b) {
                a = typeof a === "string" ? c(a, b || this.context) : c.makeArray(a);
                b = c.merge(this.get(), a);
                return this.pushStack(qa(a[0]) || qa(b[0]) ? b : c.unique(b))
            },
            andSelf: function() {
                return this.add(this.prevObject)
            }
        });
        c.each({
                parent: function(a) {
                    return (a = a.parentNode) && a.nodeType !== 11 ? a : null
                },
                parents: function(a) {
                    return c.dir(a, "parentNode")
                },
                parentsUntil: function(a, b, d) {
                    return c.dir(a, "parentNode",
                        d)
                },
                next: function(a) {
                    return c.nth(a, 2, "nextSibling")
                },
                prev: function(a) {
                    return c.nth(a, 2, "previousSibling")
                },
                nextAll: function(a) {
                    return c.dir(a, "nextSibling")
                },
                prevAll: function(a) {
                    return c.dir(a, "previousSibling")
                },
                nextUntil: function(a, b, d) {
                    return c.dir(a, "nextSibling", d)
                },
                prevUntil: function(a, b, d) {
                    return c.dir(a, "previousSibling", d)
                },
                siblings: function(a) {
                    return c.sibling(a.parentNode.firstChild, a)
                },
                children: function(a) {
                    return c.sibling(a.firstChild)
                },
                contents: function(a) {
                    return c.nodeName(a, "iframe") ?
                        a.contentDocument || a.contentWindow.document : c.makeArray(a.childNodes)
                }
            }, function(a, b) {
                c.fn[a] = function(d, f) {
                    var e = c.map(this, b, d);
                    eb.test(a) || (f = d);
                    if (f && typeof f === "string")
                        e = c.filter(f, e);
                    e = this.length > 1 ? c.unique(e) : e;
                    if ((this.length > 1 || gb.test(f)) && fb.test(a))
                        e = e.reverse();
                    return this.pushStack(e, a, R.call(arguments).join(","))
                }
            }
        );
        c.extend({
            filter: function(a, b, d) {
                if (d)
                    a = ":not(" + a + ")";
                return c.find.matches(a, b)
            },
            dir: function(a, b, d) {
                var f = [];
                for (a = a[b]; a && a.nodeType !== 9 && (d === w || a.nodeType !== 1 || !c(a).is(d)); ) {
                    a.nodeType ===
                    1 && f.push(a);
                    a = a[b]
                }
                return f
            },
            nth: function(a, b, d) {
                b = b || 1;
                for (var f = 0; a; a = a[d])
                    if (a.nodeType === 1 && ++f === b)
                        break;
                return a
            },
            sibling: function(a, b) {
                for (var d = []; a; a = a.nextSibling)
                    a.nodeType === 1 && a !== b && d.push(a);
                return d
            }
        });
        var Ja = / jQuery\d+="(?:\d+|null)"/g
            , V = /^\s+/
            , Ka = /(<([\w:]+)[^>]*?)\/>/g
            , hb = /^(?:area|br|col|embed|hr|img|input|link|meta|param)$/i
            , La = /<([\w:]+)/
            , ib = /<tbody/i
            , jb = /<|&#?\w+;/
            , ta = /<script|<object|<embed|<option|<style/i
            , ua = /checked\s*(?:[^=]|=\s*.checked.)/i
            , Ma = function(a, b, d) {
            return hb.test(d) ?
                a : b + "></" + d + ">"
        }
            , F = {
            option: [1, "<select multiple='multiple'>", "</select>"],
            legend: [1, "<fieldset>", "</fieldset>"],
            thead: [1, "<table>", "</table>"],
            tr: [2, "<table><tbody>", "</tbody></table>"],
            td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
            col: [2, "<table><tbody></tbody><colgroup>", "</colgroup></table>"],
            area: [1, "<map>", "</map>"],
            _default: [0, "", ""]
        };
        F.optgroup = F.option;
        F.tbody = F.tfoot = F.colgroup = F.caption = F.thead;
        F.th = F.td;
        if (!c.support.htmlSerialize)
            F._default = [1, "div<div>", "</div>"];
        c.fn.extend({
            text: function(a) {
                if (c.isFunction(a))
                    return this.each(function(b) {
                            var d =
                                c(this);
                            d.text(a.call(this, b, d.text()))
                        }
                    );
                if (typeof a !== "object" && a !== w)
                    return this.empty().append((this[0] && this[0].ownerDocument || s).createTextNode(a));
                return c.text(this)
            },
            wrapAll: function(a) {
                if (c.isFunction(a))
                    return this.each(function(d) {
                            c(this).wrapAll(a.call(this, d))
                        }
                    );
                if (this[0]) {
                    var b = c(a, this[0].ownerDocument).eq(0).clone(true);
                    this[0].parentNode && b.insertBefore(this[0]);
                    b.map(function() {
                            for (var d = this; d.firstChild && d.firstChild.nodeType === 1; )
                                d = d.firstChild;
                            return d
                        }
                    ).append(this)
                }
                return this
            },
            wrapInner: function(a) {
                if (c.isFunction(a))
                    return this.each(function(b) {
                            c(this).wrapInner(a.call(this, b))
                        }
                    );
                return this.each(function() {
                        var b = c(this)
                            , d = b.contents();
                        d.length ? d.wrapAll(a) : b.append(a)
                    }
                )
            },
            wrap: function(a) {
                return this.each(function() {
                        c(this).wrapAll(a)
                    }
                )
            },
            unwrap: function() {
                return this.parent().each(function() {
                        c.nodeName(this, "body") || c(this).replaceWith(this.childNodes)
                    }
                ).end()
            },
            append: function() {
                return this.domManip(arguments, true, function(a) {
                        this.nodeType === 1 && this.appendChild(a)
                    }
                )
            },
            prepend: function() {
                return this.domManip(arguments, true, function(a) {
                        this.nodeType === 1 && this.insertBefore(a, this.firstChild)
                    }
                )
            },
            before: function() {
                if (this[0] && this[0].parentNode)
                    return this.domManip(arguments, false, function(b) {
                            this.parentNode.insertBefore(b, this)
                        }
                    );
                else if (arguments.length) {
                    var a = c(arguments[0]);
                    a.push.apply(a, this.toArray());
                    return this.pushStack(a, "before", arguments)
                }
            },
            after: function() {
                if (this[0] && this[0].parentNode)
                    return this.domManip(arguments, false, function(b) {
                            this.parentNode.insertBefore(b,
                                this.nextSibling)
                        }
                    );
                else if (arguments.length) {
                    var a = this.pushStack(this, "after", arguments);
                    a.push.apply(a, c(arguments[0]).toArray());
                    return a
                }
            },
            remove: function(a, b) {
                for (var d = 0, f; (f = this[d]) != null ; d++)
                    if (!a || c.filter(a, [f]).length) {
                        if (!b && f.nodeType === 1) {
                            c.cleanData(f.getElementsByTagName("*"));
                            c.cleanData([f])
                        }
                        f.parentNode && f.parentNode.removeChild(f)
                    }
                return this
            },
            empty: function() {
                for (var a = 0, b; (b = this[a]) != null ; a++)
                    for (b.nodeType === 1 && c.cleanData(b.getElementsByTagName("*")); b.firstChild; )
                        b.removeChild(b.firstChild);
                return this
            },
            clone: function(a) {
                var b = this.map(function() {
                        if (!c.support.noCloneEvent && !c.isXMLDoc(this)) {
                            var d = this.outerHTML
                                , f = this.ownerDocument;
                            if (!d) {
                                d = f.createElement("div");
                                d.appendChild(this.cloneNode(true));
                                d = d.innerHTML
                            }
                            return c.clean([d.replace(Ja, "").replace(/=([^="'>\s]+\/)>/g, '="$1">').replace(V, "")], f)[0]
                        } else
                            return this.cloneNode(true)
                    }
                );
                if (a === true) {
                    ra(this, b);
                    ra(this.find("*"), b.find("*"))
                }
                return b
            },
            html: function(a) {
                if (a === w)
                    return this[0] && this[0].nodeType === 1 ? this[0].innerHTML.replace(Ja,
                            "") : null ;
                else if (typeof a === "string" && !ta.test(a) && (c.support.leadingWhitespace || !V.test(a)) && !F[(La.exec(a) || ["", ""])[1].toLowerCase()]) {
                    a = a.replace(Ka, Ma);
                    try {
                        for (var b = 0, d = this.length; b < d; b++)
                            if (this[b].nodeType === 1) {
                                c.cleanData(this[b].getElementsByTagName("*"));
                                this[b].innerHTML = a
                            }
                    } catch (f) {
                        this.empty().append(a)
                    }
                } else
                    c.isFunction(a) ? this.each(function(e) {
                                var j = c(this)
                                    , i = j.html();
                                j.empty().append(function() {
                                        return a.call(this, e, i)
                                    }
                                )
                            }
                        ) : this.empty().append(a);
                return this
            },
            replaceWith: function(a) {
                if (this[0] &&
                    this[0].parentNode) {
                    if (c.isFunction(a))
                        return this.each(function(b) {
                                var d = c(this)
                                    , f = d.html();
                                d.replaceWith(a.call(this, b, f))
                            }
                        );
                    if (typeof a !== "string")
                        a = c(a).detach();
                    return this.each(function() {
                            var b = this.nextSibling
                                , d = this.parentNode;
                            c(this).remove();
                            b ? c(b).before(a) : c(d).append(a)
                        }
                    )
                } else
                    return this.pushStack(c(c.isFunction(a) ? a() : a), "replaceWith", a)
            },
            detach: function(a) {
                return this.remove(a, true)
            },
            domManip: function(a, b, d) {
                function f(u) {
                    return c.nodeName(u, "table") ? u.getElementsByTagName("tbody")[0] ||
                        u.appendChild(u.ownerDocument.createElement("tbody")) : u
                }
                var e, j, i = a[0], o = [], k;
                if (!c.support.checkClone && arguments.length === 3 && typeof i === "string" && ua.test(i))
                    return this.each(function() {
                            c(this).domManip(a, b, d, true)
                        }
                    );
                if (c.isFunction(i))
                    return this.each(function(u) {
                            var z = c(this);
                            a[0] = i.call(this, u, b ? z.html() : w);
                            z.domManip(a, b, d)
                        }
                    );
                if (this[0]) {
                    e = i && i.parentNode;
                    e = c.support.parentNode && e && e.nodeType === 11 && e.childNodes.length === this.length ? {
                            fragment: e
                        } : sa(a, this, o);
                    k = e.fragment;
                    if (j = k.childNodes.length ===
                        1 ? (k = k.firstChild) : k.firstChild) {
                        b = b && c.nodeName(j, "tr");
                        for (var n = 0, r = this.length; n < r; n++)
                            d.call(b ? f(this[n], j) : this[n], n > 0 || e.cacheable || this.length > 1 ? k.cloneNode(true) : k)
                    }
                    o.length && c.each(o, Qa)
                }
                return this
            }
        });
        c.fragments = {};
        c.each({
                appendTo: "append",
                prependTo: "prepend",
                insertBefore: "before",
                insertAfter: "after",
                replaceAll: "replaceWith"
            }, function(a, b) {
                c.fn[a] = function(d) {
                    var f = [];
                    d = c(d);
                    var e = this.length === 1 && this[0].parentNode;
                    if (e && e.nodeType === 11 && e.childNodes.length === 1 && d.length === 1) {
                        d[b](this[0]);
                        return this
                    } else {
                        e = 0;
                        for (var j = d.length; e < j; e++) {
                            var i = (e > 0 ? this.clone(true) : this).get();
                            c.fn[b].apply(c(d[e]), i);
                            f = f.concat(i)
                        }
                        return this.pushStack(f, a, d.selector)
                    }
                }
            }
        );
        c.extend({
            clean: function(a, b, d, f) {
                b = b || s;
                if (typeof b.createElement === "undefined")
                    b = b.ownerDocument || b[0] && b[0].ownerDocument || s;
                for (var e = [], j = 0, i; (i = a[j]) != null ; j++) {
                    if (typeof i === "number")
                        i += "";
                    if (i) {
                        if (typeof i === "string" && !jb.test(i))
                            i = b.createTextNode(i);
                        else if (typeof i === "string") {
                            i = i.replace(Ka, Ma);
                            var o = (La.exec(i) || ["",
                                ""])[1].toLowerCase()
                                , k = F[o] || F._default
                                , n = k[0]
                                , r = b.createElement("div");
                            for (r.innerHTML = k[1] + i + k[2]; n--; )
                                r = r.lastChild;
                            if (!c.support.tbody) {
                                n = ib.test(i);
                                o = o === "table" && !n ? r.firstChild && r.firstChild.childNodes : k[1] === "<table>" && !n ? r.childNodes : [];
                                for (k = o.length - 1; k >= 0; --k)
                                    c.nodeName(o[k], "tbody") && !o[k].childNodes.length && o[k].parentNode.removeChild(o[k])
                            }
                            !c.support.leadingWhitespace && V.test(i) && r.insertBefore(b.createTextNode(V.exec(i)[0]), r.firstChild);
                            i = r.childNodes
                        }
                        if (i.nodeType)
                            e.push(i);
                        else
                            e =
                                c.merge(e, i)
                    }
                }
                if (d)
                    for (j = 0; e[j]; j++)
                        if (f && c.nodeName(e[j], "script") && (!e[j].type || e[j].type.toLowerCase() === "text/javascript"))
                            f.push(e[j].parentNode ? e[j].parentNode.removeChild(e[j]) : e[j]);
                        else {
                            e[j].nodeType === 1 && e.splice.apply(e, [j + 1, 0].concat(c.makeArray(e[j].getElementsByTagName("script"))));
                            d.appendChild(e[j])
                        }
                return e
            },
            cleanData: function(a) {
                for (var b, d, f = c.cache, e = c.event.special, j = c.support.deleteExpando, i = 0, o; (o = a[i]) != null ; i++)
                    if (d = o[c.expando]) {
                        b = f[d];
                        if (b.events)
                            for (var k in b.events)
                                e[k] ?
                                    c.event.remove(o, k) : Ca(o, k, b.handle);
                        if (j)
                            delete o[c.expando];
                        else
                            o.removeAttribute && o.removeAttribute(c.expando);
                        delete f[d]
                    }
            }
        });
        var kb = /z-?index|font-?weight|opacity|zoom|line-?height/i
            , Na = /alpha\([^)]*\)/
            , Oa = /opacity=([^)]*)/
            , ha = /float/i
            , ia = /-([a-z])/ig
            , lb = /([A-Z])/g
            , mb = /^-?\d+(?:px)?$/i
            , nb = /^-?\d/
            , ob = {
                position: "absolute",
                visibility: "hidden",
                display: "block"
            }
            , pb = ["Left", "Right"]
            , qb = ["Top", "Bottom"]
            , rb = s.defaultView && s.defaultView.getComputedStyle
            , Pa = c.support.cssFloat ? "cssFloat" : "styleFloat"
            , ja =
                function(a, b) {
                    return b.toUpperCase()
                }
            ;
        c.fn.css = function(a, b) {
            return X(this, a, b, true, function(d, f, e) {
                    if (e === w)
                        return c.curCSS(d, f);
                    if (typeof e === "number" && !kb.test(f))
                        e += "px";
                    c.style(d, f, e)
                }
            )
        }
        ;
        c.extend({
            style: function(a, b, d) {
                if (!a || a.nodeType === 3 || a.nodeType === 8)
                    return w;
                if ((b === "width" || b === "height") && parseFloat(d) < 0)
                    d = w;
                var f = a.style || a
                    , e = d !== w;
                if (!c.support.opacity && b === "opacity") {
                    if (e) {
                        f.zoom = 1;
                        b = parseInt(d, 10) + "" === "NaN" ? "" : "alpha(opacity=" + d * 100 + ")";
                        a = f.filter || c.curCSS(a, "filter") || "";
                        f.filter =
                            Na.test(a) ? a.replace(Na, b) : b
                    }
                    return f.filter && f.filter.indexOf("opacity=") >= 0 ? parseFloat(Oa.exec(f.filter)[1]) / 100 + "" : ""
                }
                if (ha.test(b))
                    b = Pa;
                b = b.replace(ia, ja);
                if (e)
                    f[b] = d;
                return f[b]
            },
            css: function(a, b, d, f) {
                if (b === "width" || b === "height") {
                    var e, j = b === "width" ? pb : qb;
                    function i() {
                        e = b === "width" ? a.offsetWidth : a.offsetHeight;
                        f !== "border" && c.each(j, function() {
                                f || (e -= parseFloat(c.curCSS(a, "padding" + this, true)) || 0);
                                if (f === "margin")
                                    e += parseFloat(c.curCSS(a, "margin" + this, true)) || 0;
                                else
                                    e -= parseFloat(c.curCSS(a,
                                            "border" + this + "Width", true)) || 0
                            }
                        )
                    }
                    a.offsetWidth !== 0 ? i() : c.swap(a, ob, i);
                    return Math.max(0, Math.round(e))
                }
                return c.curCSS(a, b, d)
            },
            curCSS: function(a, b, d) {
                var f, e = a.style;
                if (!c.support.opacity && b === "opacity" && a.currentStyle) {
                    f = Oa.test(a.currentStyle.filter || "") ? parseFloat(RegExp.$1) / 100 + "" : "";
                    return f === "" ? "1" : f
                }
                if (ha.test(b))
                    b = Pa;
                if (!d && e && e[b])
                    f = e[b];
                else if (rb) {
                    if (ha.test(b))
                        b = "float";
                    b = b.replace(lb, "-$1").toLowerCase();
                    e = a.ownerDocument.defaultView;
                    if (!e)
                        return null ;
                    if (a = e.getComputedStyle(a, null ))
                        f =
                            a.getPropertyValue(b);
                    if (b === "opacity" && f === "")
                        f = "1"
                } else if (a.currentStyle) {
                    d = b.replace(ia, ja);
                    f = a.currentStyle[b] || a.currentStyle[d];
                    if (!mb.test(f) && nb.test(f)) {
                        b = e.left;
                        var j = a.runtimeStyle.left;
                        a.runtimeStyle.left = a.currentStyle.left;
                        e.left = d === "fontSize" ? "1em" : f || 0;
                        f = e.pixelLeft + "px";
                        e.left = b;
                        a.runtimeStyle.left = j
                    }
                }
                return f
            },
            swap: function(a, b, d) {
                var f = {};
                for (var e in b) {
                    f[e] = a.style[e];
                    a.style[e] = b[e]
                }
                d.call(a);
                for (e in b)
                    a.style[e] = f[e]
            }
        });
        if (c.expr && c.expr.filters) {
            c.expr.filters.hidden = function(a) {
                var b =
                    a.offsetWidth
                    , d = a.offsetHeight
                    , f = a.nodeName.toLowerCase() === "tr";
                return b === 0 && d === 0 && !f ? true : b > 0 && d > 0 && !f ? false : c.curCSS(a, "display") === "none"
            }
            ;
            c.expr.filters.visible = function(a) {
                return !c.expr.filters.hidden(a)
            }
        }
        var sb = J()
            , tb = /<script(.|\s)*?\/script>/gi
            , ub = /select|textarea/i
            , vb = /color|date|datetime|email|hidden|month|number|password|range|search|tel|text|time|url|week/i
            , N = /=\?(&|$)/
            , ka = /\?/
            , wb = /(\?|&)_=.*?(&|$)/
            , xb = /^(\w+:)?\/\/([^\/?#]+)/
            , yb = /%20/g
            , zb = c.fn.load;
        c.fn.extend({
            load: function(a, b, d) {
                if (typeof a !==
                    "string")
                    return zb.call(this, a);
                else if (!this.length)
                    return this;
                var f = a.indexOf(" ");
                if (f >= 0) {
                    var e = a.slice(f, a.length);
                    a = a.slice(0, f)
                }
                f = "GET";
                if (b)
                    if (c.isFunction(b)) {
                        d = b;
                        b = null
                    } else if (typeof b === "object") {
                        b = c.param(b, c.ajaxSettings.traditional);
                        f = "POST"
                    }
                var j = this;
                c.ajax({
                    url: a,
                    type: f,
                    dataType: "html",
                    data: b,
                    complete: function(i, o) {
                        if (o === "success" || o === "notmodified")
                            j.html(e ? c("<div />").append(i.responseText.replace(tb, "")).find(e) : i.responseText);
                        d && j.each(d, [i.responseText, o, i])
                    }
                });
                return this
            },
            serialize: function() {
                return c.param(this.serializeArray())
            },
            serializeArray: function() {
                return this.map(function() {
                        return this.elements ? c.makeArray(this.elements) : this
                    }
                ).filter(function() {
                        return this.name && !this.disabled && (this.checked || ub.test(this.nodeName) || vb.test(this.type))
                    }
                ).map(function(a, b) {
                        a = c(this).val();
                        return a == null  ? null  : c.isArray(a) ? c.map(a, function(d) {
                                        return {
                                            name: b.name,
                                            value: d
                                        }
                                    }
                                ) : {
                                    name: b.name,
                                    value: a
                                }
                    }
                ).get()
            }
        });
        c.each("ajaxStart ajaxStop ajaxComplete ajaxError ajaxSuccess ajaxSend".split(" "),
            function(a, b) {
                c.fn[b] = function(d) {
                    return this.bind(b, d)
                }
            }
        );
        c.extend({
            get: function(a, b, d, f) {
                if (c.isFunction(b)) {
                    f = f || d;
                    d = b;
                    b = null
                }
                return c.ajax({
                    type: "GET",
                    url: a,
                    data: b,
                    success: d,
                    dataType: f
                })
            },
            getScript: function(a, b) {
                return c.get(a, null , b, "script")
            },
            getJSON: function(a, b, d) {
                return c.get(a, b, d, "json")
            },
            post: function(a, b, d, f) {
                if (c.isFunction(b)) {
                    f = f || d;
                    d = b;
                    b = {}
                }
                return c.ajax({
                    type: "POST",
                    url: a,
                    data: b,
                    success: d,
                    dataType: f
                })
            },
            ajaxSetup: function(a) {
                c.extend(c.ajaxSettings, a)
            },
            ajaxSettings: {
                url: location.href,
                global: true,
                type: "GET",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                async: true,
                xhr: A.XMLHttpRequest && (A.location.protocol !== "file:" || !A.ActiveXObject) ? function() {
                        return new A.XMLHttpRequest
                    }
                    : function() {
                        try {
                            return new A.ActiveXObject("Microsoft.XMLHTTP")
                        } catch (a) {}
                    }
                ,
                accepts: {
                    xml: "application/xml, text/xml",
                    html: "text/html",
                    script: "text/javascript, application/javascript",
                    json: "application/json, text/javascript",
                    text: "text/plain",
                    _default: "*/*"
                }
            },
            lastModified: {},
            etag: {},
            ajax: function(a) {
                function b() {
                    e.success &&
                    e.success.call(k, o, i, x);
                    e.global && f("ajaxSuccess", [x, e])
                }
                function d() {
                    e.complete && e.complete.call(k, x, i);
                    e.global && f("ajaxComplete", [x, e]);
                    e.global && !--c.active && c.event.trigger("ajaxStop")
                }
                function f(q, p) {
                    (e.context ? c(e.context) : c.event).trigger(q, p)
                }
                var e = c.extend(true, {}, c.ajaxSettings, a), j, i, o, k = a && a.context || e, n = e.type.toUpperCase();
                if (e.data && e.processData && typeof e.data !== "string")
                    e.data = c.param(e.data, e.traditional);
                if (e.dataType === "jsonp") {
                    if (n === "GET")
                        N.test(e.url) || (e.url += (ka.test(e.url) ?
                                "&" : "?") + (e.jsonp || "callback") + "=?");
                    else if (!e.data || !N.test(e.data))
                        e.data = (e.data ? e.data + "&" : "") + (e.jsonp || "callback") + "=?";
                    e.dataType = "json"
                }
                if (e.dataType === "json" && (e.data && N.test(e.data) || N.test(e.url))) {
                    j = e.jsonpCallback || "jsonp" + sb++;
                    if (e.data)
                        e.data = (e.data + "").replace(N, "=" + j + "$1");
                    e.url = e.url.replace(N, "=" + j + "$1");
                    e.dataType = "script";
                    A[j] = A[j] || function(q) {
                            o = q;
                            b();
                            d();
                            A[j] = w;
                            try {
                                delete A[j]
                            } catch (p) {}
                            z && z.removeChild(C)
                        }
                }
                if (e.dataType === "script" && e.cache === null )
                    e.cache = false;
                if (e.cache ===
                    false && n === "GET") {
                    var r = J()
                        , u = e.url.replace(wb, "$1_=" + r + "$2");
                    e.url = u + (u === e.url ? (ka.test(e.url) ? "&" : "?") + "_=" + r : "")
                }
                if (e.data && n === "GET")
                    e.url += (ka.test(e.url) ? "&" : "?") + e.data;
                e.global && !c.active++ && c.event.trigger("ajaxStart");
                r = (r = xb.exec(e.url)) && (r[1] && r[1] !== location.protocol || r[2] !== location.host);
                if (e.dataType === "script" && n === "GET" && r) {
                    var z = s.getElementsByTagName("head")[0] || s.documentElement
                        , C = s.createElement("script");
                    C.src = e.url;
                    if (e.scriptCharset)
                        C.charset = e.scriptCharset;
                    if (!j) {
                        var B =
                            false;
                        C.onload = C.onreadystatechange = function() {
                            if (!B && (!this.readyState || this.readyState === "loaded" || this.readyState === "complete")) {
                                B = true;
                                b();
                                d();
                                C.onload = C.onreadystatechange = null ;
                                z && C.parentNode && z.removeChild(C)
                            }
                        }
                    }
                    z.insertBefore(C, z.firstChild);
                    return w
                }
                var E = false
                    , x = e.xhr();
                if (x) {
                    e.username ? x.open(n, e.url, e.async, e.username, e.password) : x.open(n, e.url, e.async);
                    try {
                        if (e.data || a && a.contentType)
                            x.setRequestHeader("Content-Type", e.contentType);
                        if (e.ifModified) {
                            c.lastModified[e.url] && x.setRequestHeader("If-Modified-Since",
                                c.lastModified[e.url]);
                            c.etag[e.url] && x.setRequestHeader("If-None-Match", c.etag[e.url])
                        }
                        r || x.setRequestHeader("X-Requested-With", "XMLHttpRequest");
                        x.setRequestHeader("Accept", e.dataType && e.accepts[e.dataType] ? e.accepts[e.dataType] + ", */*" : e.accepts._default)
                    } catch (ga) {}
                    if (e.beforeSend && e.beforeSend.call(k, x, e) === false) {
                        e.global && !--c.active && c.event.trigger("ajaxStop");
                        x.abort();
                        return false
                    }
                    e.global && f("ajaxSend", [x, e]);
                    var g = x.onreadystatechange = function(q) {
                            if (!x || x.readyState === 0 || q === "abort") {
                                E ||
                                d();
                                E = true;
                                if (x)
                                    x.onreadystatechange = c.noop
                            } else if (!E && x && (x.readyState === 4 || q === "timeout")) {
                                E = true;
                                x.onreadystatechange = c.noop;
                                i = q === "timeout" ? "timeout" : !c.httpSuccess(x) ? "error" : e.ifModified && c.httpNotModified(x, e.url) ? "notmodified" : "success";
                                var p;
                                if (i === "success")
                                    try {
                                        o = c.httpData(x, e.dataType, e)
                                    } catch (v) {
                                        i = "parsererror";
                                        p = v
                                    }
                                if (i === "success" || i === "notmodified")
                                    j || b();
                                else
                                    c.handleError(e, x, i, p);
                                d();
                                q === "timeout" && x.abort();
                                if (e.async)
                                    x = null
                            }
                        }
                        ;
                    try {
                        var h = x.abort;
                        x.abort = function() {
                            x && h.call(x);
                            g("abort")
                        }
                    } catch (l) {}
                    e.async && e.timeout > 0 && setTimeout(function() {
                            x && !E && g("timeout")
                        }
                        , e.timeout);
                    try {
                        x.send(n === "POST" || n === "PUT" || n === "DELETE" ? e.data : null )
                    } catch (m) {
                        c.handleError(e, x, null , m);
                        d()
                    }
                    e.async || g();
                    return x
                }
            },
            handleError: function(a, b, d, f) {
                if (a.error)
                    a.error.call(a.context || a, b, d, f);
                if (a.global)
                    (a.context ? c(a.context) : c.event).trigger("ajaxError", [b, a, f])
            },
            active: 0,
            httpSuccess: function(a) {
                try {
                    return !a.status && location.protocol === "file:" || a.status >= 200 && a.status < 300 || a.status === 304 || a.status ===
                        1223 || a.status === 0
                } catch (b) {}
                return false
            },
            httpNotModified: function(a, b) {
                var d = a.getResponseHeader("Last-Modified")
                    , f = a.getResponseHeader("Etag");
                if (d)
                    c.lastModified[b] = d;
                if (f)
                    c.etag[b] = f;
                return a.status === 304 || a.status === 0
            },
            httpData: function(a, b, d) {
                var f = a.getResponseHeader("content-type") || ""
                    , e = b === "xml" || !b && f.indexOf("xml") >= 0;
                a = e ? a.responseXML : a.responseText;
                e && a.documentElement.nodeName === "parsererror" && c.error("parsererror");
                if (d && d.dataFilter)
                    a = d.dataFilter(a, b);
                if (typeof a === "string")
                    if (b ===
                        "json" || !b && f.indexOf("json") >= 0)
                        a = c.parseJSON(a);
                    else if (b === "script" || !b && f.indexOf("javascript") >= 0)
                        c.globalEval(a);
                return a
            },
            param: function(a, b) {
                function d(i, o) {
                    if (c.isArray(o))
                        c.each(o, function(k, n) {
                                b || /\[\]$/.test(i) ? f(i, n) : d(i + "[" + (typeof n === "object" || c.isArray(n) ? k : "") + "]", n)
                            }
                        );
                    else
                        !b && o != null  && typeof o === "object" ? c.each(o, function(k, n) {
                                    d(i + "[" + k + "]", n)
                                }
                            ) : f(i, o)
                }
                function f(i, o) {
                    o = c.isFunction(o) ? o() : o;
                    e[e.length] = encodeURIComponent(i) + "=" + encodeURIComponent(o)
                }
                var e = [];
                if (b === w)
                    b = c.ajaxSettings.traditional;
                if (c.isArray(a) || a.jquery)
                    c.each(a, function() {
                            f(this.name, this.value)
                        }
                    );
                else
                    for (var j in a)
                        d(j, a[j]);
                return e.join("&").replace(yb, "+")
            }
        });
        var la = {}, Ab = /toggle|show|hide/, Bb = /^([+-]=)?([\d+-.]+)(.*)$/, W, va = [["height", "marginTop", "marginBottom", "paddingTop", "paddingBottom"], ["width", "marginLeft", "marginRight", "paddingLeft", "paddingRight"], ["opacity"]];
        c.fn.extend({
            show: function(a, b) {
                if (a || a === 0)
                    return this.animate(K("show", 3), a, b);
                else {
                    a = 0;
                    for (b = this.length; a < b; a++) {
                        var d = c.data(this[a], "olddisplay");
                        this[a].style.display = d || "";
                        if (c.css(this[a], "display") === "none") {
                            d = this[a].nodeName;
                            var f;
                            if (la[d])
                                f = la[d];
                            else {
                                var e = c("<" + d + " />").appendTo("body");
                                f = e.css("display");
                                if (f === "none")
                                    f = "block";
                                e.remove();
                                la[d] = f
                            }
                            c.data(this[a], "olddisplay", f)
                        }
                    }
                    a = 0;
                    for (b = this.length; a < b; a++)
                        this[a].style.display = c.data(this[a], "olddisplay") || "";
                    return this
                }
            },
            hide: function(a, b) {
                if (a || a === 0)
                    return this.animate(K("hide", 3), a, b);
                else {
                    a = 0;
                    for (b = this.length; a < b; a++) {
                        var d = c.data(this[a], "olddisplay");
                        !d && d !== "none" && c.data(this[a],
                            "olddisplay", c.css(this[a], "display"))
                    }
                    a = 0;
                    for (b = this.length; a < b; a++)
                        this[a].style.display = "none";
                    return this
                }
            },
            _toggle: c.fn.toggle,
            toggle: function(a, b) {
                var d = typeof a === "boolean";
                if (c.isFunction(a) && c.isFunction(b))
                    this._toggle.apply(this, arguments);
                else
                    a == null  || d ? this.each(function() {
                                var f = d ? a : c(this).is(":hidden");
                                c(this)[f ? "show" : "hide"]()
                            }
                        ) : this.animate(K("toggle", 3), a, b);
                return this
            },
            fadeTo: function(a, b, d) {
                return this.filter(":hidden").css("opacity", 0).show().end().animate({
                    opacity: b
                }, a, d)
            },
            animate: function(a, b, d, f) {
                var e = c.speed(b, d, f);
                if (c.isEmptyObject(a))
                    return this.each(e.complete);
                return this[e.queue === false ? "each" : "queue"](function() {
                        var j = c.extend({}, e), i, o = this.nodeType === 1 && c(this).is(":hidden"), k = this;
                        for (i in a) {
                            var n = i.replace(ia, ja);
                            if (i !== n) {
                                a[n] = a[i];
                                delete a[i];
                                i = n
                            }
                            if (a[i] === "hide" && o || a[i] === "show" && !o)
                                return j.complete.call(this);
                            if ((i === "height" || i === "width") && this.style) {
                                j.display = c.css(this, "display");
                                j.overflow = this.style.overflow
                            }
                            if (c.isArray(a[i])) {
                                (j.specialEasing =
                                    j.specialEasing || {})[i] = a[i][1];
                                a[i] = a[i][0]
                            }
                        }
                        if (j.overflow != null )
                            this.style.overflow = "hidden";
                        j.curAnim = c.extend({}, a);
                        c.each(a, function(r, u) {
                                var z = new c.fx(k,j,r);
                                if (Ab.test(u))
                                    z[u === "toggle" ? o ? "show" : "hide" : u](a);
                                else {
                                    var C = Bb.exec(u)
                                        , B = z.cur(true) || 0;
                                    if (C) {
                                        u = parseFloat(C[2]);
                                        var E = C[3] || "px";
                                        if (E !== "px") {
                                            k.style[r] = (u || 1) + E;
                                            B = (u || 1) / z.cur(true) * B;
                                            k.style[r] = B + E
                                        }
                                        if (C[1])
                                            u = (C[1] === "-=" ? -1 : 1) * u + B;
                                        z.custom(B, u, E)
                                    } else
                                        z.custom(B, u, "")
                                }
                            }
                        );
                        return true
                    }
                )
            },
            stop: function(a, b) {
                var d = c.timers;
                a && this.queue([]);
                this.each(function() {
                        for (var f = d.length - 1; f >= 0; f--)
                            if (d[f].elem === this) {
                                b && d[f](true);
                                d.splice(f, 1)
                            }
                    }
                );
                b || this.dequeue();
                return this
            }
        });
        c.each({
                slideDown: K("show", 1),
                slideUp: K("hide", 1),
                slideToggle: K("toggle", 1),
                fadeIn: {
                    opacity: "show"
                },
                fadeOut: {
                    opacity: "hide"
                }
            }, function(a, b) {
                c.fn[a] = function(d, f) {
                    return this.animate(b, d, f)
                }
            }
        );
        c.extend({
            speed: function(a, b, d) {
                var f = a && typeof a === "object" ? a : {
                        complete: d || !d && b || c.isFunction(a) && a,
                        duration: a,
                        easing: d && b || b && !c.isFunction(b) && b
                    };
                f.duration = c.fx.off ? 0 : typeof f.duration ===
                    "number" ? f.duration : c.fx.speeds[f.duration] || c.fx.speeds._default;
                f.old = f.complete;
                f.complete = function() {
                    f.queue !== false && c(this).dequeue();
                    c.isFunction(f.old) && f.old.call(this)
                }
                ;
                return f
            },
            easing: {
                linear: function(a, b, d, f) {
                    return d + f * a
                },
                swing: function(a, b, d, f) {
                    return (-Math.cos(a * Math.PI) / 2 + 0.5) * f + d
                }
            },
            timers: [],
            fx: function(a, b, d) {
                this.options = b;
                this.elem = a;
                this.prop = d;
                if (!b.orig)
                    b.orig = {}
            }
        });
        c.fx.prototype = {
            update: function() {
                this.options.step && this.options.step.call(this.elem, this.now, this);
                (c.fx.step[this.prop] ||
                c.fx.step._default)(this);
                if ((this.prop === "height" || this.prop === "width") && this.elem.style)
                    this.elem.style.display = "block"
            },
            cur: function(a) {
                if (this.elem[this.prop] != null  && (!this.elem.style || this.elem.style[this.prop] == null ))
                    return this.elem[this.prop];
                return (a = parseFloat(c.css(this.elem, this.prop, a))) && a > -10000 ? a : parseFloat(c.curCSS(this.elem, this.prop)) || 0
            },
            custom: function(a, b, d) {
                function f(j) {
                    return e.step(j)
                }
                this.startTime = J();
                this.start = a;
                this.end = b;
                this.unit = d || this.unit || "px";
                this.now = this.start;
                this.pos = this.state = 0;
                var e = this;
                f.elem = this.elem;
                if (f() && c.timers.push(f) && !W)
                    W = setInterval(c.fx.tick, 13)
            },
            show: function() {
                this.options.orig[this.prop] = c.style(this.elem, this.prop);
                this.options.show = true;
                this.custom(this.prop === "width" || this.prop === "height" ? 1 : 0, this.cur());
                c(this.elem).show()
            },
            hide: function() {
                this.options.orig[this.prop] = c.style(this.elem, this.prop);
                this.options.hide = true;
                this.custom(this.cur(), 0)
            },
            step: function(a) {
                var b = J()
                    , d = true;
                if (a || b >= this.options.duration + this.startTime) {
                    this.now =
                        this.end;
                    this.pos = this.state = 1;
                    this.update();
                    this.options.curAnim[this.prop] = true;
                    for (var f in this.options.curAnim)
                        if (this.options.curAnim[f] !== true)
                            d = false;
                    if (d) {
                        if (this.options.display != null ) {
                            this.elem.style.overflow = this.options.overflow;
                            a = c.data(this.elem, "olddisplay");
                            this.elem.style.display = a ? a : this.options.display;
                            if (c.css(this.elem, "display") === "none")
                                this.elem.style.display = "block"
                        }
                        this.options.hide && c(this.elem).hide();
                        if (this.options.hide || this.options.show)
                            for (var e in this.options.curAnim)
                                c.style(this.elem,
                                    e, this.options.orig[e]);
                        this.options.complete.call(this.elem)
                    }
                    return false
                } else {
                    e = b - this.startTime;
                    this.state = e / this.options.duration;
                    a = this.options.easing || (c.easing.swing ? "swing" : "linear");
                    this.pos = c.easing[this.options.specialEasing && this.options.specialEasing[this.prop] || a](this.state, e, 0, 1, this.options.duration);
                    this.now = this.start + (this.end - this.start) * this.pos;
                    this.update()
                }
                return true
            }
        };
        c.extend(c.fx, {
            tick: function() {
                for (var a = c.timers, b = 0; b < a.length; b++)
                    a[b]() || a.splice(b--, 1);
                a.length ||
                c.fx.stop()
            },
            stop: function() {
                clearInterval(W);
                W = null
            },
            speeds: {
                slow: 600,
                fast: 200,
                _default: 400
            },
            step: {
                opacity: function(a) {
                    c.style(a.elem, "opacity", a.now)
                },
                _default: function(a) {
                    if (a.elem.style && a.elem.style[a.prop] != null )
                        a.elem.style[a.prop] = (a.prop === "width" || a.prop === "height" ? Math.max(0, a.now) : a.now) + a.unit;
                    else
                        a.elem[a.prop] = a.now
                }
            }
        });
        if (c.expr && c.expr.filters)
            c.expr.filters.animated = function(a) {
                return c.grep(c.timers, function(b) {
                        return a === b.elem
                    }
                ).length
            }
            ;
        c.fn.offset = "getBoundingClientRect" in s.documentElement ?
            function(a) {
                var b = this[0];
                if (a)
                    return this.each(function(e) {
                            c.offset.setOffset(this, a, e)
                        }
                    );
                if (!b || !b.ownerDocument)
                    return null ;
                if (b === b.ownerDocument.body)
                    return c.offset.bodyOffset(b);
                var d = b.getBoundingClientRect()
                    , f = b.ownerDocument;
                b = f.body;
                f = f.documentElement;
                return {
                    top: d.top + (self.pageYOffset || c.support.boxModel && f.scrollTop || b.scrollTop) - (f.clientTop || b.clientTop || 0),
                    left: d.left + (self.pageXOffset || c.support.boxModel && f.scrollLeft || b.scrollLeft) - (f.clientLeft || b.clientLeft || 0)
                }
            }
            : function(a) {
                var b =
                    this[0];
                if (a)
                    return this.each(function(r) {
                            c.offset.setOffset(this, a, r)
                        }
                    );
                if (!b || !b.ownerDocument)
                    return null ;
                if (b === b.ownerDocument.body)
                    return c.offset.bodyOffset(b);
                c.offset.initialize();
                var d = b.offsetParent, f = b, e = b.ownerDocument, j, i = e.documentElement, o = e.body;
                f = (e = e.defaultView) ? e.getComputedStyle(b, null ) : b.currentStyle;
                for (var k = b.offsetTop, n = b.offsetLeft; (b = b.parentNode) && b !== o && b !== i; ) {
                    if (c.offset.supportsFixedPosition && f.position === "fixed")
                        break;
                    j = e ? e.getComputedStyle(b, null ) : b.currentStyle;
                    k -= b.scrollTop;
                    n -= b.scrollLeft;
                    if (b === d) {
                        k += b.offsetTop;
                        n += b.offsetLeft;
                        if (c.offset.doesNotAddBorder && !(c.offset.doesAddBorderForTableAndCells && /^t(able|d|h)$/i.test(b.nodeName))) {
                            k += parseFloat(j.borderTopWidth) || 0;
                            n += parseFloat(j.borderLeftWidth) || 0
                        }
                        f = d;
                        d = b.offsetParent
                    }
                    if (c.offset.subtractsBorderForOverflowNotVisible && j.overflow !== "visible") {
                        k += parseFloat(j.borderTopWidth) || 0;
                        n += parseFloat(j.borderLeftWidth) || 0
                    }
                    f = j
                }
                if (f.position === "relative" || f.position === "static") {
                    k += o.offsetTop;
                    n += o.offsetLeft
                }
                if (c.offset.supportsFixedPosition &&
                    f.position === "fixed") {
                    k += Math.max(i.scrollTop, o.scrollTop);
                    n += Math.max(i.scrollLeft, o.scrollLeft)
                }
                return {
                    top: k,
                    left: n
                }
            }
        ;
        c.offset = {
            initialize: function() {
                var a = s.body, b = s.createElement("div"), d, f, e, j = parseFloat(c.curCSS(a, "marginTop", true)) || 0;
                c.extend(b.style, {
                    position: "absolute",
                    top: 0,
                    left: 0,
                    margin: 0,
                    border: 0,
                    width: "1px",
                    height: "1px",
                    visibility: "hidden"
                });
                b.innerHTML = "<div style='position:absolute;top:0;left:0;margin:0;border:5px solid #000;padding:0;width:1px;height:1px;'><div></div></div><table style='position:absolute;top:0;left:0;margin:0;border:5px solid #000;padding:0;width:1px;height:1px;' cellpadding='0' cellspacing='0'><tr><td></td></tr></table>";
                a.insertBefore(b, a.firstChild);
                d = b.firstChild;
                f = d.firstChild;
                e = d.nextSibling.firstChild.firstChild;
                this.doesNotAddBorder = f.offsetTop !== 5;
                this.doesAddBorderForTableAndCells = e.offsetTop === 5;
                f.style.position = "fixed";
                f.style.top = "20px";
                this.supportsFixedPosition = f.offsetTop === 20 || f.offsetTop === 15;
                f.style.position = f.style.top = "";
                d.style.overflow = "hidden";
                d.style.position = "relative";
                this.subtractsBorderForOverflowNotVisible = f.offsetTop === -5;
                this.doesNotIncludeMarginInBodyOffset = a.offsetTop !== j;
                a.removeChild(b);
                c.offset.initialize = c.noop
            },
            bodyOffset: function(a) {
                var b = a.offsetTop
                    , d = a.offsetLeft;
                c.offset.initialize();
                if (c.offset.doesNotIncludeMarginInBodyOffset) {
                    b += parseFloat(c.curCSS(a, "marginTop", true)) || 0;
                    d += parseFloat(c.curCSS(a, "marginLeft", true)) || 0
                }
                return {
                    top: b,
                    left: d
                }
            },
            setOffset: function(a, b, d) {
                if (/static/.test(c.curCSS(a, "position")))
                    a.style.position = "relative";
                var f = c(a)
                    , e = f.offset()
                    , j = parseInt(c.curCSS(a, "top", true), 10) || 0
                    , i = parseInt(c.curCSS(a, "left", true), 10) || 0;
                if (c.isFunction(b))
                    b = b.call(a,
                        d, e);
                d = {
                    top: b.top - e.top + j,
                    left: b.left - e.left + i
                };
                "using" in b ? b.using.call(a, d) : f.css(d)
            }
        };
        c.fn.extend({
            position: function() {
                if (!this[0])
                    return null ;
                var a = this[0]
                    , b = this.offsetParent()
                    , d = this.offset()
                    , f = /^body|html$/i.test(b[0].nodeName) ? {
                        top: 0,
                        left: 0
                    } : b.offset();
                d.top -= parseFloat(c.curCSS(a, "marginTop", true)) || 0;
                d.left -= parseFloat(c.curCSS(a, "marginLeft", true)) || 0;
                f.top += parseFloat(c.curCSS(b[0], "borderTopWidth", true)) || 0;
                f.left += parseFloat(c.curCSS(b[0], "borderLeftWidth", true)) || 0;
                return {
                    top: d.top -
                    f.top,
                    left: d.left - f.left
                }
            },
            offsetParent: function() {
                return this.map(function() {
                        for (var a = this.offsetParent || s.body; a && !/^body|html$/i.test(a.nodeName) && c.css(a, "position") === "static"; )
                            a = a.offsetParent;
                        return a
                    }
                )
            }
        });
        c.each(["Left", "Top"], function(a, b) {
                var d = "scroll" + b;
                c.fn[d] = function(f) {
                    var e = this[0], j;
                    if (!e)
                        return null ;
                    if (f !== w)
                        return this.each(function() {
                                if (j = wa(this))
                                    j.scrollTo(!a ? f : c(j).scrollLeft(), a ? f : c(j).scrollTop());
                                else
                                    this[d] = f
                            }
                        );
                    else
                        return (j = wa(e)) ? "pageXOffset" in j ? j[a ? "pageYOffset" :
                                    "pageXOffset"] : c.support.boxModel && j.document.documentElement[d] || j.document.body[d] : e[d]
                }
            }
        );
        c.each(["Height", "Width"], function(a, b) {
                var d = b.toLowerCase();
                c.fn["inner" + b] = function() {
                    return this[0] ? c.css(this[0], d, false, "padding") : null
                }
                ;
                c.fn["outer" + b] = function(f) {
                    return this[0] ? c.css(this[0], d, false, f ? "margin" : "border") : null
                }
                ;
                c.fn[d] = function(f) {
                    var e = this[0];
                    if (!e)
                        return f == null  ? null  : this;
                    if (c.isFunction(f))
                        return this.each(function(j) {
                                var i = c(this);
                                i[d](f.call(this, j, i[d]()))
                            }
                        );
                    return "scrollTo" in
                    e && e.document ? e.document.compatMode === "CSS1Compat" && e.document.documentElement["client" + b] || e.document.body["client" + b] : e.nodeType === 9 ? Math.max(e.documentElement["client" + b], e.body["scroll" + b], e.documentElement["scroll" + b], e.body["offset" + b], e.documentElement["offset" + b]) : f === w ? c.css(e, d) : this.css(d, typeof f === "string" ? f : f + "px")
                }
            }
        );
        A.jQuery = A.$ = c
    }
)(window);
(function($) {
        $.comet = {};
        var cm = $.comet, iframe, fcon, retimes = 0, httpHander, timeHander, linkhander, isOff = 0, stop = 1, isSuccess = 0, connectCount = 0, isOk = 1, maxCount = 1, firstConnect = 1, bag = 0, linkOk = 0, splitChar = "ê", xhr, itype = window.ActiveXObject ? [1, 0] : [0, 0], ctype = [[0, 0], [1, 2, 1, 2]], maxbag = 99999;
        var type = ctype[itype[0]][itype[1]];
        var st = {
            doc: $(document),
            token: "",
            timestamp: 0,
            uid_flag: 1,
            uid_timestamp: 0,
            timeFirst: 180000,
            time: (Math.round(Math.random() * 1000) % 20 + 30) * 1000,
            maxRetimes: 36,
            asname: "",
            channel: "",
            domain: "",
            url: "",
            filter: null
        };
        var sendEvent = function(e, d) {
                try {
                    st.doc.triggerHandler(e, d)
                } catch (x) {
                    if (window.console) {
                        window.console.log(x)
                    }
                }
            }
            ;
        var nextType = function() {
                if (retimes > st.maxRetimes) {
                    firstConnect = 1;
                    retimes = 0
                }
                retimes++;
                type = ctype[itype[0]][itype[1]];
                if (undefined === type) {
                    if (firstConnect) {
                        type = -1;
                        sendEvent("cpsconnect", [-2])
                    } else {
                        itype[1] = 0;
                        type = ctype[itype[0]][itype[1]]
                    }
                }
                if (type >= 0) {
                    try {
                        httpHander.abort();
                        httpHander.onreadystatechange = function() {}
                    } catch (x) {}
                    iframe = null ;
                    httpHander = null ;
                    if (fcon) {
                        try {
                            $(fcon).empty().remove()
                        } catch (x) {}
                        fcon = null
                    }
                    bag = 0;
                    linkOk = 0;
                    cm.run()
                }
            }
            ;
        var getLink = function() {
                return st.url + "subscribe?token=" + st.token + "&as_name=" + st.asname + "&timestamp=" + st.timestamp + "&domain=" + st.domain + "&type=" + type + "&channel_list=" + st.channel + "&uid_flag=" + st.uid_flag + "&uid_timestamp=" + st.uid_timestamp + "&_=" + (new Date()).getTime()
            }
            ;
        var offLink = function(b) {
                if (st.domain) {
                    $.getJSON(st.url + "offline?token=" + st.token + "&jsoncallback=?", b)
                } else {
                    $.get(st.url + "offline?token=" + st.token + "&jsoncallback=comet" + (new Date()).getTime(), function(x) {
                            b(parseInt(x.substr(x.indexOf("(") + 1, 1), 10))
                        }
                    )
                }
            }
            ;
        $.extend($.comet, {
            run: function(d) {
                if (type < 0) {
                    isOff = 1;
                    sendEvent("cpsconnect", [-2]);
                    return
                }
                if ("object" == typeof (d)) {
                    $.extend(st, d);
                    connectCount = 0;
                    isOff = 1;
                    isOk = 1;
                    stop = 0;
                    sendEvent("cpsconnect", [-1]);
                    if (d.channel) {
                        linkOk = 0
                    }
                } else {
                    if (connectCount < maxCount && type >= 0) {
                        if (isSuccess) {
                            connectCount++
                        }
                    } else {
                        if (!isOff) {
                            isOff = 1;
                            sendEvent("cpsconnect", [-2])
                        }
                        if (!isSuccess) {
                            return
                        }
                    }
                }
                var tx = "cpsframe" + (new Date()).getTime();
                bag = 0;
                if (1 !== type) {
                    if (st.domain) {
                        if (!iframe) {
                            fcon = document.createElement("div");
                            fcon.style.display = "none";
                            document.body.appendChild(fcon);
                            fcon.innerHTML = '<iframe name="' + tx + '"></iframe>';
                            iframe = window.frames[tx];
                            iframe.location.replace(st.url + "run.html#" + st.domain)
                        } else {
                            if (httpHander) {
                                cm.iback()
                            } else {
                                iframe.location.replace(st.url + "run.html#" + st.domain)
                            }
                        }
                    } else {
                        cm.iback(window.ActiveXObject || XMLHttpRequest)
                    }
                    if (timeHander) {
                        clearTimeout(timeHander);
                        timeHander = null
                    }
                    timeHander = setTimeout(function() {
                            timeHander = null ;
                            cm.iback(XMLHttpRequest)
                        }
                        , 30000)
                } else {
                    if (!iframe) {
                        try {
                            httpHander = new ActiveXObject("htmlfile");
                            httpHander.open();
                            httpHander.write("<html><head>" + (st.domain ? '<script>try{document.domain="' + st.domain + '";}catch(e){}<\/script>' : "") + "</head><body></body></html>");
                            httpHander.close();
                            fcon = httpHander.createElement("div");
                            httpHander.appendChild(fcon);
                            httpHander.parentWindow.cm = $.comet
                        } catch (x) {
                            sendEvent("cpsconnect", [-2]);
                            httpHander = window;
                            fcon = document.createElement("div");
                            fcon.style.display = "none";
                            document.body.appendChild(fcon)
                        }
                        fcon.innerHTML = '<iframe name="' + tx + '"></iframe>';
                        iframe = httpHander.frames[tx];
                        iframe.location.replace(getLink())
                    } else {
                        iframe.location.replace(getLink())
                    }
                    cm.done(1)
                }
                stop = 1
            },
            setup: function(d) {
                if ("object" == typeof (d)) {
                    $.extend(st, d)
                }
            },
            callback: function(d, t) {
                if (st.filter) {
                    d = st.filter(d)
                }
                if (d.uid_flag == "0") {
                    st.uid_timestamp = t
                } else {
                    st.timestamp = t
                }
                sendEvent("cpsdata", [d, t]);
                cm.done(2)
            },
            done: function(t) {
                if (timeHander) {
                    clearTimeout(timeHander);
                    timeHander = null
                }
                if (linkhander) {
                    clearTimeout(linkhander);
                    linkhander = null
                }
                if (type < 2) {
                    if (bag > maxbag && !t) {
                        bag = 0;
                        connectCount = 0;
                        linkOk = 0;
                        cm.run()
                    } else {
                        if (1 === type) {
                            bag += 20
                        }
                    }
                }
                if (1 !== t && 2 !== t && isOff && stop == 1 && isOk) {
                    firstConnect = 0;
                    retimes = 0;
                    connectCount = 0;
                    isSuccess = 1;
                    isOk = 0;
                    sendEvent("cpsconnect", [type])
                }
                if (window.ActiveXObject) {
                    timeHander = setTimeout(function() {
                            clearTimeout(timeHander);
                            timeHander = null ;
                            isOk = 1;
                            nextType()
                        }
                        , firstConnect == 1 ? st.timeFirst : st.time)
                } else {
                    timeHander = setTimeout(function() {
                            clearTimeout(timeHander);
                            timeHander = null ;
                            isOk = 1;
                            nextType()
                        }
                        , st.time)
                }
                linkhander = setTimeout(function() {
                        clearTimeout(linkhander);
                        linkhander = null ;
                        isOk = 1;
                        sendEvent("cpsconnect", [-2])
                    }
                    , 30000)
            },
            off: function() {},
            iback: function(x) {
                if (!x && !xhr) {
                    nextType();
                    return
                }
                if (x) {
                    xhr = x
                }
                bag = 0;
                if (httpHander) {
                    try {
                        httpHander.abort();
                        httpHander.onreadystatechange = function() {}
                    } catch (ex) {}
                }
                httpHander = window.ActiveXObject ? new xhr("Microsoft.XMLHTTP") : new xhr();
                httpHander.onreadystatechange = function() {
                    if (!httpHander) {
                        return
                    }
                    if (window.ActiveXObject && 4 !== httpHander.readyState) {
                        return
                    }
                    if (3 === httpHander.readyState || 4 === httpHander.readyState) {
                        if (200 === httpHander.status) {
                            var t = httpHander.responseText.substr(bag);
                            bag += t.length;
                            var e = t.lastIndexOf(splitChar);
                            if (e > 0) {
                                t = t.substr(0, e).split(splitChar);
                                for (var i = 0, j = t.length; i < j; i++) {
                                    var s = t[i];
                                    if ("p" == s) {
                                        cm.done()
                                    } else {
                                        var d;
                                        try {
                                            d = window.eval("([" + s + "])")
                                        } catch (x) {
                                            continue
                                        }
                                        if ("object" == typeof (d) && 2 === d.length) {
                                            if (st.filter) {
                                                d[0] = st.filter(d[0])
                                            }
                                            if (d[0].uid_flag == "0") {
                                                st.uid_timestamp = d[1]
                                            } else {
                                                st.timestamp = d[1]
                                            }
                                            sendEvent("cpsdata", d);
                                            cm.done(2)
                                        }
                                    }
                                }
                            }
                        } else {
                            sendEvent("cpsconnect", [-2]);
                            if (timeHander) {
                                clearTimeout(timeHander);
                                timeHander = null
                            }
                            timeHander = setTimeout(function() {
                                    clearTimeout(timeHander);
                                    timeHander = null ;
                                    isOk = 1;
                                    nextType()
                                }
                                , firstConnect == 1 ? st.timeFirst : st.time)
                        }
                    }
                }
                ;
                httpHander.open("GET", getLink(), true);
                httpHander.send("")
            }
        });
        $(window).bind("beforeunload", function() {
                st.doc.unbind(".comet");
                if (!iframe) {
                    return
                }
                if (1 !== type && httpHander) {
                    try {
                        httpHander.abort();
                        httpHander.onreadystatechange = function() {}
                    } catch (x) {}
                }
                httpHander = null ;
                if (window.ActiveXObject) {
                    try {
                        CollectGarbage()
                    } catch (y) {}
                }
            }
        );
        st.doc.bind("cpsset.comet", function(e, d) {
                if ("object" == typeof (d)) {
                    $.extend(st, d)
                }
            }
        ).bind("keydown.comet", function(e) {
                if (27 === e.keyCode) {
                    e.preventDefault()
                }
            }
        );
        window.cm = $.comet
    }
)(jQuery);
var JqueryDialog = {
    cBorderSize: 2,
    cCloseText: "X 关闭",
    cCloseTitle: "关闭",
    cSubmitText: "确 认",
    cCancelText: "关 闭",
    Open: function(b, f, a, d, c) {
        if (undefined == c) {
            c = false
        }
        JqueryDialog.init(b, f, a, d, c, true, true, true)
    },
    Open1: function(c, i, a, h, f, g, b, d) {
        b = b ? b : false;
        d = d ? d : false;
        JqueryDialog.init(c, i, a, h, d, f, g, b)
    },
    init: function(j, p, r, h, k, n, c, l) {
        var g = document.body.clientWidth;
        var s = document.documentElement.scrollHeight;
        if (typeof ($("#jd_shadow")[0]) == "undefined") {
            $("body").prepend("<iframe id='jd_shadow'></iframe>");
            var i = $("#jd_shadow");
            i.css("width", g + "px");
            i.css("height", s + "px")
        }
        if (typeof ($("#jd_dialog")[0]) != "undefined") {
            $("#jd_dialog").remove()
        }
        $("body").prepend("<div id='jd_dialog'></div>");
        var b = $("#jd_dialog");
        var o = (g - (r + JqueryDialog.cBorderSize * 2 + 5)) / 2;
        b.css("left", (o < 0 ? 0 : o) + document.documentElement.scrollLeft + "px");
        var m = (document.documentElement.clientHeight - (h + JqueryDialog.cBorderSize * 2 + 30 + 40 + 5)) / 2;
        b.css("top", (m < 0 ? 0 : m) + document.documentElement.scrollTop + "px");
        b.append("<div id='jd_dialog_s'>&nbsp;</div>");
        var f = $("#jd_dialog_s");
        f.css("width", r + JqueryDialog.cBorderSize * 2 + "px");
        f.css("height", h + JqueryDialog.cBorderSize * 2 + 30 + 40 + "px");
        b.append("<div id='jd_dialog_m'></div>");
        var a = $("#jd_dialog_m");
        a.css("width", r + "px");
        a.append("<div id='jd_dialog_m_h'></div>");
        var q = $("#jd_dialog_m_h");
        q.append("<span id='jd_dialog_m_h_l'>" + j + "</span>");
        q.append("<span id='jd_dialog_m_h_r' title='" + JqueryDialog.cCloseTitle + "' onclick='JqueryDialog.Close(" + k + ");'>" + JqueryDialog.cCloseText + "</span>");
        a.append("<div id='jd_dialog_m_b'></div>");
        a.append("<div id='jd_dialog_m_b_1'>&nbsp;</div>");
        var t = $("#jd_dialog_m_b_1");
        t.css("top", "30px");
        t.css("width", r + "px");
        t.css("height", h + "px");
        t.css("display", "none");
        a.append("<div id='jd_dialog_m_b_2'></div>");
        $("#jd_dialog_m_b_2").append("<iframe id='jd_iframe' src='" + p + "' height='" + h + "' scrolling='auto' style='overflow:visible;' frameborder='0'/>");
        a.append("<div id='jd_dialog_m_t' class='module g-tn'></div>");
        var d = $("#jd_dialog_m_t");
        if (n) {
            d.append("<span><input id='jd_submit' class='btn2' value='" + JqueryDialog.cSubmitText + "' type='button' onclick='JqueryDialog.Ok();' /></span>")
        }
        if (c) {
            d.append("<span class='jd_dialog_m_t_s'><input id='jd_cancel' class='btn2' value='" + JqueryDialog.cCancelText + "' type='button' onclick='JqueryDialog.Close(" + k + ");' /></span>")
        }
        if (l) {
            DragAndDrop.Register(b[0], q[0])
        }
        if (n) {
            JqueryDialog.DisabledButton()
        }
    },
    Close: function(a) {
        var c = document.getElementById("jd_iframe");
        c.src = "about:blank";
        try {
            c.contentWindow.document.body.innerHTML = "";
            c.contentWindow.document.clear()
        } catch (b) {}
        c.parentNode.removeChild(c);
        $("#jd_shadow").remove();
        $("#jd_dialog").remove();
        if ("CollectGarbage" in window) {
            CollectGarbage()
        }
        if (a) {
            window.location.href = window.location.href
        }
    },
    Ok: function() {
        var b = $("#jd_submit").get(0);
        if (true == $(b).attr("disabled")) {
            return false
        }
        $(b).attr("disabled", "disabled");
        var a = $("#jd_iframe");
        if (undefined != a[0]) {
            if (typeof (a[0].contentWindow.$.Ok) == "function" && a[0].contentWindow.$.Ok()) {
                JqueryDialog.Close(false)
            } else {
                a[0].focus()
            }
        }
    },
    DisabledButton: function() {
        $("#jd_submit").attr("disabled", true)
    },
    ResetButton: function() {
        $("#jd_submit").attr("disabled", "")
    },
    SubmitCompleted: function(c, f, a, d, g) {
        if ($.trim(c).length > 0) {
            alert(c)
        }
        if (f) {
            if (a) {
                if (undefined != g) {
                    $.trigger(g)
                } else {
                    var b = window.location.href;
                    if (d) {
                        if (b.indexOf(d) == -1) {
                            b = b.indexOf("?") != -1 ? b + "&" + d : b + "?" + d
                        }
                        window.location.href = b
                    } else {
                        window.location.href = window.location.href
                    }
                }
            }
            JqueryDialog.Close(false)
        }
    }
};
var DragAndDrop = function() {
    var l;
    var h;
    var i;
    var f;
    var c = false;
    var j;
    var d;
    var b = function(n) {
            return n.ownerDocument || n.document
        }
        ;
    var g = function(n) {
            if (f) {
                n = n || window.event;
                l = document.body.clientWidth;
                h = document.documentElement.scrollHeight;
                $("#jd_dialog_m_b_1").css("display", "");
                c = true;
                j = {
                    x: $(f).offset().left,
                    y: $(f).offset().top
                };
                d = {
                    x: n.screenX,
                    y: n.screenY
                };
                $(document).bind("mousemove", k);
                $(document).bind("mouseup", m);
                if (n.preventDefault) {
                    n.preventDefault()
                } else {
                    n.returnValue = false
                }
            }
        }
        ;
    var k = function(n) {
            if (c) {
                n = n || window.event;
                var o = {
                    x: n.screenX,
                    y: n.screenY
                };
                j.x = j.x + (o.x - d.x);
                j.y = j.y + (o.y - d.y);
                d = o;
                $(f).css("left", j.x + "px");
                $(f).css("top", j.y + "px");
                if (n.preventDefault) {
                    n.preventDefault()
                } else {
                    n.returnValue = false
                }
            }
        }
        ;
    var m = function(n) {
            if (c) {
                n = n || window.event;
                $("#jd_dialog_m_b_1").css("display", "none");
                a();
                c = false
            }
        }
        ;
    var a = function() {
            if (i) {
                $(i.document).unbind("mousemove");
                $(i.document).unbind("mouseup")
            }
        }
        ;
    return {
        Register: function(n, o) {
            f = n;
            i = o;
            $(i).bind("mousedown", g)
        }
    }
}
();
$.extend({
    logjs: null ,
    log4js_cfg: {
        css_path: "http://" + document.domain + "/plugins/log4js.css",
        js_path: "http://" + document.domain + "/plugins/",
        ajax_path: "ajax_req.htm?act=savelog",
        ajax_timer: 600000,
        log4js_type: $.log4js_type,
        log4js_level: $.log4js_level
    },
    log_debug: function(a) {
        $.log4js(a, "debug")
    },
    log_info: function(a) {
        $.log4js(a, "info")
    },
    log_error: function(a) {
        $.log4js(a, "error")
    },
    log4js: function(b, c) {
        if (!$.log4js_cfg.log4js_type) {
            return
        }
        c = c ? c : "info";
        var a = self == top ? $.logjs : parent.$.logjs;
        if (a == null ) {
            return
        }
        switch (c) {
            case "trace":
                a.trace(b);
                break;
            case "debug":
                a.debug(b);
                break;
            case "info":
                a.info(b);
                break;
            case "warn":
                a.warn(b);
                break;
            case "error":
                a.error(b);
                break;
            case "fatal":
                a.fatal(b);
                break;
            default:
                a.info(b);
                break
        }
    },
    initLog4js: function() {
        $.log4js_cfg.log4js_type = $.log4js_type;
        $.log4js_cfg.log4js_level = $.log4js_level;
        timeHander = setTimeout(function() {
                timeHander = null ;
                $._initLog4js()
            }
            , 1000)
    },
    _initLog4js: function() {
        if (!$.log4js_cfg.log4js_type) {
            return
        }
        var a = null ;
        switch ($.log4js_cfg.log4js_type) {
            case 1:
                a = "log4javascript_uncompressed.js";
                break;
            case 2:
                a = "log4javascript_lite.js";
                break;
            case 3:
                a = "log4javascript.js";
                break;
            case 4:
                a = "log4javascript_ajax_min.js";
                break
        }
        var b = function() {
                cssfile = document.createElement("link");
                cssfile.setAttribute("rel", "stylesheet");
                cssfile.setAttribute("type", "text/css");
                cssfile.setAttribute("href", $.log4js_cfg.css_path)
            }
            ;
        if ($.log4js_cfg.log4js_type != 4) {
            b()
        }
        $.ajax({
            type: "GET",
            url: $.log4js_cfg.js_path + a,
            dataType: "script",
            success: function(f) {
                var c = null ;
                var g = log4javascript.Level[$.log4js_cfg.log4js_level.toUpperCase()];
                switch ($.log4js_cfg.log4js_type) {
                    case 1:
                        $.logjs = log4javascript.getLogger("main");
                        $.logjs.setLevel(g);
                        c = new log4javascript.InPageAppender();
                        $.logjs.addAppender(c);
                        break;
                    case 2:
                        $.logjs = log4javascript.getDefaultLogger();
                        $.logjs.setLevel(g);
                        break;
                    case 3:
                        $.logjs = log4javascript.getLogger("main");
                        $.logjs.setLevel(g);
                        c = new log4javascript.PopUpAppender();
                        var d = new log4javascript.PatternLayout("%d{HH:mm:ss-SSS} %-5p - %m%n");
                        c.setLayout(d);
                        $.logjs.addAppender(c);
                        break;
                    case 4:
                        $.logjs = log4javascript.getLogger();
                        $.logjs.setLevel(g);
                        c = new log4javascript.AjaxAppender($.log4js_cfg.ajax_path);
                        c.setWaitForResponse(true);
                        c.setBatchSize(500);
                        c.setLayout(new log4javascript.JsonLayout());
                        c.setTimed(true);
                        c.setTimerInterval($.log4js_cfg.ajax_timer);
                        $.logjs.addAppender(c);
                        break
                }
            }
        })
    }
});
var Cover = function(b, c, h) {
        b = b || "#FFF";
        c = c || 0.5;
        h = h || 99;
        var a = document.createElement("iframe");
        var i = document.createElement("div");
        var d = document.createElement("span");
        a.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)";
        a.style.mozOpacity = "0";
        a.style.opacity = "0";
        a.style.position = "absolute";
        a.style.top = "0";
        a.style.left = "0";
        a.style.zIndex = "" + h;
        a.style.display = "none";
        a.style.borderWidth = "0";
        i.style.backgroundColor = b;
        i.style.filter = "alpha(opacity=" + parseInt(c * 100, 10) + ")";
        i.style.mozOpacity = "" + c;
        i.style.opacity = "" + c;
        i.style.position = "absolute";
        i.style.top = "0";
        i.style.left = "0";
        i.style.zIndex = "" + (h + 1);
        i.style.display = "none";
        d.style.position = "absolute";
        d.style.top = "0";
        d.style.left = "0";
        d.style.display = "none";
        d.style.backgroundColor = "#D3EAFC";
        d.style.zIndex = "" + (h + 2);
        document.body.appendChild(a);
        document.body.appendChild(i);
        document.body.appendChild(d);
        this.frame = a;
        this.div = i;
        this.span = d;
        this.alarm_notice = "";
        this.alarm_expire = 0;
        this.hideTrigger = null ;
        this.alarmTimer = null ;
        this.spanTimer = null ;
        this.alarmLimit = null ;
        this.status = "close";
        this.isAlert = false;
        var g = this;
        var f = window.onresize;
        window.onresize = function() {
            if (f) {
                f()
            }
            Cover.setCoverSize(g)
        }
    }
    ;
Cover.prototype.removeStr = function() {
    if (this.spanTimer) {
        clearTimeout(this.spanTimer)
    }
    this.span.style.display = "none"
}
;
Cover.prototype.show = function(a) {
    var c = this;
    this.frame.style.display = "";
    this.div.style.display = "";
    Cover.setCoverSize(this);
    try {
        this.div.focus()
    } catch (b) {}
    if (this.span.innerHTML) {
        if (this.spanTimer) {
            clearTimeout(this.spanTimer)
        }
        this.spanTimer = setTimeout(function() {
                if ("none" !== c.frame.style.display) {
                    c.span.style.display = "";
                    Cover.setCoverSize(c)
                }
            }
            , 5000)
    }
    if (this.alarm_expire > 0) {
        if (this.alarmTimer) {
            clearTimeout(this.alarmTimer)
        }
        this.alarmTimer = setTimeout(function() {
                if ("none" !== c.frame.style.display) {
                    c.isAlert = true;
                    if (c.alarm_notice) {
                        if (a) {
                            a()
                        }
                        alert(c.alarm_notice)
                    }
                    c.isAlert = false;
                    c.hide()
                }
                if (c.hideTrigger) {
                    c.hideTrigger()
                }
            }
            , c.alarm_expire);
        this.setAlarmLimit()
    }
    c.status = "open"
}
;
Cover.prototype.hide = function() {
    this.frame.style.display = "none";
    this.div.style.display = "none";
    this.span.style.display = "none";
    if (this.alarmTimer) {
        clearTimeout(this.alarmTimer)
    }
    if (this.spanTimer) {
        clearTimeout(this.spanTimer)
    }
    if (this.alarmLimit) {
        clearInterval(this.alarmLimit)
    }
    this.spanTimer = null ;
    this.alarmTimer = null ;
    this.alarmLimit = null ;
    this.status = "close"
}
;
Cover.prototype.autoShow = function() {
    if ("none" === this.frame.style.display) {
        this.show()
    } else {
        this.hide()
    }
}
;
Cover.prototype.onBodyClick = function(a) {
    this.div.onclick = a
}
;
Cover.prototype.setAlarm = function(b, a) {
    this.alarm_expire = b;
    this.alarm_notice = a
}
;
Cover.prototype.setHideTrigger = function(a) {
    this.hideTrigger = a
}
;
Cover.prototype.clearTimer = function() {
    if (this.alarmTimer) {
        clearTimeout(this.alarmTimer)
    }
}
;
Cover.prototype.setAlarmLimit = function() {
    var d = this;
    var c = null ;
    for (var b in this.span.childNodes) {
        if (this.span.childNodes[b].className == "alarmLimit") {
            c = this.span.childNodes[b];
            break
        }
    }
    if (c) {
        c.innerHTML = "";
        if (this.alarmLimit) {
            clearInterval(this.alarmLimit)
        }
        var a = this.alarm_expire / 1000 - 2;
        this.alarmLimit = setInterval(function() {
                if (a > 8) {
                    a--
                } else {
                    if (a >= 0 && c) {
                        c.innerHTML = a--
                    } else {
                        clearInterval(d.alarmLimit)
                    }
                }
            }
            , 1000)
    }
}
;
Cover.prototype.setStr = function(a) {
    if (a) {
        this.span.style.border = "2px solid red";
        this.span.style.fontWeight = "bold";
        this.span.style.padding = "3px 5px";
        this.span.innerHTML = a
    } else {
        this.span.style.border = "0px";
        this.span.style.padding = "0px";
        this.span.innerHTML = ""
    }
}
;
Cover.setCoverSize = function(c) {
    var a = document.body.scrollWidth;
    var b = document.body.scrollHeight;
    c.frame.style.width = a + "px";
    c.frame.style.height = b + "px";
    c.div.style.width = a + "px";
    c.div.style.height = b + "px";
    c.span.style.top = (b - c.span.offsetHeight) / 2 + "px";
    c.span.style.left = (a - c.span.offsetWidth) / 2 + "px"
}
;
(function(b) {
        b.keyMerger = function(g, f) {
            var h = /{#([^#}]+)?#}/g
                , d = /(^( )?(if|for|else|switch|case|break|{|}))(.*)?/g
                , i = "var r=[];\n"
                , k = 0;
            var j = function(l, m) {
                    m ? (i += l.match(d) ? l + "\n" : "r.push(" + unescape('"' + l.split("|").join("\\u") + '"') + ");\n") : (i += l != "" ? 'r.push("' + l.replace(/"/g, '\\"') + '");\n' : "");
                    return j
                }
                ;
            while (match = h.exec(g)) {
                j(g.slice(k, match.index))(match[1], true);
                k = match.index + match[0].length
            }
            j(g.substr(k, g.length - k));
            i += 'return r.join("");';
            return new Function(i.replace(/[\r\t\n]/g, "")).apply(f)
        }
        ;
        String.prototype.keyComment = function() {
            return keyMerger(this)
        }
        ;
        function c(g) {
            if (g.nodeType == 1) {
                if (g.hasChildNodes()) {
                    var h = g.childNodes;
                    for (var f = 0; f < h.length; f++) {
                        var d = h.item(f);
                        c(d)
                    }
                }
            } else {
                if (g.nodeType == 3) {
                    g.nodeValue = g.nodeValue.keyComment()
                }
            }
        }
        function a() {
            b.onload = function() {
                var d = document.documentElement;
                c(d)
            }
        }
        b.keyMdf = keyMerger;
        b.staticFile = a
    }
)(window);
$.extend({
    stripTags: function(a) {
        return a.replace(/<\/?[^>]+>/gi, "")
    },
    assemble: function(t, p, j, q) {
        if (!j) {
            j = 0
        }
        if (!q) {
            q = []
        }
        var l = function() {
                var b = arguments[0];
                for (var a = 1; a < arguments.length; a++) {
                    b += " " + arguments[a]
                }
                return b
            }
            ;
        var o = t.length;
        var B = o - p + 1;
        var A, z, y, x, w, v, u, s;
        if (o < j + p - 1) {
            return q
        }
        for (var r = j; r <= B; r++) {
            if (r + p - 1 >= o) {
                q = $.assemble(t, p, j + 1, q);
                continue
            }
            var k = l(t[j], t[r + 1]);
            if (p === 2) {
                q.push(k)
            } else {
                if (p === 3) {
                    for (A = r; A < B; A++) {
                        q.push(l(k, t[A + 2]))
                    }
                } else {
                    if (p === 4) {
                        for (A = r; A < B; A++) {
                            for (z = A + 3; z < o; z++) {
                                q.push(l(k, t[A + 2], t[z]))
                            }
                        }
                    } else {
                        if (p === 5) {
                            for (A = r; A < B; A++) {
                                for (z = A + 4; z < o; z++) {
                                    for (y = A + 3; y < z; y++) {
                                        q.push(l(k, t[A + 2], t[y], t[z]))
                                    }
                                }
                            }
                        } else {
                            if (p === 6) {
                                for (A = r; A < B; A++) {
                                    for (z = A + 5; z < o; z++) {
                                        for (y = A + 4; y < z; y++) {
                                            for (x = A + 3; x < y; x++) {
                                                q.push(l(k, t[A + 2], t[x], t[y], t[z]))
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (p === 7) {
                                    for (A = r; A < B; A++) {
                                        for (z = A + 6; z < o; z++) {
                                            for (y = A + 5; y < z; y++) {
                                                for (x = A + 4; x < y; x++) {
                                                    for (w = A + 3; w < x; w++) {
                                                        q.push(l(k, t[A + 2], t[w], t[x], t[y], t[z]))
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (p === 8) {
                                        for (A = r; A < B; A++) {
                                            for (z = A + 7; z < o; z++) {
                                                for (y = A + 6; y < z; y++) {
                                                    for (x = A + 5; x < y; x++) {
                                                        for (w = A + 4; w < x; w++) {
                                                            for (v = A + 3; v < w; v++) {
                                                                q.push(l(k, t[A + 2], t[v], t[w], t[x], t[y], t[z]))
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (p === 9) {
                                            for (A = r; A < B; A++) {
                                                for (z = A + 8; z < o; z++) {
                                                    for (y = A + 7; y < z; y++) {
                                                        for (x = A + 6; x < y; x++) {
                                                            for (w = A + 5; w < x; w++) {
                                                                for (v = A + 4; v < w; v++) {
                                                                    for (u = A + 3; u < v; u++) {
                                                                        q.push(l(k, t[A + 2], t[u], t[v], t[w], t[x], t[y], t[z]))
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (p === 10) {
                                                for (A = r; A < B; A++) {
                                                    for (z = A + 9; z < o; z++) {
                                                        for (y = A + 8; y < z; y++) {
                                                            for (x = A + 7; x < y; x++) {
                                                                for (w = A + 6; w < x; w++) {
                                                                    for (v = A + 5; v < w; v++) {
                                                                        for (u = A + 4; u < v; u++) {
                                                                            for (s = A + 3; s < u; s++) {
                                                                                q.push(l(k, t[A + 2], t[s], t[u], t[v], t[w], t[x], t[y], t[z]))
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return q
    },
    assemble_array: function(a, b) {
        var c = [];
        for (var f = 0; f < a.length; f++) {
            for (var d = 0; d < b.length; d++) {
                if (a[f] != b[d]) {
                    c.push($.sort_number(a[f], b[d]))
                }
            }
        }
        return c
    },
    assemble_array2: function(a, b) {
        var c = [];
        for (var d = 0; d < b.length; d++) {
            c.push([].concat(a, b[d]).sort(function(g, f) {
                    return g - f
                }
            ).join(" "))
        }
        return c
    },
    sort_number: function(b, d) {
        var f = parseInt(b, 10);
        var c = parseInt(d, 10);
        var a = "";
        if (f > c) {
            a = d + " " + b
        } else {
            a = b + " " + d
        }
        return a
    },
    isInt: function(a) {
        return (/^[1-9]\d*$/).test(a)
    },
    isBall: function(a) {
        return (/^[0-4]?[0-9]$/).test(a) ? ((/^0?0$/).test(a) ? false : a) : false
    },
    isPfloat: function(a) {
        return (/^\d+(\.\d+)?$/).test(a)
    },
    isUP: function(a) {
        return (/^[a-zA-Z0-9_\-.]{4,12}$/).test(a)
    },
    isPWD: function(a) {
        return a.length >= 4 && a.length <= 12
    },
    _popup: null ,
    popup: function(g, a, d, c, f) {
        a = a || 600;
        d = d || 200;
        c = c || "no";
        f = f || "no";
        var b = (screen.width) ? (screen.width - a) / 2 : 0;
        var j = (screen.height) ? (screen.height - d) / 2 : 0;
        if ($._popup) {
            try {
                $._popup.close()
            } catch (i) {}
        }
        $._popup = window.open(g, "popup", "height=" + d + ",width=" + a + ",top=" + j + ",left=" + b + ",scrollbars=" + c + ",resizable=" + f)
    },
    ajaxAction: function(c, a, b) {
        $.getJSON(b, function(d) {
                a.call(c, d)
            }
        )
    },
    evalJSON: function(t) {
        if (!t) {
            return {}
        }
        var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g;
        cx.lastIndex = 0;
        if (cx.test(t)) {
            t = t.replace(cx, function(a) {
                    return "\\u" + ("0000" + a.charCodeAt(0).toString(16)).slice(-4)
                }
            )
        }
        if (/^[\],:{}\s]*$/.test(t.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, ""))) {
            return eval("(" + t + ")")
        }
    },
    encodeJSON: function(d) {
        var f = typeof d;
        if ("object" == f) {
            if (d == null ) {
                f = "null"
            } else {
                if (Array == d.constructor) {
                    f = "array"
                } else {
                    if (RegExp == d.constructor) {
                        f = "regexp"
                    } else {
                        if (d.nodeName) {
                            f = d.nodeName
                        } else {
                            f = "object"
                        }
                    }
                }
            }
        }
        switch (f) {
            case "undefined":
            case "unknown":
                return;
                break;
            case "function":
            case "boolean":
            case "regexp":
                return d.toString();
                break;
            case "number":
                return isFinite(d) ? d.toString() : "null";
                break;
            case "string":
                return '"' + d.replace(/(\\|\")/g, "\\$1").replace(/\n|\r|\t/g, function() {
                            var h = arguments[0];
                            return (h == "\n") ? "\\n" : (h == "\r") ? "\\r" : (h == "\t") ? "\\t" : ""
                        }
                    ) + '"';
                break;
            case "object":
                if (d === null ) {
                    return "null"
                }
                var c = [];
                for (var a in d) {
                    var g = jQuery.encodeJSON(d[a]);
                    if (g !== undefined) {
                        c.push(jQuery.encodeJSON(a) + ":" + g)
                    }
                }
                return "{" + c.join(",") + "}";
                break;
            case "array":
                var c = [];
                for (var b = 0; b < d.length; b++) {
                    var g = jQuery.encodeJSON(d[b]);
                    if (g !== undefined) {
                        c.push(g)
                    }
                }
                return "[" + c.join(",") + "]";
                break;
            default:
                return f
        }
    },
    trigger: function(a, b) {
        $(document).triggerHandler(a, b)
    },
    bind: function(a, c, b) {
        $(document).bind(a, c, b)
    },
    unbind: function(a, b) {
        $(document).unbind(a, b)
    },
    lightOn: function(k, h) {
        if (k.length <= 0) {
            return
        }
        for (var g = 0, a = k.length; g < a; g++) {
            var b = $(k[g]);
            var l = b.attr("lightCount");
            if (h && undefined === l) {
                l = 0
            } else {
                if (undefined === l || "0" == l) {
                    l = 1;
                    b.addClass("light")
                } else {
                    l++;
                    b.addClass("light")
                }
            }
            b.attr("lightCount", l)
        }
        setTimeout(function() {
                for (var m = 0, d = k.length; m < d; m++) {
                    var f = $(k[m]);
                    var n = f.attr("lightCount") - 1;
                    if (-1 === n) {
                        n = 0;
                        k[m] = null
                    } else {
                        if (n <= 0) {
                            f.removeClass("light");
                            k[m] = null
                        }
                    }
                    f.attr("lightCount", n)
                }
            }
            , $.odds_light)
    },
    initLight: function(b) {
        for (var a in b) {
            if (b.hasOwnProperty(a)) {
                b[a].removeAttribute("lightCount")
            }
        }
    },
    validateEm: function(c) {
        var f = $(c).attr("valid");
        c.value = $.trim(c.value);
        var g = c.value;
        var d = true;
        var a = function() {
                var h = {
                    name: "名称由汉字的简繁体(一个汉字2位字符)、圆点（.）、字母、数字、下划线组成，长度不超过16个英文字符或8个汉字！",
                    account: "账号由1-12位英文字母、数字、下划线组成，且第一位不能是下划线",
                    password: $.isStrongPwd ? "密码由6-12位字符组成，必须包含字母和数字" : "密码由4-16位字符组成",
                    amount: "金额由不大于9位的正整数组成"
                };
                alert(h[f]);
                setTimeout(function() {
                        c.focus();
                        c.select()
                    }
                    , 0)
            }
            ;
        switch (f) {
            case "name":
                c.value = g.replace(/\s{2,}/g, " ");
                c.value = $.trim(c.value);
                var b = c.value.replace(/[^\x00-\xff]/g, "**").length;
                d = (/^[a-zA-Z0-9_\.\u4e00-\u9fa5]+$/).test(c.value) && b > "0" && b < "17";
                break;
            case "account":
                d = (/^[a-zA-Z0-9]+[a-zA-Z0-9_]*$/).test(g) && g.length < 13;
                break;
            case "password":
                if ($.isStrongPwd) {
                    d = (/^(?![^a-zA-Z]+$)(?!\D+$)[a-zA-Z0-9]{6,12}$/).test(g)
                } else {
                    d = (/^[^\u4e00-\u9fa5]{4,16}$/).test(g)
                }
                break;
            case "amount":
                d = (/^[1-9]\d{0,8}$/).test(g);
                break;
            default:
                break
        }
        if (!d) {
            a()
        }
        return d
    },
    validateForm: function(b) {
        ems = b.elements;
        for (var a = 0; a < ems.length; a++) {
            if ($(ems[a]).attr("valid") && !$.validateEm(ems[a])) {
                return false
            }
        }
        return true
    },
    clearArray: function(f) {
        var c = {};
        var a = [];
        for (var b = 0; b < f.length; b++) {
            if (!c[f[b]]) {
                a.push(f[b]);
                c[f[b]] = 1
            }
        }
        return a
    },
    isOpTime: function(a) {
        var b = a.getHours() + "" + a.getMinutes();
        return "2045" < b && b < "2145"
    },
    accMul: function(d, b) {
        var a = 0
            , f = d + ""
            , c = b + "";
        try {
            a += f.split(".")[1].length
        } catch (g) {}
        try {
            a += c.split(".")[1].length
        } catch (g) {}
        return Number(f.replace(".", "")) * Number(c.replace(".", "")) / Math.pow(10, a)
    },
    accAdd: function(d, b) {
        var a = 0
            , f = d + ""
            , c = b + "";
        try {
            f = d.toString().split(".")[1].length
        } catch (g) {
            f = 0
        }
        try {
            c = b.toString().split(".")[1].length
        } catch (g) {
            c = 0
        }
        a = Math.pow(10, Math.max(c, c));
        return (d * a + b * a) / a
    },
    getRound: function(b, a) {
        return Math.round(Math.random() * 1000) % (a - b) + b
    }
});
var Guoguan = function(f) {
        if (window.parent === window.self) {
            $("body").empty();
            alert("新窗口不可用，请关闭该窗口。");
            return
        }
        this.id = "guoguan";
        this.game_ids = $.cfg_play_keys.guoguan;
        $.game_ids = this.game_ids;
        this.orders = [];
        this.product_name = document.getElementById("product_name").innerHTML;
        var a = document.getElementById("time_stamp");
        this.time_stamp = a ? a.value : 0;
        var b = document.getElementById("cps_time");
        this.cps_time = b ? b.value : 0;
        $.last_update.time_stamp = this.time_stamp;
        a = f.getAttribute("status");
        this.status = a ? $.evalJSON(a)[$.game_ids] : 1;
        this.drawStatus = "";
        this.ustatus = 2;
        this.ath = null ;
        var c = this;
        this.odds = {};
        this.sumCtl = $("#form_mark input:text");
        parent.$.bind("init." + c.id, function(j, i, d, h, g) {
                parent.$.unbind("init." + c.id);
                c.odds_set = i;
                c.ca = d;
                c.drawStatus = h;
                c.ustatus = g;
                c.init.call(c)
            }
        );
        parent.$.trigger("getinit");
        $(window).unload(function() {
                parent.$.unbind("." + c.id)
            }
        )
    }
    ;
Guoguan.prototype.init = function() {
    var b = this;
    parent.$.trigger("changelimit", b.id);
    var a = function() {
            return ( setInterval(function() {
                    if ($.ontime()) {
                        return
                    }
                    $.getJSON("/odds/getOdds?game_ids=" + b.game_ids + "&odds_set=" + b.odds_set + "&time_stamp=" + $.last_update.time_stamp, function(c) {
                            b.refersh(c);
                            if (c.header.popup) {
                                window.parent.header.notice_popup("one")
                            }
                        }
                    )
                }
                , $.odds_refersh))
        }
        ;
    parent.$.bind("toajax." + b.id, function(c, f) {
            if (b.ath) {
                clearInterval(b.ath);
                b.ath = null
            }
            if (f && 1 === b.ustatus) {
                b.ath = a()
            }
        }
    );
    if (this.ca) {
        parent.$.bind("cpsdata." + b.id, function(f, g, c) {
                b.cometFresh.call(b, g, c)
            }
        );
        $("#" + this.id + " label span:last-child").each(function(c) {
                b.odds[this.id] = this
            }
        );
        parent.$.trigger("changechannel", [b.id, b.cps_time])
    } else {
        if (1 === b.ustatus) {
            this.ath = a()
        }
    }
    this.regist_submit_click();
    parent.$.bind("reset." + b.id, function() {
            document.getElementById("form_mark").reset();
            $("#rate_total").text("");
            $("#total_limit").text("");
            $.trigger("renderMul")
        }
    );
    parent.$.bind("resubmit." + b.id, function() {
            b.set_rate_max();
            $("#form_mark").trigger("submit")
        }
    );
    parent.$.bind("ablesubmit." + b.id, function() {
            $(":submit").removeAttr("disabled")
        }
    )
}
;
Guoguan.prototype.refersh = function(a) {
    $.refersh(a);
    if (a.guoGuanMaxMoney) {
        $("#guoGuanMaxMoney").text(a.guoGuanMaxMoney)
    }
    this.time_stamp = a.time_stamp;
    this.set_rate_max()
}
;
Guoguan.prototype.cometFresh = function(f, b) {
    var c = this;
    c.time_stamp = b;
    for (var a in f) {
        if (f.hasOwnProperty(a)) {
            if ("guoGuanMaxMoney" == a) {
                $("#guoGuanMaxMoney").text(f[a]);
                continue
            }
            if (("1" == c.drawStatus || "2" == c.drawStatus) && a.indexOf("odds") === 0 && a.indexOf(c.odds_set) === 9) {
                $.refersh_odds(f[a]);
                c.set_rate_max();
                continue
            }
            if ("drawStatus" == a) {
                if (c.drawStatus != f[a]) {
                    c.time_stamp = 1;
                    $.getJSON("/odds/getOdds?game_ids=" + c.game_ids + "&odds_set=" + c.odds_set + "&time_stamp=" + c.time_stamp, function(g) {
                            c.refersh(g)
                        }
                    );
                    c.drawStatus = f[a]
                }
                if ("2" == f[a]) {
                    f[a] = 0
                } else {
                    f[a] = parseInt(f[a], 10)
                }
                c.curstop(f[a]);
                continue
            }
            if (a == "curstop") {
                for (var b in f[a]) {
                    if (f[a].hasOwnProperty(b) && b == c.game_ids) {
                        c.curstop(f[a][b], b)
                    }
                }
            }
        }
    }
}
;
Guoguan.prototype.curstop = function(a, b) {
    if (this.status === a) {
        return
    }
    if (0 === a) {
        $("#form_mark").find(":submit, :reset").attr("disabled", "disabled").addClass("bds");
        $("#form_mark").find(":text").attr("disabled", "disabled").addClass("dis");
        $("#main_tab :radio").attr("disabled", "disabled");
        $("#multiple input").attr("disabled", "disabled")
    } else {
        $("#form_mark").find(":submit, :reset").removeAttr("disabled").removeClass("bds");
        $("#form_mark").find(":text").removeAttr("disabled").removeClass("dis");
        $("#main_tab :radio").removeAttr("disabled");
        $("#is_mul").removeAttr("disabled");
        $.trigger("renderMul")
    }
    this.status = a
}
;
Guoguan.prototype.set_rate = function(b) {
    $.last_update = b;
    var a = b.odds;
    $("table input[type='radio']").each(function(c) {
            var d = this.getAttribute("no");
            $("#" + d).text(a[d])
        }
    );
    if (b.status[this.game_ids] != 1) {
        $("input").attr("disabled", "disabled");
        return
    }
}
;
Guoguan.prototype.regist_submit_click = function() {
    var a = this;
    $("#form_mark").submit(function(b) {
            if ($(":submit:first", b.target)[0].disabled) {
                return false
            }
            if (a.get_orders()) {
                parent.$.trigger("showneworder", {
                    gameId: a.id,
                    game: a.product_name,
                    odds_set: a.odds_set,
                    order: a.orders
                })
            }
            return false
        }
    );
    $("#form_mark").bind("reset", function() {
            $("#rate_total").text("");
            $("#total_limit").text("");
            $("#main_tab input").attr("checked", false);
            $("#value").val("");
            return false
        }
    );
    $("#form_mark").click(function(c) {
            var b = c.target;
            if (b.type === "radio") {
                a.set_rate_max(b)
            }
        }
    )
}
;
Guoguan.prototype.set_rate_max = function(d) {
    var b = $("#main_tab input:checked");
    var j = parseFloat($("#discount").val());
    var a = parseInt($("#max").val(), 10);
    if (d && b.length > 8) {
        alert("最多可以选择8项");
        d.checked = false;
        return
    }
    if (b.length > 0) {
        var c = 1;
        for (var g = 0; g < b.length; g++) {
            c = $.accMul(c, $(b[g]).next().next().text())
        }
        var h = c > a ? 0 : parseInt($("#max").val() / (c + j), 10);
        c = c.toString();
        var f = c.indexOf(".");
        if (-1 == f) {
            $("#rate_total").text(c + ".000")
        } else {
            c = c + "000";
            $("#rate_total").text(c.substr(0, f + 4))
        }
        $("#total_limit").text(h)
    }
}
;
Guoguan.prototype.get_orders = function() {
    var b = $("#main_tab input:checked");
    if (b.length <= 1) {
        alert("至少选择两组");
        return false
    }
    var k = document.getElementById("value");
    this.orders = [];
    var m = parseInt(k.value, 10) - parseInt($("#total_limit").text(), 10);
    if (m > 0) {
        alert("{#|4e0b|6ce8#}金额大于封顶金额".keyComment() + parseInt($("#total_limit").text(), 10));
        return false
    } else {
        if ($.isInt(k.value)) {
            var g = [];
            var j = [];
            var c = [];
            var l = "";
            var f = "";
            for (var d = 0; d < b.length; d++) {
                var h = b[d].parentNode.parentNode;
                var a = $(b[d]).attr("no");
                j.push($("#" + a).text());
                g.push(a.substr(3) + "|" + $("#" + a).text());
                c.push(a.substr(3));
                l += "<br/>[ " + $.stripTags(h.parentNode.cells[0].innerHTML + " " + h.innerHTML) + " ]";
                f += "," + $.stripTags(h.parentNode.cells[0].innerHTML + b[d].nextSibling.innerHTML)
            }
            f = f.substr(1);
            l += "<br/>组合{#|8d54|7387#}：".keyComment();
            var n = parseFloat($("#rate_total").text());
            if (!$.isPfloat(n)) {
                alert("{#|8d54|7387#}不正确，请刷新页面后重新提交！".keyComment());
                return false
            }
            this.orders.push({
                no: l,
                odds: $("#rate_total").text(),
                amount: k.value,
                key: $.cfg_play_keys[this.id] + c.join(","),
                games: c.join(","),
                limit: $("#total_limit").text(),
                detail: g.join(";"),
                odds_detail: j.join(","),
                show_str: f
            });
            return true
        } else {
            alert("请输入整数金额");
            k.select();
            return false
        }
    }
}
;
var Liuxiao = function(f) {
        if (window.parent === window.self) {
            $("body").empty();
            alert("新窗口不可用，请关闭该窗口。");
            return
        }
        this.d = f;
        this.id = "liuxiao";
        this.orders = [];
        this.product_name = document.getElementById("product_name").innerHTML;
        this.game_ids = $.cfg_play_keys.liuxiaozh + "|" + $.cfg_play_keys.jinliudansh;
        this.odds = $.cfg_play_keys.liuxiaozh + "01";
        this.oddsTD = document.getElementById(this.odds);
        this.checked = [];
        var a = f.getAttribute("status");
        a = a ? $.evalJSON(a) : 0;
        this.status = a ? a[$.cfg_play_keys.liuxiaozh] : 1;
        this.stop_liu_dansh = a[$.cfg_play_keys.jinliudansh];
        a = document.getElementById("time_stamp");
        this.time_stamp = a ? a.value : 0;
        var b = document.getElementById("cps_time");
        this.cps_time = b ? b.value : 0;
        this.drawStatus = "";
        this.ustatus = 2;
        this.ath = null ;
        this.odom = {};
        this.sumCtl = $("#form_mark input:text");
        this.main_radio = $("#main_tab :checkbox");
        $.last_update.time_stamp = document.getElementById("time_stamp").value;
        var c = this;
        parent.$.bind("init." + c.id, function(j, i, d, h, g) {
                parent.$.unbind("init." + c.id);
                c.odds_set = i;
                c.ca = d;
                c.drawStatus = h;
                c.ustatus = g;
                c.init.call(c)
            }
        );
        parent.$.trigger("getinit");
        $(window).unload(function() {
                parent.$.unbind("." + c.id)
            }
        )
    }
    ;
Liuxiao.prototype.init = function() {
    parent.$.trigger("changelimit", this.id);
    var c = this, b;
    c.main_radio.click(function() {
            c.checked = c.main_radio.filter(":checked");
            if (c.checked.length >= 6) {
                c.main_radio.filter(":not(:checked)").attr("disabled", "disabled")
            } else {
                c.main_radio.filter(":not(:checked)").removeAttr("disabled")
            }
        }
    );
    $("#sub_tab :radio").change(function() {
            if (this.name === "achk") {
                var d = $.cfg_play_keys[this.value] + "01";
                c.oddsTD.id = d;
                c.odds = d
            }
        }
    );
    $("#form_mark").submit(function(d) {
            if ($(":submit:first", d.target)[0].disabled) {
                return false
            }
            c.submit_bet(this);
            return false
        }
    );
    $("#form_mark").bind("reset", function() {
            c.checked = [];
            c.main_radio.removeAttr("disabled").attr("checked", false);
            $("#sum").val("");
            $.trigger("renderMul");
            b.attr("checked", false);
            return false
        }
    );
    c.odom[c.odds] = document.getElementById(c.odds);
    var a = function() {
            return ( setInterval(function() {
                    if ($.ontime()) {
                        return
                    }
                    $.getJSON("/odds/getOdds?game_ids=" + c.game_ids + "&odds_set=" + c.odds_set + "&time_stamp=" + c.time_stamp, function(f) {
                            c.set_status(f);
                            if (c.ca) {
                                parent.$.trigger("cpsset", [{
                                    timestamp: f.time_stamp
                                }])
                            }
                            if (f.header.popup) {
                                window.parent.header.notice_popup("one")
                            }
                        }
                    )
                }
                , $.odds_refersh))
        }
        ;
    parent.$.bind("toajax." + c.id, function(f, g) {
            if (c.ath) {
                clearInterval(c.ath);
                c.ath = null
            }
            if (g && 1 === c.ustatus) {
                c.ath = a()
            }
        }
    );
    if (this.ca) {
        parent.$.bind("cpsdata." + c.id, function(g, h, f) {
                c.cometFresh.call(c, h, f)
            }
        );
        parent.$.trigger("changechannel", [c.id, c.cps_time])
    } else {
        if (1 === c.ustatus) {
            c.ath = a()
        }
    }
    parent.$.bind("reset." + c.id, function() {
            $("#form_mark").trigger("reset");
            $.trigger("renderMul")
        }
    );
    parent.$.bind("ablesubmit." + c.id, function() {
            $(":submit").removeAttr("disabled")
        }
    );
    b = $("#jiaqin,#yeshou").bind("click keypress", function(d) {
            if (d.type === "click") {
                $.each(c.main_radio, function(f, g) {
                        var h = g.value;
                        g.checked = false;
                        g.setAttribute("disabled", "disabled");
                        if (h.match(/^(02|07|08|10|11|12)$/g) && d.target.value === "jiaqin") {
                            g.checked = true;
                            g.removeAttribute("disabled")
                        }
                        if (h.match(/^(01|03|04|05|06|09)$/g) && d.target.value === "yeshou") {
                            g.checked = true;
                            g.removeAttribute("disabled")
                        }
                    }
                )
            }
            if (d.type === "keypress" && d.keyCode === 13) {
                $("#form_mark").submit()
            }
        }
    )
}
;
Liuxiao.prototype.cometFresh = function(g, c) {
    var f = this;
    f.time_stamp = c;
    var a = function(h) {
            f.set_status(h);
            if (h.header.popup) {
                window.parent.header.notice_popup("one")
            }
        }
        ;
    for (var b in g) {
        if (g.hasOwnProperty(b)) {
            if (("1" == f.drawStatus || "2" == f.drawStatus) && b.indexOf("odds") === 0 && b.indexOf(f.odds_set) === 9) {
                $.refersh_odds(g[b]);
                continue
            }
            if ("drawStatus" == b) {
                if (f.drawStatus != g[b]) {
                    f.time_stamp = 1;
                    $.getJSON("/odds/getOdds?game_ids=" + f.game_ids + "&odds_set=" + f.odds_set + "&time_stamp=" + f.time_stamp, a);
                    f.drawStatus = g[b]
                }
                if ("2" == g[b]) {
                    g[b] = 0
                } else {
                    g[b] = parseInt(g[b], 10)
                }
                f.curstop(g[b]);
                continue
            }
            if (b == "curstop") {
                for (var c in g[b]) {
                    if (g[b].hasOwnProperty(c)) {
                        if (c == $.cfg_play_keys.liuxiaozh) {
                            f.curstop(g[b][c], c)
                        } else {
                            if (c == $.cfg_play_keys.jinliudansh) {
                                f.stop_liu_dansh = g[b][c]
                            }
                        }
                    }
                }
            }
        }
    }
}
;
Liuxiao.prototype.curstop = function(a, b) {
    if (this.status === a) {
        return
    }
    if (a) {
        $("input").removeAttr("disabled").removeClass("dis").removeClass("bds");
        $("#is_mul").removeAttr("disabled");
        $.trigger("renderMul")
    } else {
        $("input").attr("disabled", "disabled");
        $(":text").addClass("dis");
        $(":submit, :reset").addClass("bds");
        $("#multiple input").attr("disabled", "disabled")
    }
    this.status = a
}
;
Liuxiao.prototype.set_status = function(b) {
    var a = $.cfg_play_keys.liuxiaozh;
    this.curstop(b.status[a]);
    parent.$.trigger("cpsset", [{
        timestamp: b.time_stamp
    }]);
    $.refersh_odds_header(b);
    this.stop_liu_dansh = b.status[$.cfg_play_keys.jinliudansh];
    this.time_stamp = b.time_stamp
}
;
Liuxiao.prototype.submit_bet = function(a) {
    this.checked = this.main_radio.filter(":checked");
    if (this.checked.length !== 6) {
        alert("请选择六项");
        return
    }
    if (!this.stop_liu_dansh) {
        var f = this.main_radio;
        var j = "";
        var k = 0;
        for (var c = 0; c < f.length; c += 2) {
            if (j === "") {
                j = f.get(c).checked;
                k++
            } else {
                if (j == f.get(c).checked) {
                    k++
                }
            }
        }
        if (k >= 6) {
            alert("禁六单双!请单双结合选择,不要全部选择单或双.");
            return
        }
    }
    this.orders = [];
    var h = a.amount;
    var g = $("input[type=radio]:checked", "#sub_tab").get(0).value;
    if ($.isInt(h.value)) {
        var d = [];
        var b = [];
        $.each(this.checked, function() {
                var i = this.parentNode;
                d.push(i.parentNode.cells[i.cellIndex - 2].innerHTML);
                b.push(this.value)
            }
        );
        var l = parseFloat($("#" + this.odds).text());
        if (!$.isPfloat(l)) {
            alert("{#|8d54|7387#}不正确，请刷新页面后重新提交！".keyComment());
            return false
        }
        this.orders.push({
            key: $.cfg_play_keys[g] + b.join(","),
            no: g == "liuxiaozh" ? "(中)" : "({#|4e0d|4e2d#})".keyComment(),
            odds: $("#" + this.odds).text(),
            amount: h.value,
            show_str: d.join(",")
        });
        parent.$.trigger("showneworder", {
            gameId: this.id,
            game: this.product_name,
            order: this.orders,
            odds_set: this.odds_set,
            footer: "<li>" + d.join(" ") + "</li>"
        })
    } else {
        alert("请输入一个整数金额");
        h.select()
    }
}
;
var PlaysBall = function(h) {
        if (window.parent === window.self) {
            $("body").empty();
            alert("新窗口不可用，请关闭该窗口。");
            return
        }
        this.id = h.getAttribute("id");
        this.orders = [];
        this.right_box = {};
        this.ball_keys = {};
        this.odds_keys = {};
        this.last_chgs = {
            status: 1,
            odds: {}
        };
        this.product_name = document.getElementById("product_name").innerHTML;
        this.cover = new Cover("#fff",0.1,4);
        var a = document.getElementById("time_stamp");
        this.time_stamp = a ? a.value : 0;
        var b = document.getElementById("cps_time");
        this.cps_time = b ? b.value : 0;
        this.popupInit = 0;
        this.gameIds = this.get_keys();
        this.pro = {};
        a = h.getAttribute("status");
        this.pros = a ? $.evalJSON(a) : {};
        this.drawStatus = "";
        this.userOdds = "";
        this.ustatus = 2;
        this.is_chgA2B = false;
        this.ath = null ;
        this.timeout = 0;
        this.sumCtl = $("#form_left input:text,#right_amount");
        $.last_update.time_stamp = document.getElementById("time_stamp").value;
        var c = this;
        var g;
        var f = function() {
                if (!parent.$ || !parent.$.bind || !parent.$.trigger) {
                    return
                }
                clearInterval(g);
                g = setInterval(function() {
                        parent.$.trigger("getinit")
                    }
                    , 99);
                parent.$.bind("init." + c.id, function(l, k, d, j, i) {
                        parent.$.unbind("init." + c.id);
                        clearInterval(g);
                        g = null ;
                        c.userOdds = k;
                        c.odds_set = "tema" == c.id ? c.userOdds + "A" : k;
                        c.ca = d;
                        c.drawStatus = j;
                        c.ustatus = i;
                        c._init.call(c)
                    }
                );
                parent.$.trigger("getinit")
            }
            ;
        g = setInterval(f, 99);
        f();
        $(window).unload(function() {
                parent.$.unbind("." + c.id)
            }
        );
        this._refersh()
    }
    ;
PlaysBall.prototype._init = function() {
    var b = this;
    b.regist_body_click();
    $.each($("#form_left :text"), function(d, h) {
            var j = h.parentNode;
            var g = j.parentNode;
            var f = g.cells[j.cellIndex - 1];
            var c = h.name.substr(4);
            f.id = c;
            b.odds_keys[c] = f;
            b.ball_keys[g.cells[j.cellIndex - 2].firstChild.innerHTML] = c
        }
    );
    $("#sx_choose").attr("num", function() {
            var c = $(this).attr("num");
            $.products[$(this).attr("no")] = c.split(",")
        }
    );
    var a = function() {
            return ( setInterval(function() {
                    if (!$.ontime()) {
                        b._refersh()
                    }
                }
                , $.odds_refersh))
        }
        ;
    parent.$.bind("toajax." + b.id, function(c, f) {
            if (b.ath) {
                clearInterval(b.ath);
                b.ath = null
            }
            if (f && 1 === b.ustatus) {
                b.ath = a()
            }
        }
    );
    if (b.ca) {
        parent.$.bind("cpsdata." + b.id, function(f, g, c) {
                b.cometFresh.call(b, g, c)
            }
        );
        parent.$.trigger("changechannel", [b.id, b.cps_time])
    } else {
        if (1 === b.ustatus) {
            b.ath = a()
        }
    }
    parent.$.trigger("changelimit", b.id);
    parent.$.bind("reset." + b.id, function() {
            document.getElementById("form_left").reset();
            var c = document.getElementById("form_right");
            if (c) {
                c.reset();
                b.check_num("all", "uncheck");
                $("#num_chooser :radio").removeAttr("checked")
            }
            $.trigger("renderMul")
        }
    );
    parent.$.bind("ablesubmit." + b.id, function() {
            $(":submit").removeAttr("disabled")
        }
    )
}
;
PlaysBall.prototype.get_keys = function() {
    switch (this.id) {
        case "tema":
            return [$.cfg_play_keys.tema, $.cfg_play_keys.lmtema, $.cfg_play_keys.sebotema];
        case "zhengma":
            return [$.cfg_play_keys.zhengma, $.cfg_play_keys.lmzhma];
        case "zhengmate1":
            this.product_name = "{#|6b63#}1特".keyComment();
            return [$.cfg_play_keys.zhengmate1, $.cfg_play_keys.lmzhmate1, $.cfg_play_keys.sebozhmate1];
        case "zhengmate2":
            this.product_name = "{#|6b63#}2特".keyComment();
            return [$.cfg_play_keys.zhengmate2, $.cfg_play_keys.lmzhmate2, $.cfg_play_keys.sebozhmate2];
        case "zhengmate3":
            this.product_name = "{#|6b63#}3特".keyComment();
            return [$.cfg_play_keys.zhengmate3, $.cfg_play_keys.lmzhmate3, $.cfg_play_keys.sebozhmate3];
        case "zhengmate4":
            this.product_name = "{#|6b63#}4特".keyComment();
            return [$.cfg_play_keys.zhengmate4, $.cfg_play_keys.lmzhmate4, $.cfg_play_keys.sebozhmate4];
        case "zhengmate5":
            this.product_name = "{#|6b63#}5特".keyComment();
            return [$.cfg_play_keys.zhengmate5, $.cfg_play_keys.lmzhmate5, $.cfg_play_keys.sebozhmate5];
        case "zhengmate6":
            this.product_name = "{#|6b63#}6特".keyComment();
            return [$.cfg_play_keys.zhengmate6, $.cfg_play_keys.lmzhmate6, $.cfg_play_keys.sebozhmate6];
        default:
            break
    }
}
;
PlaysBall.prototype.curstop = function(b) {
    for (var a in b) {
        if (b.hasOwnProperty(a) && this.pros.hasOwnProperty(a)) {
            if (!this.pro[a]) {
                this.pro[a] = $('*[pro="' + a + '"] input[type="text"]')
            }
            if (this.pros[a] !== b[a] && this.ustatus == 1) {
                if (b[a]) {
                    this.pro[a].removeAttr("disabled");
                    this.pro[a].removeClass("dis")
                } else {
                    this.pro[a].attr("disabled", "disabled");
                    this.pro[a].addClass("dis")
                }
                this.pros[a] = b[a]
            }
        }
    }
    if (this.ustatus != 1 || !this.pros[this.gameIds[0]] && !this.pros[this.gameIds[1]] && !this.pros[this.gameIds[2] || this.gameIds[0]]) {
        $("#submit_left, #reset_left").attr("disabled", "disabled").addClass("bds")
    } else {
        $("#submit_left, #reset_left").removeAttr("disabled").removeClass("bds")
    }
    if (this.ustatus != 1 || 0 === this.pros[this.gameIds[0]]) {
        $("#submit_right, #reset_right, #out_choose, #pop_submit").attr("disabled", "disabled").addClass("bds");
        $("#multiple input").attr("disabled", "disabled");
        $("#pop_amount").attr("disabled", "disabled").addClass("dis")
    } else {
        $("#submit_right, #reset_right, #out_choose, #pop_submit").removeAttr("disabled").removeClass("bds");
        $("#pop_amount").removeAttr("disabled").removeClass("dis");
        $("#is_mul").removeAttr("disabled");
        $.trigger("renderMul")
    }
}
;
PlaysBall.prototype.get_orders_left = function() {
    var a = $("#form_left input:enabled[type='text'][value!='']");
    this.orders = [];
    var b = [];
    $.each(a, function(f, h) {
            if ($.isInt(h.value)) {
                var d = h.parentNode.cellIndex;
                var g = h.parentNode.parentNode;
                var c = parseFloat(g.cells[d - 1].innerHTML);
                if (!$.isPfloat(c)) {
                    alert("{#|8d54|7387#}不正确，请刷新页面后重新提交！".keyComment());
                    return false
                }
                b.push({
                    no: g.cells[d - 2].firstChild.innerHTML,
                    odds: g.cells[d - 1].innerHTML,
                    amount: h.value,
                    key: g.cells[d - 1].id
                })
            } else {
                b = false;
                alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
                h.select();
                return false
            }
        }
    );
    if (b) {
        this.orders = b.sort(function(d, c) {
                var g = parseInt(d.no, 10)
                    , f = parseInt(c.no, 10);
                if (isNaN(g) || isNaN(f)) {
                    return -1
                }
                return g - f
            }
        );
        return true
    }
    return false
}
;
PlaysBall.prototype.regist_body_click = function() {
    var a = this;
    $("#product_mark").click(function(g) {
            var d = g.target;
            if (d.tagName != "TD") {
                d = d.parentNode
            }
            if (d.className.indexOf("hand") < 0) {
                return
            }
            var f = d.parentNode;
            var c = d.innerHTML != "" && d.firstChild.nodeType == 1 ? f.cells[d.cellIndex + 1].id : d.id;
            var b = d.innerHTML != "" && d.firstChild.nodeType == 1 ? d.firstChild.innerHTML : f.cells[d.cellIndex - 1].firstChild.innerHTML;
            a.quick_product_show(d, c, b)
        }
    );
    $("#form_left").submit(function(b) {
            if ($(":submit:first", b.target)[0].disabled) {
                return false
            }
            if ($(this).find('input[type="text"][value!=""]').length <= 0) {
                alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
                return false
            }
            if (a.get_orders_left()) {
                parent.$.trigger("showneworder", {
                    gameId: a.id,
                    game: a.product_name,
                    order: a.orders,
                    odds_set: a.odds_set
                })
            }
            return false
        }
    );
    $("#form_left").bind("reset", function() {
            $("input:text", this).val("");
            $.trigger("renderMul");
            return false
        }
    );
    $("#change_rate").click(function(c) {
            var b = c.target;
            if (b.nodeName != "A") {
                return
            }
            if (b.href.indexOf("zhengmate") >= 0) {
                return
            }
            a.odds_set = a.userOdds + $(b).attr("odds");
            a.time_stamp = 0;
            a.is_chgA2B = true;
            a._refersh();
            $("a", this).attr("class", "");
            $(b).addClass("on");
            return false
        }
    );
    if (!document.getElementById("form_right")) {
        return
    }
    a.regist_td_style();
    $("#num_chooser").click(function(c) {
            var b = c.target;
            if (b.type != "radio") {
                return
            }
            a.check_num(b.name, "check")
        }
    );
    $("#reset_right").click(function() {
            a.check_num("all", "uncheck");
            $("#num_chooser :radio").removeAttr("checked");
            $.trigger("renderMul")
        }
    );
    $("#out_choose").click(function() {
            a.check_num("all", "out_choose")
        }
    );
    $("#form_right").submit(function(b) {
            if ($(":submit:first", b.target)[0].disabled) {
                return false
            }
            if (a.get_orders_right()) {
                parent.$.trigger("showneworder", {
                    gameId: a.id,
                    game: a.product_name,
                    order: a.orders,
                    odds_set: a.odds_set
                })
            }
            return false
        }
    );
    $("#refresh_draw_result").click(function() {
            a.get_draw_result()
        }
    )
}
;
PlaysBall.prototype.get_draw_result = function() {
    var a = this;
    $.getJSON("ajax_req.htm?act=get_win_number", function(b) {
            a.displayWN(b.winnums)
        }
    )
}
;
PlaysBall.prototype.quick_product_show = function(h, g, i) {
    var f = this;
    if (f.ustatus != 1) {
        return false
    }
    var c = $(h).offset();
    var k = this.odds_keys[g].innerHTML;
    var b = $("#popup");
    var j = parent.header.multiple;
    window.x = 1;
    var a = {
        hundred: [100, "百倍"],
        thousand: [1000, "千倍"],
        t_thousand: [10000, "万倍"]
    };
    if (j) {
        if (j.isMultiple) {
            $("#pop_mul").removeClass("hide");
            window.x = a[j.multiple][0];
            $("#pop_mul_num").html(a[j.multiple][1])
        } else {
            $("#pop_mul").addClass("hide");
            window.x = 1
        }
    }
    $("#pop_name").html(f.product_name + " " + i);
    $("#pop_odds").html(k);
    b.css({
        left: c.left - 110 > 0 ? c.left - 110 : 5,
        top: c.top - 2
    });
    b.show();
    f.cover.show();
    h = $("#pop_amount").val("");
    h[0].select();
    f.showSet = [h, g, i, k];
    if (f.popupInit) {
        return false
    }
    f.popupInit = 1;
    $("#pop_cencel").click(function() {
            f.hideCover();
            return false
        }
    );
    this.cover.onBodyClick(this.hideCover);
    var d = 1;
    $("#pop_form").submit(function(p) {
            if ($(":submit:first", p.target)[0].disabled) {
                return false
            }
            var r = f.showSet[0]
                , q = f.showSet[1]
                , s = f.showSet[2]
                , t = f.showSet[3];
            if ($.isInt(r.val())) {
                if (!d) {
                    return false
                }
                d = 0;
                setTimeout(function() {
                        d = 1
                    }
                    , 1000);
                f.hideCover();
                parent.header.submit_cover.show();
                if (s.length == 1) {
                    s = "0" + s
                }
                var u = "";
                var o = new Date();
                var m = o.getTime();
                var n = parseInt(r.val(), 10) * window.x;
                var l = $.cfg_play_keys[f.id] + "|" + s + "|" + t + "|" + n;
                $.ajax({
                    url: "ajax_req.htm",
                    type: "POST",
                    data: "act=submit_order&game_ids=" + $.cfg_play_keys[f.id] + "&order_allamount=" + n + "&odds_set=" + f.odds_set + "&orderData=" + l + "&detailOdds=" + u + "&timeout=" + f.timeout + "&submit_time_msec=" + m + "&version_number=" + parent.global_version_num,
                    dataType: "json",
                    success: function(w) {
                        var v = [];
                        v.push({
                            no: s,
                            odds: t,
                            amount: n,
                            key: q
                        });
                        parent.header.order_detail = {
                            gameId: f.id,
                            game: f.product_name,
                            order: v,
                            odds_set: f.odds_set
                        };
                        parent.header.new_orders = v;
                        f.timeout = 0;
                        parent.header.responses(w)
                    },
                    complete: function(w, v) {
                        d = 1;
                        parent.header.submit_cover.hide();
                        if (v == "timeout") {
                            f.timeout = 1
                        }
                        if (v != "success" && v != "timeout") {
                            alert("由于网络故障，本次处理异常，请到{#|4e0b|6ce8#}明细中确认{#|6ce8|5355#}.".keyComment())
                        }
                    }
                })
            } else {
                alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
                r.select()
            }
            return false
        }
    )
}
;
PlaysBall.prototype.hideCover = function() {
    $("#popup").hide();
    play.cover.hide()
}
;
PlaysBall.prototype.regist_td_style = function() {
    var c = this;
    $("#right_num").click(function(f) {
            var d = f.target;
            if (d.tagName != "A") {
                return
            }
            $(d.parentNode).toggleClass("choose");
            return false
        }
    );
    $("#right_num td").attr("no", function() {
            if (!this.firstChild) {
                return
            }
            var d = this.firstChild.innerHTML;
            c.right_box[d] = this;
            return d
        }
    );
    var a = $.evalJSON($("#sx_choose").attr("num"));
    for (var b in a) {
        if (a.hasOwnProperty(b)) {
            $.products["sx" + b] = a[b].split(",")
        }
    }
}
;
PlaysBall.prototype.check_num = function(f, b) {
    var d = $.products[f];
    for (var a in d) {
        if (d.hasOwnProperty(a)) {
            var c = this.right_box[d[a]];
            if (b === "out_choose") {
                $(c).toggleClass("choose")
            } else {
                if (b === "check") {
                    $(c).addClass("choose")
                } else {
                    if (b === "uncheck") {
                        $(c).removeClass("choose")
                    }
                }
            }
        }
    }
}
;
PlaysBall.prototype.get_orders_right = function() {
    var a = $("#right_amount").val();
    var c = this;
    if (!$.isInt(a)) {
        alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
        $("#right_amount").select();
        return false
    }
    var d = [];
    var b = $("#right_num .choose");
    if (b.length <= 0) {
        alert("请选择要{#|6295|6ce8#}的球号".keyComment());
        return false
    }
    b.each(function(h) {
            var j = this.firstChild.innerHTML;
            var g = c.ball_keys[j];
            if (c.odds_keys[g]) {
                var f = c.odds_keys[g].innerHTML;
                if (!$.isPfloat(f)) {
                    alert("{#|8d54|7387#}不正确，请刷新页面后重新提交！".keyComment());
                    return false
                }
                d.push({
                    no: j,
                    odds: f,
                    amount: a,
                    key: g
                })
            }
        }
    );
    this.orders = d.sort(function(g, f) {
            var i = parseInt(g.no, 10)
                , h = parseInt(f.no, 10);
            if (isNaN(i) || isNaN(h)) {
                return -1
            }
            return i - h
        }
    );
    return true
}
;
PlaysBall.prototype._refersh = function() {
    var a = this;
    $.getJSON("/odds/getOdds?game_ids=" + this.gameIds.join("|")+"&isDefault=false" + "&odds_set=" + this.odds_set + "&time_stamp=" + this.time_stamp, function(b) {
            a.refersh(b);
            if (b.header.popup) {
                window.parent.header.notice_popup("one")
            }
        }
    )
}
;
PlaysBall.prototype.refersh = function(a) {
    this.curstop(a.status);
    if (a.status.hasOwnProperty("000") && (a.status["000"] == "0" || (this.last_chgs.status.hasOwnProperty("000") && this.last_chgs.status["000"] == "0"))) {
        this.displayWN(a.winnums)
    }
    $.refersh_odds_header(a);
    if (this.is_chgA2B) {
        this.is_chgA2B = false;
        $(".light").removeClass("light")
    }
    this.last_chgs = a;
    this.time_stamp = a.time_stamp;
    $("#headerNotie").html(a.header.marquee)
}
;
PlaysBall.prototype.displayWN = function(h) {
    return;
    var d = this;
    var a = h.split("-");
    var c = "";
    for (var b = 0; b < a.length; b++) {
        if (a[b] != "") {
            if (b === 6) {
                $("#refresh_draw_result").remove();
                c += '<label class="red">&nbsp;+</label>'
            }
            var g = a[b].charAt(0) === "0" ? a[b].charAt(1) : a[b];
            var f = "<label>[" + ARRANIMAL[NUM_ANIMAL[a[b]]] + "]</label>";
            c += ' <em class="ico n' + g + '">' + a[b] + "</em> " + f
        }
    }
    $("#draw_result").html(c)
}
;
PlaysBall.prototype.cometFresh = function(h, c) {
    var f = this;
    f.time_stamp = c;
    for (var b in h) {
        if (h.hasOwnProperty(b)) {
            if (("1" == f.drawStatus || "2" == f.drawStatus) && b.indexOf("odds") === 0 && b.indexOf(f.odds_set) === 9) {
                $.refersh_odds(h[b])
            } else {
                if ("drawStatus" == b) {
                    if (f.drawStatus != h[b]) {
                        f.time_stamp = 1;
                        f.drawStatus = h[b];
                        f._refersh()
                    }
                    if ("2" == h[b]) {
                        h[b] = 0
                    } else {
                        h[b] = parseInt(h[b], 10)
                    }
                    var g = $("*[pro]");
                    for (var a = 0; a < g.length; a++) {
                        c = {};
                        c[g[a].getAttribute("pro")] = h[b];
                        f.curstop(c)
                    }
                } else {
                    if ("winnumber" == b) {
                        f.displayWN(h.winnumber)
                    } else {
                        if ("curstop" == b) {
                            f.curstop(h[b])
                        }
                    }
                }
            }
        }
    }
}
;
$.extend({
    products: {
        hong_bo: ["01", "02", "07", "08", "12", "13", "18", "19", "23", "24", "29", "30", "34", "35", "40", "45", "46"],
        lan_bo: ["03", "04", "09", "10", "14", "15", "20", "25", "26", "31", "36", "37", "41", "42", "47", "48"],
        lu_bo: ["05", "06", "11", "16", "17", "21", "22", "27", "28", "32", "33", "38", "39", "43", "44", "49"],
        da: ["25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49"],
        xiao: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        dan: ["01", "03", "05", "07", "09", "11", "13", "15", "17", "19", "21", "23", "25", "27", "29", "31", "33", "35", "37", "39", "41", "43", "45", "47", "49"],
        shuang: ["02", "04", "06", "08", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40", "42", "44", "46", "48"],
        he_dan: ["01", "03", "05", "07", "09", "10", "12", "14", "16", "18", "21", "23", "25", "27", "29", "30", "32", "34", "36", "38", "41", "43", "45", "47", "49"],
        he_shuang: ["02", "04", "06", "08", "11", "13", "15", "17", "19", "20", "22", "24", "26", "28", "31", "33", "35", "37", "39", "40", "42", "44", "46", "48"],
        hong_da: ["29", "30", "34", "35", "40", "45", "46"],
        hong_xiao: ["01", "02", "07", "08", "12", "13", "18", "19", "23", "24"],
        hong_dan: ["01", "07", "13", "19", "23", "29", "35", "45"],
        hong_shuang: ["02", "08", "12", "18", "24", "30", "34", "40", "46"],
        lan_da: ["25", "26", "31", "36", "37", "41", "42", "47", "48"],
        lan_xiao: ["03", "04", "09", "10", "14", "15", "20"],
        lan_dan: ["03", "09", "15", "25", "31", "37", "41", "47"],
        lan_shuang: ["04", "10", "14", "20", "26", "36", "42", "48"],
        lu_da: ["27", "28", "32", "33", "38", "39", "43", "44", "49"],
        lu_xiao: ["05", "06", "11", "16", "17", "21", "22"],
        lu_dan: ["05", "11", "17", "21", "27", "33", "39", "43", "49"],
        lu_shuang: ["06", "16", "22", "28", "32", "38", "44"],
        da_dan: ["25", "27", "29", "31", "33", "35", "37", "39", "41", "43", "45", "47", "49"],
        da_shuang: ["26", "28", "30", "32", "34", "36", "38", "40", "42", "44", "46", "48"],
        xiao_dan: ["01", "03", "05", "07", "09", "11", "13", "15", "17", "19", "21", "23"],
        xiao_shuang: ["02", "04", "06", "08", "10", "12", "14", "16", "18", "20", "22", "24"],
        wei_da: ["05", "06", "07", "08", "09", "15", "16", "17", "18", "19", "25", "26", "27", "28", "29", "35", "36", "37", "38", "39", "45", "46", "47", "48", "49"],
        wei_xiao: ["01", "02", "03", "04", "10", "11", "12", "13", "14", "20", "21", "22", "23", "24", "30", "31", "32", "33", "34", "40", "41", "42", "43", "44"],
        all: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49"]
    },
    cfg_weishu: {
        0: [10, 20, 30, 40],
        1: ["01", 11, 21, 31, 41],
        2: ["02", 12, 22, 32, 42],
        3: ["03", 13, 23, 33, 43],
        4: ["04", 14, 24, 34, 44],
        5: ["05", 15, 25, 35, 45],
        6: ["06", 16, 26, 36, 46],
        7: ["07", 17, 27, 37, 47],
        8: ["08", 18, 28, 38, 48],
        9: ["09", 19, 29, 39, 49]
    },
    cfg_number_shengxiao: {
        "01": "鼠",
        "02": "牛",
        "03": "虎",
        "04": "兔",
        "05": "龙",
        "06": "蛇",
        "07": "马",
        "08": "羊",
        "09": "猴",
        "10": "鸡",
        "11": "狗",
        "12": "猪"
    },
    cfg_play_keys: {
        tema: "000",
        zhengma: "001",
        zhengmate1: "002",
        zhengmate2: "003",
        zhengmate3: "004",
        zhengmate4: "005",
        zhengmate5: "006",
        zhengmate6: "007",
        erquanzh: "008",
        erzhongte: "009",
        techuan: "010",
        sanquanzh: "011",
        sanzher: "012",
        guoguan: "013",
        shxiao: "014",
        weishu: "015",
        banbo: "016",
        liuxiaozh: "017",
        liuxiaobuzh: "018",
        jinliudansh: "999",
        lmtema: "019",
        lmzhma: "020",
        lmzhmate1: "021",
        lmzhmate2: "022",
        lmzhmate3: "023",
        lmzhmate4: "024",
        lmzhmate5: "025",
        lmzhmate6: "026",
        sebotema: "027",
        sebozhmate1: "028",
        sebozhmate2: "029",
        sebozhmate3: "030",
        sebozhmate4: "031",
        sebozhmate5: "032",
        sebozhmate6: "033",
        texiao: "034",
        shengxiaolian: "035|036|037|038|039|040",
        weishulian: "041|042|043|044|045|046",
        buzhong: "047|048|049|050|051|052",
        shengxiaobuzhong: "053"
    },
    cfg_category_key: {
        tema: "00",
        zhengma: "01",
        zhengmate1: "02",
        lianma2: "03",
        lianma3: "04",
        guoguan: "05",
        shengxiao: "06",
        shengxiaobuzhong: "06",
        weishu: "07",
        banbo: "08",
        liuxiao: "09",
        liangmian: "10",
        zhengma1to6: "10",
        sebo: "11",
        texiao: "12",
        shengxiaolian: "13",
        weishulian: "14",
        buzhong: "15"
    },
    game_category: {
        "000": "00",
        "001": "01",
        "002": "02",
        "003": "02",
        "004": "02",
        "005": "02",
        "006": "02",
        "007": "02",
        "008": "03",
        "009": "03",
        "010": "03",
        "011": "04",
        "012": "04",
        "013": "05",
        "014": "06",
        "015": "07",
        "016": "08",
        "017": "09",
        "018": "09",
        "019": "10",
        "020": "10",
        "021": "10",
        "022": "10",
        "023": "10",
        "024": "10",
        "025": "10",
        "026": "10",
        "027": "11",
        "028": "11",
        "029": "11",
        "030": "11",
        "031": "11",
        "032": "11",
        "033": "11",
        "034": "12",
        "035": "13",
        "036": "13",
        "037": "13",
        "038": "13",
        "039": "13",
        "040": "13",
        "041": "14",
        "042": "14",
        "043": "14",
        "044": "14",
        "045": "14",
        "046": "14",
        "047": "15",
        "048": "15",
        "049": "15",
        "050": "15",
        "051": "15",
        "052": "15",
        "053": "06"
    },
    odds_light: 5000,
    submit_expire: 20000,
    validate_expire: 20000,
    submit_order_expire: 100,
    cps_connect_log: false,
    channel: {
        common: "commonset|curstop",
        tema: "odds_000|odds_019|odds_027",
        zhengma: "odds_001|odds_020",
        zhengmate1: "odds_002|odds_021|odds_028",
        zhengmate2: "odds_003|odds_022|odds_029",
        zhengmate3: "odds_004|odds_023|odds_030",
        zhengmate4: "odds_005|odds_024|odds_031",
        zhengmate5: "odds_006|odds_025|odds_032",
        zhengmate6: "odds_007|odds_026|odds_033",
        zhengma1to6: "odds_021|odds_022|odds_023|odds_024|odds_025|odds_026",
        lianma: "odds_008|odds_009|odds_010|odds_011|odds_012",
        guoguan: "odds_013",
        shengxiao: "odds_014",
        weishu: "odds_015",
        banbo: "odds_016",
        liuxiao: "odds_017",
        texiao: "odds_034",
        shengxiaolian: "odds_035|odds_036|odds_037|odds_038|odds_039|odds_040",
        weishulian: "odds_041|odds_042|odds_043|odds_044|odds_045|odds_046",
        buzhong: "odds_047|odds_048|odds_049|odds_050|odds_051|odds_052"
    },
    time_result_progress: 400
});
var Buzhong = function(b) {
        if (window.parent === window.self) {
            $("body").empty();
            alert("新窗口不可用，请关闭该窗口。");
            return
        }
        this.id = b.id;
        this.checkboxs = $("tbody :checkbox", b);
        this.form = $("#form_mark");
        this.info = $.evalJSON($(b).attr("info"));
        this.status = this.info.status["047"];
        $.last_update.time_stamp = this.info.time_stamp;
        $.last_update.status = this.info.status;
        this.range = [[5, 8], [6, 9], [7, 10], [8, 10], [9, 11], [10, 12]];
        this.play = ["047", "048", "049", "050", "051", "052"];
        this.name = ["五{#|4e0d|4e2d#}".keyComment(), "六{#|4e0d|4e2d#}".keyComment(), "七{#|4e0d|4e2d#}".keyComment(), "八{#|4e0d|4e2d#}".keyComment(), "九{#|4e0d|4e2d#}".keyComment(), "十{#|4e0d|4e2d#}".keyComment()];
        this.play_type = "fs";
        this.pi = "0";
        this.play_button = $("#plays a");
        this.odds_cell = {};
        this.keys = {};
        this.checks = [];
        this.groups = {
            zu: [],
            tmp: []
        };
        this.ath = null ;
        this.all_game = $.cfg_play_keys[this.id];
        this.sumCtl = $("#form_mark input:text");
        var a = this;
        parent.$.bind("init." + a.id, function(h, g, c, f, d) {
                parent.$.unbind("init." + a.id);
                a.odds_set = g;
                a.ca = c;
                a.drawStatus = f;
                a.ustatus = d;
                a.init.call(a)
            }
        );
        parent.$.trigger("getinit");
        $(window).unload(function() {
                parent.$.unbind("." + a.id)
            }
        )
    }
    ;
Buzhong.prototype.init = function() {
    parent.$.trigger("changelimit", this.id);
    var b = this;
    this.checkboxs.each(function() {
            var f = this.parentNode.parentNode;
            var c = this.parentNode.cellIndex;
            var d = f.cells[c - 1];
            var g = $(f.cells[c - 2]).text();
            b.odds_cell[g] = d;
            this.value = g
        }
    );
    this.initDom();
    var a = function() {
            return ( setInterval(function() {
                    if ($.ontime()) {
                        return
                    }
                    $.getJSON("/odds/getOdds?game_ids=" + b.all_game +"&isDefault=false"+ "&odds_set=" + b.odds_set + "&time_stamp=" + $.last_update.time_stamp, function(c) {
                            b.refersh(c);
                            if (c.header.popup) {
                                window.parent.header.notice_popup("one")
                            }
                        }
                    )
                }
                , $.odds_refersh))
        }
        ;
    parent.$.bind("toajax." + b.id, function(c, f) {
            if (b.ath) {
                clearInterval(b.ath);
                b.ath = null
            }
            if (f && 1 === b.ustatus) {
                b.ath = a()
            }
        }
    );
    if (this.ca) {
        parent.$.bind("cpsdata." + b.id, function(f, g, c) {
                b.cometFresh.call(b, g, c)
            }
        );
        parent.$.trigger("changechannel", [b.id, b.info.time_stamp])
    } else {
        if (1 === b.ustatus) {
            b.ath = a()
        }
    }
    $("#buzhong").click(function(g) {
            var h = g.target;
            if ("A" == h.tagName) {
                var f = $(h).attr("name");
                if (f == b.pi) {
                    return false
                }
                $(b.play_button[b.pi]).removeClass("ds d-gray").removeAttr("disabled");
                b.pi = f;
                b.initDom();
                $("#range").text(b.range[f][0] + "~" + b.range[f][1]);
                $(b.play_button[b.pi]).addClass("ds d-gray").attr("disabled", "disabled");
                b.reset();
                return false
            } else {
                if ("INPUT" == h.tagName && h.type == "radio" && h.name === "ty") {
                    if (h.value != b.play_type) {
                        b.play_type = h.value;
                        b.reset()
                    }
                } else {
                    if ("INPUT" == h.tagName && h.type == "checkbox") {
                        b.check(h)
                    } else {
                        if ("INPUT" == h.tagName && h.type == "reset") {
                            b.reset()
                        } else {
                            if ("EM" == h.tagName) {
                                var i = h.parentNode;
                                var c = i.parentNode.cells[i.cellIndex + 2].firstChild;
                                if (c.disabled) {
                                    return
                                }
                                c.checked = !c.checked;
                                b.check(c)
                            }
                        }
                    }
                }
            }
        }
    );
    this.form.submit(function(c) {
            if ($(":submit:first", c.target)[0].disabled) {
                return false
            }
            b.submit_bet();
            return false
        }
    );
    this.form.bind("reset", function() {
            b.reset();
            return false
        }
    );
    parent.$.bind("reset." + b.id, function() {
            b.form.trigger("reset")
        }
    );
    parent.$.bind("resubmit." + b.id, function() {
            b.form.trigger("submit")
        }
    );
    parent.$.bind("ablesubmit." + b.id, function() {
            $(":submit").removeAttr("disabled")
        }
    )
}
;
Buzhong.prototype.initDom = function() {
    this.keys = {};
    for (var b in this.odds_cell) {
        var a = this.play[this.pi] + b;
        this.keys[a] = b;
        this.odds_cell[b].id = a;
        this.odds_cell[b].innerHTML = this.info.odds[a]
    }
}
;
Buzhong.prototype.reset = function() {
    this.checks = [];
    this.groups = {
        zu: [],
        tmp: []
    };
    document.forms[0].sum.value = "";
    this.status = "init";
    this.curstop(this.info.status[this.play[this.pi]]);
    this.checkboxs.attr("checked", false);
    this.showMsg();
    $.trigger("renderMul")
}
;
Buzhong.prototype.submit_bet = function() {
    var d = this.range[this.pi][0];
    var g = this.name[this.pi];
    var b = this.play[this.pi];
    if (this.checks.length < d) {
        alert(g + "至少需要选择" + d + "项");
        return
    }
    var k = document.forms[0].sum;
    if (!$.isInt(k.value)) {
        alert("请输入一个整数金额");
        k.select();
        return
    }
    var h = this.play_type == "dz" ? this.groups.zu : $.assemble(this.checks, d);
    var a = {};
    var j = [];
    var m = [];
    for (var f = 0; f < h.length; f++) {
        a[h[f]] = this.get_min_odds(h[f]);
        j.push(h[f].replace(/\s+/g, ","))
    }
    for (f = 0; f < this.checks.length; f++) {
        m.push(this.info.odds[b + this.checks[f]])
    }
    var c = [{
        no: this.play_type == "dz" ? "[多组]" : "",
        odds: m.join(","),
        key: b,
        len: h.length,
        nos: this.checks.join(","),
        assemble_odd: a,
        show_arr: j,
        ordertype: this.play_type == "dz" ? 6 : 1,
        amount: k.value
    }];
    var l = {
        gameId: this.id,
        game: g,
        order: c,
        odds_set: this.odds_set,
        footer: h
    };
    parent.$.trigger("showneworder", l)
}
;
Buzhong.prototype.get_min_odds = function(h) {
    var f = h.split(" ");
    var b = this.play[this.pi];
    var d = this.info.odds[b + f[0]];
    var g = d + "|" + f[0];
    for (var c = 1; c < f.length; c++) {
        var a = this.info.odds[b + f[c]];
        if (parseFloat(a) < parseFloat(d)) {
            d = a;
            g = d + "|" + f[c]
        }
    }
    return g
}
;
Buzhong.prototype.check = function(g) {
    var h = this;
    var d = this.range[this.pi][0];
    var a = this.range[this.pi][1];
    var c = this.checkboxs.filter(":checked");
    if (this.play_type == "fs") {
        var f = this.checks.length;
        this.checks = [];
        c.each(function() {
                h.checks.push(this.value)
            }
        );
        if (this.checks.length >= a) {
            this.checkboxs.filter(":not(:checked)").attr("disabled", "disabled")
        } else {
            if (f == a) {
                this.checkboxs.removeAttr("disabled")
            }
        }
    } else {
        this.groups.tmp = [];
        c.each(function() {
                h.groups.tmp.push(this.value)
            }
        );
        if (this.groups.tmp.length == d) {
            this.groups.tmp = this.groups.tmp.sort(function(j, i) {
                    return j - i
                }
            );
            if ($.inArray(this.groups.tmp.join(" "), this.groups.zu) >= 0) {
                alert("该组{#|6295|6ce8#}已经存在,请重新组合。".keyComment());
                g.checked = false
            } else {
                this.checks = $.clearArray(this.checks.concat(this.groups.tmp));
                this.groups.zu.push(this.groups.tmp.join(" "));
                c.attr("checked", false)
            }
        }
        if (this.checks.length < a && this.checks.length >= d) {
            var b = $.clearArray(this.checks.concat(this.groups.tmp));
            if (b.length >= a) {
                this.checkboxs.each(function() {
                        if ($.inArray(this.value, b) == -1) {
                            this.disabled = "disabled"
                        }
                    }
                )
            } else {
                this.checkboxs.removeAttr("disabled")
            }
        }
    }
    this.checks = this.checks.sort(function(j, i) {
            return j - i
        }
    );
    this.showMsg()
}
;
Buzhong.prototype.showMsg = function() {
    var a = this.play_type == "fs" ? '球号：[<span class="red">' + this.checks.join(" ") + "</span>]" : '球号：[<span class="red">' + this.groups.zu.join('</span>],[<span class="red">') + "</span>]";
    $("#msg").html(a)
}
;
Buzhong.prototype.refersh = function(c) {
    for (var b in c) {
        if (c.hasOwnProperty(b)) {
            if (b == "odds") {
                for (var a in c.odds) {
                    if (c.odds.hasOwnProperty(a)) {
                        this.info.odds[a] = c.odds[a]
                    }
                }
            } else {
                if (b == "status") {
                    for (var a in c.status) {
                        if (c.status.hasOwnProperty(a)) {
                            this.info.status[a] = c.status[a];
                            if (a == this.play[this.pi]) {
                                this.curstop(c.status[a])
                            }
                        }
                    }
                }
            }
        }
    }
    $.refersh(c)
}
;
Buzhong.prototype.cometFresh = function(j, f) {
    var h = this;
    $.last_update.time_stamp = f;
    var b = function(i) {
            h.refersh(i)
        }
        ;
    for (var c in j) {
        if (j.hasOwnProperty(c)) {
            if (("1" == h.drawStatus || "2" == h.drawStatus) && c.indexOf("odds") === 0 && c.indexOf(h.odds_set) === 9) {
                var g = j[c];
                for (var a in g) {
                    if (g.hasOwnProperty(a)) {
                        h.info.odds[a] = g[a]
                    }
                }
                $.refersh_odds(g);
                continue
            }
            if ("drawStatus" == c) {
                if (h.drawStatus != j[c]) {
                    $.getJSON("/odds/getOdds?game_ids=" + h.all_game + "&odds_set=" + h.odds_set + "&time_stamp=0", b);
                    h.drawStatus = j[c]
                }
                if ("2" == j[c]) {
                    j[c] = 0
                } else {
                    j[c] = parseInt(j[c], 10)
                }
                h.curstop(j[c]);
                continue
            }
            if (c == "curstop") {
                for (var f in j[c]) {
                    if (j[c].hasOwnProperty(f)) {
                        if (h.info.status.hasOwnProperty(f)) {
                            h.info.status[f] = j[c][f]
                        }
                        if (f == h.play[h.pi]) {
                            h.curstop(j[c][f])
                        }
                    }
                }
            }
        }
    }
}
;
Buzhong.prototype.curstop = function(a) {
    if (this.status === a) {
        return
    }
    if (a && this.info.member_status != 2) {
        $("input").removeAttr("disabled").removeClass("dis").removeClass("bds");
        $.trigger("renderMul")
    } else {
        $("input").attr("disabled", "disabled");
        $(":text").addClass("dis");
        $(":submit, :reset").addClass("bds");
        this.checkboxs.attr("checked", false)
    }
    this.status = a
}
;
var domainOK=false;
var Header = function(a) {
        this.id = a;
        this.order_detail = "";
        this.user_info = global_info.user_info;
        this.plays_limit = global_info.limit;
        this.account = [];
        this.lock_link = {
            history: 0,
            result: 0,
            detail: 0
        };
        this.lock_submit = false;
        this.submit_cover = null ;
        this.ref_header_timmer = null ;
        this.fail_count = 0;
        this.oa = document.getElementById("order_agree");
        this.ac = document.getElementById("account");
        this.neworderli = document.getElementById("neworderli");
        this.sure = document.getElementById("sure");
        this.oc = document.getElementById("order_cencel");
        this.mark = document.getElementById("main").contentWindow;
        this.orderHeight = $("#neworderdiv").height();
        this.timeout = 0;
        this.tOrder = "";
        this.currGame = "";
        this.init();
        this.init_ok = true;
        if (cmset.cometAction) {
            setInterval(function() {
                    $.ajax({
                        url: "ajax_req.htm?act=keep_call"
                    })
                }
                , 1000 * 9 * 60)
        }
        $.initLog4js()
    }
    ;
Header.prototype.parseCookie = function() {
    var b = document.cookie.split(/;/)
        , a = $.map(b, function(g, f) {
            var d = g.replace(/\s/g, "").split("=");
            d[1] = d[1] || "";
            return '"' + d[0] + '":"' + unescape(d[1]) + '"'
        }
    )
        , c = $.parseJSON("{" + a.join(",") + "}");
    return c
}
;
Header.prototype.duplicateOrder = function(b) {
    var d = document.createElement("div")
        , a = document.createElement("div")
        , g = this
        , f = "成功";
    d.className = "duplicate";
    a.className = "mask";
    var c = function(n) {
            var k = n.fail.replace(/;/g, "; ")
                , j = k.length
                , o = ""
                , i = n.succ.replace(/;/g, "; ")
                , l = i.length
                , h = ""
                , m = i + "; " + k;
            if (k) {
                o = '<br/><span style="color:red">失败:</span>' + k;
                h = '其中<br/><span  style="color:red">成功:</span>' + i
            }
            m = m + "<br/>" + h + o;
            return m
        }
        ;
    if (b.fail) {
        f = ""
    }
    d.innerHTML = "您已在" + b.time + f + '{#|6295|6ce8#}了<p class="os">'.keyComment() + c(b) + '</p>是否继续？<br/>如果“继续”，所有球号将全部重复{#|6295|6ce8#}！<p class="btns"><input class="btn1" type="button" value="取消"/>&nbsp;&nbsp;<input class="btn2" type="button" value="确定"/></p>'.keyComment();
    document.body.appendChild(a);
    document.body.appendChild(d);
    $(d).click(function(i) {
            var h = i.target;
            if (h.className === "btn1") {
                g.oc.click();
                $(a).remove();
                $(d).remove();
                $.trigger("reset")
            }
            if (h.className === "btn2") {
                $(a).remove();
                $(d).remove();
                g.lock_submit = false;
                g.oa.disabled = false;
                g.dealTOrder("", "0")
            }
        }
    )
}
;
Header.prototype.dealTOrder = function(b, a) {
    var c = a ? a : 1;
    document.cookie = "timeout=" + escape(c);
    document.cookie = "tOrder=" + escape(b);
    this.timeout = parseInt(c, 10);
    this.tOrder = b
}
;
Header.prototype.init = function() {
    var d = this, g = $("#show_ip"), f = $("#diff_ip"), j = function() {
        clearTimeout(k);
        g.hide()
    }
        , k, i = this.parseCookie();
    this.set_order_height();
    this.registEvent();
    this.set_cover();
    this.init_cps_action();
    if (!i.showIp) {
        g.show();
        document.cookie = "showIP=" + escape("1") + ";path=/" + location.pathname.split("/")[1];
        $("#show_ip_close").click(j);
        k = setTimeout(j, 5000)
    }
    if (f.length) {
        var h = $("<iframe allowTransparency='true' class='diff_ip_shadow'></iframe>").appendTo("body");
        h.css("height", document.documentElement.scrollHeight + "px");
        f.show();
        $("button", f).click(function() {
                f.remove();
                h.remove()
            }
        );
        f.delegate("a", "click", function() {
                f.remove();
                h.remove()
            }
        )
    }
    if (i.timeout) {
        this.timeout = parseInt(i.timeout, 10);
        this.tOrder = i.tOrder
    }
    $.bind("showneworder", function(l, m) {
            d.show_new_order(m)
        }
    );
    var a = i.multiple;
    if (a) {
        var c = a.split("|");
        d.multiple = {
            isMultiple: Boolean(parseInt(c[0], 10)),
            multiple: c[1]
        }
    } else {
        d.multiple = {
            isMultiple: false,
            multiple: "hundred"
        }
    }
    d.lineSwitch();
    $("marquee[id='marquee']").bind("click", function() {
            d.notice_popup("list")
        }
    );
    var b = $("#show_ip").attr("popup");
    if (b == 1) {
        d.notice_popup("login")
    }
}
;
Header.prototype.init_cps_action = function() {
    var f = this;
    $.bind("log", function(j, h, i) {
            if (!$.cps_connect_log || !h || !i) {
                return
            }
            $.get("ajax_req.htm?act=savelog&l=" + i + "&m=" + encodeURIComponent(h))
        }
    );
    $.bind("changelimit", function(i, h) {
            f.change_limit(h)
        }
    );
    $.bind("getinit", function() {
            $.trigger("init", [f.user_info.odds_set, cmset.cometAction, cmset.drawStatus, cmset.status])
        }
    );
    var b = $(".ct>div", "#outer_logo")[0];
    var a = 0;
    var d = function(i) {
            if ((1 === i && a > 0) || -2 === a) {
                return
            }
            switch (i) {
                case -2:
                    b.className = "";
                    b.title = "您的账户已经{#|505c|62bc#}，不可以{#|6295|6ce8#}".keyComment();
                    $.trigger("toajax", [0]);
                    break;
                case -1:
                    b.className = "";
                    b.title = "无法自动获取最新{#|8d54|7387#}，请手动刷新".keyComment();
                    break;
                case 0:
                    b.className = "";
                    b.title = "无法自动获取最新{#|8d54|7387#}，转AJAX".keyComment();
                    var h = setTimeout(function() {
                            h = null ;
                            $.trigger("toajax", [1]);
                            d(1)
                        }
                        , $.getRound(5, 25));
                    break;
                case 1:
                    b.className = "a";
                    b.title = "Ajax方式刷新";
                    break;
                case 2:
                    b.className = "b";
                    b.title = "长轮询（long-polling）方式刷新";
                    $.trigger("toajax", [0]);
                    break;
                case 3:
                    b.className = "c";
                    b.title = "流（streaming）方式刷新";
                    $.trigger("toajax", [0]);
                    break
            }
            a = i
        }
        ;
    if (2 === cmset.status) {
        d(-2)
    }
    $.bind("toajax.header", function(h, i) {}
    );
    $.bind("ajaxconnect", function(h, i) {
            switch (i) {
                case 0:
                    d(1);
                    break;
                case -1:
                    d(-1);
                    break
            }
        }
    );
    if (0 === domainOK) {
        $.trigger("log", ["Set domain fail.", 0])
    }
    if (cmset.cometAction) {
        $.bind("changechannel", function(j, i, h) {
                if (1 !== cmset.status) {
                    d(-2);
                    return
                }
                if (1 === a || 0 === a) {
                    $.trigger("toajax", [1])
                }
                i = (i && $.channel[i]) ? $.channel.common + "|" + $.channel[i] : $.channel.common;
                h = h || 0;
                if (cmset.token) {
                    cm.run({
                        url: cmset.cometUrl,
                        token: cmset.token,
                        asname: cmset.asname,
                        timestamp: h,
                        channel: i,
                        domain: domain
                    })
                } else {
                    d(0)
                }
            }
        );
        $.bind("cpsconnect", function(h, i) {
                switch (i) {
                    case 0:
                    case 1:
                        d(3);
                        break;
                    case 2:
                        d(2);
                        break;
                    case -2:
                        d(0);
                        break
                }
                $.trigger("log", ["cpsconnect: " + i, 1])
            }
        )
    }
    $.trigger("init", [f.user_info.odds_set, cmset.cometAction, cmset.drawStatus, cmset.status]);
    var g = document.getElementById("marquee");
    var c = document.getElementById("draws");
    $.bind("cpsdata.header", function(h, i) {
            if (i.frontMarquee) {
                alert(i);
                g.innerHTML = "<a href='#' marquee='1' >" + i.frontMarquee + "</a>"
            }
            if (i.drawDate !== undefined) {
                c.innerHTML = i.drawDate
            }
            if ("0" == cmset.drawStatus && i.drawStatus == "1") {
                f.get_header_info()
            }
            if (i.calcstatus !== undefined) {
                $.show_calc_status(i.calcstatus)
            }
            if (i.drawStatus) {
                if ("1" == i.drawStatus && "0" == cmset.drawStatus) {
                    setTimeout(function() {
                            $.trigger("reset")
                        }
                        , 0)
                }
                cmset.drawStatus = i.drawStatus
            }
        }
    );
    $(window).unload(function() {
            $.unbind(".header")
        }
    )
}
;
Header.prototype.set_order_height = function() {
    var b;
    if ($(this.sure).css("display") == "none") {
        try {
            b = (document.documentElement.clientHeight || document.body.clientHeight) - $("#neworderdiv").offset().top
        } catch (c) {}
        b = (b > 0 && b < this.orderHeight) ? b : this.orderHeight;
        if (b > 0) {}
    } else {
        try {
            b = (document.documentElement.clientHeight || document.body.clientHeight) - $("#sure_list").offset().top - 50
        } catch (a) {}
        if (b > 0) {
            document.getElementById("sure_list").style.height = b + "px"
        }
    }
}
;
Header.prototype.set_cover = function() {
    var a = this;
    this.submit_cover = new Cover("#fff",0.3,4);
    this.submit_cover.setStr("{#|6ce8|5355#}处理中，请不要刷新页面...<span class='alarmLimit'></span><span class='loadding2'/>".keyComment());
    this.submit_cover.setAlarm($.submit_expire, "由于网络或服务器忙，{#|6ce8|5355#}处理超过".keyComment() + $.submit_expire / 1000 + "秒，请到{#|4e0b|6ce8#}明细页确认是否{#|4e0b|6ce8#}成功。".keyComment());
    this.submit_cover.setHideTrigger(function() {
            a.show_orders("order_refersh");
            a.get_header_info()
        }
    )
}
;
Header.prototype.show_orders = function(a) {
    if ("order_confirm" == a) {
        this.ac.parentNode.style.display = "none";
        this.neworderli.style.display = "none";
        var d = this.sure.getElementsByTagName("ul")[0];
        d.style.height = "auto";
        this.sure.style.display = "block";
        var c;
        try {
            c = (document.documentElement.clientHeight || document.body.clientHeight) - $(d).offset().top - 44
        } catch (f) {}
        var b = $(d).height();
        if (c < b && c > 0) {
            d.style.height = c + "px"
        }
    } else {
        if ("order_list" == a) {
            this.sure.style.display = "none";
            this.ac.parentNode.style.display = "block";
            this.neworderli.style.display = "block";
            document.getElementById("fail_count").innerHTML = this.fail_count;
            this.submit_cover.hide()
        } else {
            if ("order_refersh" == a) {
                this.sure.style.display = "none";
                this.ac.parentNode.style.display = "block";
                this.neworderli.style.display = "block";
                document.getElementById("fail_count").innerHTML = this.fail_count
            } else {
                if ("hidden_all" == a) {
                    this.sure.style.display = "none";
                    this.ac.parentNode.style.display = "none";
                    this.neworderli.style.display = "none"
                }
            }
        }
    }
}
;
Header.prototype.show_new_order = function(d) {
    var m = this;
    if (!d.order.length) {
        return
    }
    this.new_orders = d.order;
    var o = d.footer ? d.footer : "";
    var j = [];
    var k = 0;
    var n = "";
    var h;
    var l;
    var g;
    var c = {};
    if (d.gameId === "lianma" || d.gameId === "buzhong" || d.gameId === "shengxiaolian" || d.gameId === "weishulian") {
        g = d.order[0];
        var b = new RegExp(" ","g");
        h = g.key.substring(0, 3);
        for (l = 0; l < o.length; l++) {
            var f = o[l].replace(b, ",");
            j.push(h + "|" + f + "|0|" + g.amount);
            c[h + f] = this.vaild_order(h, g.amount)
        }
        k = g.amount * o.length;
        n = h
    } else {
        if (d.gameId === "guoguan") {
            g = d.order[0];
            h = $.cfg_play_keys[d.gameId];
            j.push(h + "|" + g.games + "|" + g.odds + "|" + g.amount);
            k = g.amount;
            n = h;
            c[h + g.games] = this.vaild_order(h, g.amount)
        } else {
            for (l = 0; l < d.order.length; l++) {
                g = d.order[l];
                h = g.key.substring(0, 3);
                j.push(h + "|" + g.key.substr(3) + "|0|" + g.amount);
                k = k + parseInt(d.order[l].amount, 10);
                if (n.indexOf("," + h + ",") == -1) {
                    n += h + ","
                }
                c[h + g.key.substr(3)] = this.vaild_order(h, g.amount)
            }
        }
    }
    var a = j.join(";");
    var p = {
        credit_error: "",
        item_error: c
    };
    if (k > parseInt(this.account[6].innerHTML, 10)) {
        p.credit_error = "超过可用{#|4fe1|7528|4f59|989d#}".keyComment()
    }
    if (n == "" || k == 0 || a == "") {
        alert("{#|4e0b|6ce8#}参数不正确，请重新提交！".keyComment());
        return
    }
    if (d.gameId == "lianma" || d.gameId == "buzhong" || d.gameId === "shengxiaolian" || d.gameId === "weishulian") {
        m.show_mount_order(p, d)
    } else {
        m.show_single_order(p, d)
    }
}
;
Header.prototype.vaild_order = function(c, b) {
    var a = this.plays_limit[$.game_category[c]];
    var d = "";
    b = parseInt(b, 10);
    if (b < parseInt(a[0], 10)) {
        d = "小于{#|5355|6ce8#}最低金额".keyComment() + parseInt(a[0], 10) + ";"
    } else {
        if (b > parseInt(a[1], 10)) {
            d = "大于{#|5355|6ce8#}最高金额".keyComment() + parseInt(a[1], 10) + ";"
        }
    }
    return d
}
;
Header.prototype.show_single_order = function(f, a) {
    var g = this;
    var c = 0, d;
    var k = a.game || "";
    var b = a.header || "";
    var l = a.footer || "";
    var h = "";
    for (d = 0; d < a.order.length; d++) {
        if (f.item_error[a.order[d].key] !== "") {
            c++
        }
        k = k == "{#|6b63|7801#}".keyComment() && !parseInt(a.order[d].no, 10) ? "" : k;
        h += "<li><span>" + k + " " + a.order[d].no + "</span> <em>" + a.order[d].amount + "</em> X <span>" + a.order[d].odds + '</span>  <span class="red">' + f.item_error[a.order[d].key] + "</span></li>"
    }
    g.calc_sure_act(c);
    $("#sure_list").html(b + h + l);
    g.order_detail = a;
    g.show_orders("order_confirm")
}
;
Header.prototype.show_mount_order = function(k, b) {
    var l = this;
    var g = 0;
    var p = b.game ? b.game : "";
    var f = b.header ? b.header : "";
    var q = b.footer ? b.footer : "";
    var m = "";
    var d = b.order[0];
    var c = d.key.substring(0, 3);
    $("#sure_list").html(m);
    m += "<li><span>" + p + " " + b.order[0].no + "</span>  <em>" + b.order[0].amount + "(" + q.length + ")</em> X <span>" + b.order[0].odds + "</span></li>";
    var a = new RegExp(" ","g");
    var n = "";
    for (var h = 0; h < q.length; h++) {
        var o = c + q[h].replace(a, ",");
        if (k.item_error[o] !== "") {
            g++
        }
        switch (b.gameId) {
            case "shengxiaolian":
            case "lianma":
            case "weishulian":
            case "buzhong":
                n = b.order[0].assemble_odd[q[h]].split("|");
                n = " X " + n[0];
                m += "<li><span>[" + b.order[0].show_arr[h] + "]" + n + '</span><span class="red">' + k.item_error[o] + "</span></li>";
                break;
            default:
                m += "<li><span>[" + q[h] + "]" + n + '</span><span class="red">' + k.item_error[o] + "</span></li>";
                break
        }
    }
    l.calc_sure_act(g);
    q = "";
    $("#sure_list").html(f + m + q);
    l.order_detail = b;
    l.show_orders("order_confirm")
}
;
Header.prototype.calc_sure_act = function(b) {
    var a = this;
    if (b > 0) {
        a.oa.disabled = true;
        setTimeout(function() {
                try {
                    a.oc.focus()
                } catch (c) {}
            }
            , 0)
    } else {
        a.oa.disabled = false;
        setTimeout(function() {
                try {
                    a.oa.focus()
                } catch (c) {}
            }
            , 0)
    }
}
;
Header.prototype.submit_order = function() {
    if (this.lock_submit) {
        return
    }
    this.lock_submit = true;
    var g = this;
    setTimeout(function() {
            g.lock_submit = false
        }
        , 1000);
    var q = [];
    var h = 0;
    var f = ",";
    var k = "";
    var l;
    var o;
    var n = [];
    switch (this.order_detail.gameId) {
        case "tema":
        case "zhengma":
        case "zhengmate1":
        case "zhengmate2":
        case "zhengmate3":
        case "zhengmate4":
        case "zhengmate5":
        case "zhengmate6":
        case "zhengma1to6":
            for (o = 0; o < this.new_orders.length; o++) {
                l = this.new_orders[o];
                h = h + parseInt(l.amount, 10);
                if (f.indexOf("," + l.key.substr(0, 3) + ",") == -1) {
                    f += l.key.substr(0, 3) + ","
                }
                q.push(l.key.substr(0, 3) + "|" + l.key.substr(3) + "|" + l.odds + "|" + l.amount);
                n.push(l.key.substr(0, 3) + "|" + l.key.substr(3) + "|" + l.amount)
            }
            if (f.length > 1) {
                f = f.substring(1, f.length - 1)
            }
            break;
        case "weishu":
        case "banbo":
        case "texiao":
        case "liuxiao":
        case "shengxiao":
        case "shengxiaobuzhong":
            for (o = 0; o < this.new_orders.length; o++) {
                l = this.new_orders[o];
                h = h + parseInt(l.amount, 10);
                f = l.key.substr(0, 3);
                q.push(f + "|" + l.key.substr(3) + "|" + l.odds + "|" + l.amount);
                n.push(f + "|" + l.key.substr(3) + "|" + l.amount)
            }
            break;
        case "guoguan":
            l = this.new_orders[0];
            f = $.cfg_play_keys[this.order_detail.gameId];
            h = l.amount;
            q.push(f + "|" + l.games + "|" + l.odds + "|" + l.amount);
            n.push(f + "|" + l.games + "|" + l.amount);
            k = l.detail;
            break;
        case "buzhong":
        case "shengxiaolian":
        case "weishulian":
            l = this.new_orders[0];
            f = l.key;
            h = l.amount * (this.order_detail.footer.length);
            q.push(f + "|" + l.nos + "|" + l.odds + "|" + l.amount + "|" + l.ordertype);
            n.push(f + "|" + l.nos + "|" + l.amount + "|" + l.ordertype);
            var p = [];
            var b = new RegExp(" ","g");
            for (var r in l.assemble_odd) {
                if (l.assemble_odd.hasOwnProperty(r)) {
                    p.push(r.replace(b, ",") + "|" + l.assemble_odd[r])
                }
            }
            k = p.join(";");
            break;
        case "lianma":
            l = this.new_orders[0];
            var t = l.key.substring(0, 3);
            var v = this.order_detail.footer ? this.order_detail.footer : "";
            var p = [];
            var b = new RegExp(" ","g");
            for (var r in l.assemble_odd) {
                if (l.assemble_odd.hasOwnProperty(r)) {
                    p.push(r.replace(b, ",") + "|" + l.assemble_odd[r])
                }
            }
            k = p.join(";");
            h = l.amount * v.length;
            q.push(t + "|" + l.nos + "|" + l.odds + "|" + l.amount + "|" + l.ordertype);
            n.push(t + "|" + l.nos + "|" + l.amount + "|" + l.ordertype);
            f = t;
            break;
        default:
            break
    }
    var c = q.join(";")
        , m = n.join(";");
    var s = this.order_detail.odds_set;
    var u = new Date();
    var d = u.getTime();
    var a = 0;
    if (g.timeout === 1 && (m) === g.tOrder) {
        a = 1
    } else {
        g.dealTOrder("", "0")
    }
    var j = function() {
            if (global_version_num == undefined) {
                g.referVersionNumber();
                return
            }
            return $.ajax({
                url: "/order/saveOrder",
                type: "POST",
                cache:false,
                data: "game_ids=" + f + "&order_allamount=" + h + "&odds_set=" + s + "&orderData=" + c + "&detailOdds=" + k + "&timeout=" + a + "&submit_time_msec=" + d + "&version_number=" + global_version_num,
                dataType: "json",
                success: function(i) {
                    g.lock_submit = false;
                    g.submit_cover.hide();
                    g.responses(i, m)
                },
                complete: function(w, i) {
                    g.lock_submit = false;
                    g.submit_cover.hide();
                    if (i == "timeout") {
                        g.timeout = 1;
                        g.dealTOrder(m, 1);
                        if (!g.submit_cover.isAlert) {
                            alert("请求超时")
                        }
                        $(g.oc).click()
                    }
                    if (i != "success" && i != "timeout") {
                        if (!g.submit_cover.isAlert) {
                            alert("由于网络故障，本次处理异常，请到{#|4e0b|6ce8#}明细中确认{#|6ce8|5355#}.".keyComment())
                        }
                        g.show_orders("order_refersh");
                        g.get_header_info()
                    }
                }
            })
        }
        ;
    return j()
}
;
Header.prototype.log = function(a, b) {
    if ((/shengxiaolian|weishulian|tema/).test(a)) {
        $.log4js(b)
    }
}
;
Header.prototype.analysis_order = function(s) {
    var u = [];
    var x = s.split(";");
    var n = x[1].substr(2);
    var E = this.order_detail.game;
    var A, w, z, C, t, f;
    if (n == "1") {
        for (A = 0; A < this.new_orders.length; A++) {
            w = this.new_orders[A];
            E = E == "{#|6b63|7801#}".keyComment() && !parseInt(w.no, 10) ? "" : E;
            switch (this.order_detail.gameId) {
                case "lianma":
                    t = w.no.split(" ");
                    u.push("<li><span>" + t[0] + " " + w.show_char + "</span> " + w.amount * this.order_detail.footer.length + " X <em>" + w.odds + "</em></li>");
                    break;
                case "liuxiao":
                    u.push("<li><span>" + E + w.no + " " + w.show_str + "</span> " + w.amount + " X <em>" + w.odds + "</em></li>");
                    break;
                case "weishulian":
                case "shengxiaolian":
                    u.push("<li><span>" + E + w.no + "</span> " + w.amount * this.order_detail.footer.length + " X <em>" + w.odds + "</em></li>");
                    break;
                case "buzhong":
                    u.push("<li><span>" + E + w.no + " " + w.nos + "</span> " + w.amount * this.order_detail.footer.length + " X <em>" + w.odds + "</em></li>");
                    break;
                case "guoguan":
                    u.push("<li><span>" + E + " " + w.show_str.replace("码", "") + "</span> " + w.amount + " X <em>" + w.odds + "</em></li>");
                    break;
                case "zhengma1to6":
                    f = w.no.replace("{#|6b63|4e00#}".keyComment(), "{#|7279#}1{#|7279#}".keyComment());
                    f = f.replace("{#|6b63|4e8c#}".keyComment(), "{#|7279#}2{#|7279#}".keyComment());
                    f = f.replace("{#|6b63|4e09#}".keyComment(), "{#|7279#}3{#|7279#}".keyComment());
                    f = f.replace("{#|6b63|56db#}".keyComment(), "{#|7279#}4{#|7279#}".keyComment());
                    f = f.replace("{#|6b63|4e94#}".keyComment(), "{#|7279#}5{#|7279#}".keyComment());
                    f = f.replace("{#|6b63|516d#}".keyComment(), "{#|7279#}6{#|7279#}".keyComment());
                    u.push("<li><span>" + f + "</span> " + w.amount + " X <em>" + w.odds + "</em></li>");
                    break;
                default:
                    u.push("<li><span>" + E + " " + w.no + "</span> " + w.amount + " X <em>" + w.odds + "</em></li>");
                    break
            }
        }
    } else {
        var p = x[0].substr(2);
        var l = x[2].substr(2);
        var k = x[3].substr(2);
        var h = x[4].substr(2);
        var g = x[5].substr(2);
        var d = "";
        var c = "";
        var b = "";
        var a = "";
        var H = "";
        var F = "";
        var o = [];
        var G = "";
        var D = "";
        var r = [];
        for (A = 0; A < this.new_orders.length; A++) {
            w = this.new_orders[A];
            G = w.key.substr(0, 3) + "#" + w.key.substr(3);
            D = w.key.substr(0, 3) + "," + w.key.substr(3);
            if (h.indexOf(G) != -1) {
                H += w.no + ","
            }
            if (w.key.substr(0, 3) == "013") {
                r = w.key.substr(3).split(",");
                for (z = 0; z < r.length; z++) {
                    C = "013#" + r[z];
                    if (g.indexOf(C) != -1) {
                        o.push(w)
                    }
                }
            } else {
                if (g.indexOf(G) != -1) {
                    o.push(w)
                }
            }
            if (n.indexOf(D) != -1) {
                c += w.no + "|" + w.amount + ",";
                switch (this.order_detail.gameId) {
                    case "lianma":
                        t = w.no.split(" ");
                        u.push("<li><span>" + t[0] + " " + w.show_char + "</span> " + w.amount * this.order_detail.footer.length + " X <em>" + w.odds + "</em></li>");
                        break;
                    case "liuxiao":
                        u.push("<li><span>" + E + w.no + " " + w.show_str + "</span> " + w.amount + " X <em>" + w.odds + "</em></li>");
                        break;
                    case "weishulian":
                    case "shengxiaolian":
                        u.push("<li><span>" + E + w.no + "</span> " + w.amount * this.order_detail.footer.length + " X <em>" + w.odds + "</em></li>");
                        break;
                    case "buzhong":
                        u.push("<li><span>" + E + w.no + " " + w.nos + "</span> " + w.amount * this.order_detail.footer.length + " X <em>" + w.odds + "</em></li>");
                        break;
                    case "guoguan":
                        u.push("<li><span>" + E + " " + w.show_str.replace("码", "") + "</span> " + w.amount + " X <em>" + w.odds + "</em></li>");
                        break;
                    case "zhengma1to6":
                        f = w.no.replace("{#|6b63|4e00#}".keyComment(), "{#|7279#}1{#|7279#}".keyComment());
                        f = f.replace("{#|6b63|4e8c#}".keyComment(), "{#|7279#}2{#|7279#}".keyComment());
                        f = f.replace("{#|6b63|4e09#}".keyComment(), "{#|7279#}3{#|7279#}".keyComment());
                        f = f.replace("{#|6b63|56db#}".keyComment(), "{#|7279#}4{#|7279#}".keyComment());
                        f = f.replace("{#|6b63|4e94#}".keyComment(), "{#|7279#}5{#|7279#}".keyComment());
                        f = f.replace("{#|6b63|516d#}".keyComment(), "{#|7279#}6{#|7279#}".keyComment());
                        u.push("<li><span>" + f + "</span> " + w.amount + " X <em>" + w.odds + "</em></li>");
                        break;
                    default:
                        if (E == "{#|5c3e|6570#}".keyComment()) {
                            w.no = w.no.replace(/,.*!/, "").replace(/\d(\d)/, "$1") + "尾"
                        }
                        u.push("<li><span>" + E + " " + w.no + "</span> " + w.amount + " X <em>" + w.odds + "</em></li>");
                        break
                }
                continue
            } else {
                if (p.indexOf(G) != -1) {
                    d += w.no + ",";
                    continue
                } else {
                    if (l == 1) {
                        if (s.indexOf(G) == -1) {
                            b += w.no + ","
                        }
                        continue
                    } else {
                        if (k == 1) {
                            if (s.indexOf(G) == -1) {
                                a += w.no + ","
                            }
                            continue
                        }
                    }
                }
            }
        }
        var y = "";
        if (c !== "") {
            c = c.substr(0, c.length - 1);
            y += "部分" + this.order_detail.game + "成功{#|6ce8|5355#}：" + c + ";"
        }
        if (H !== "") {
            H = H.substr(0, H.length - 1);
            if ("guoguan" == this.order_detail.gameId) {
                y += "{#|6ce8|5355#}失败原因：" + this.order_detail.game + "{#|505c|62bc#}"
            } else {
                if ("tema" == this.order_detail.gameId) {
                    h = h.replace(/#\d+@/g, "|");
                    if (h.indexOf("000|") == -1) {
                        this.order_detail.game = "{#|7279|7801#}{#|4e24|9762#}".keyComment()
                    }
                }
                if (c == "") {
                    y += "{#|6ce8|5355#}失败原因：" + this.order_detail.game + "{#|505c|62bc#}"
                } else {
                    y += "{#|6ce8|5355#}失败原因：" + this.order_detail.game + "{#|505c|62bc#},失败号码：" + H + ";"
                }
            }
            this.show_orders("order_list")
        }
        var v = [];
        if (g !== "") {
            var m = g.split("@");
            var B = [];
            for (z = 0; z < m.length - 1; z++) {
                B = m[z].split("#");
                F += o[z].no + "|" + B[2] + "|" + B[3] + ",";
                o[z].odds = B[3];
                v.push(o[z])
            }
            F = F.substr(0, F.length - 1);
            var q = new RegExp("<br/>","g");
            F = F.replace(q, " ");
            y += "{#|6ce8|5355#}失败原因：" + this.order_detail.game + "{#|8d54|7387#}不一致,详情：" + F + ";"
        }
        if (d !== "") {
            d = d.substr(0, d.length - 1);
            y += "其它异常失败{#|6ce8|5355#}：" + d + ";"
        }
        if (b !== "") {
            b = b.substr(0, b.length - 1);
            if (c == "") {
                y += "用户状态无效"
            } else {
                y += "用户状态无效， 失败{#|6ce8|5355#}：" + b
            }
        }
        if (a !== "") {
            a = a.substr(0, a.length - 1);
            if (c == "") {
                y += "未{#|5f00|76d8#}，{#|4e0b|6ce8#}失败！"
            } else {
                y += "未{#|5f00|76d8#}失败{#|6ce8|5355#}：" + a
            }
        }
        if (y !== "") {
            alert(y.keyComment())
        } else {
            alert("{#|4e0b|6ce8#}失败".keyComment())
        }
        if (o.length !== 0) {
            if ((/^(weishulian|shengxiaolian|buzhong|lianma|guoguan)$/).test(this.order_detail.gameId)) {
                $.trigger("resubmit")
            } else {
                this.show_new_order({
                    gameId: this.order_detail.gameId,
                    order: o,
                    game: this.order_detail.game,
                    odds_set: this.order_detail.odds_set,
                    footer: this.order_detail.footer
                })
            }
        } else {
            if (H == "") {
                $.trigger("reset")
            }
        }
    }
    if (u !== "") {
        this.inner_new_order(u.reverse().join(""))
    }
}
;
Header.prototype.inner_new_order = function(a) {
    document.getElementById("new_orders").innerHTML = a + document.getElementById("new_orders").innerHTML;
    $("#neworderli").find("ul>li:gt(9)").remove()
}
;
Header.prototype.responses = function(f, b) {
    var g = this;
    if (g.isTimeOut) {
        g.isTimeOut = false;
        g.dealTOrder(b, 1);
        alert("由于网络异常，{#|4e0b|6ce8#}超时，请到{#|4e0b|6ce8#}明细中确认{#|6ce8|5355#}！".keyComment());
        return
    }
    this.order_detail.oddschg = f.oddschg;
    var h = f.return_str;
    var c = (h + "").split(";");
    var j = "";
    var l = "";
    this.refershOdds();
    if (undefined != f.versionNumber) {
        global_version_num = parseInt(f.versionNumber, 10)
    }
    if (typeof (f.fail_count) != "undefined") {
        g.fail_count = parseInt(f.fail_count, 10)
    }
    if (parseInt(h, 10) == -1000) {
        j = "为避免误操作，5秒内禁下重复{#|6ce8|5355#}！".keyComment()
    } else {
        if (parseInt(h, 10) == -9999) {
            g.duplicateOrder(f.duplicate_data);
            return
        } else {
            if (parseInt(h, 10) == -1124) {
                alert(f.credit_error);
                g.referVersionNumber()
            } else {
                if (parseInt(h, 10) < -1000) {
                    if (f.credit_error !== "") {
                        alert(f.credit_error)
                    } else {
                        var k = "";
                        if ((/lianma|shengxiaolian|weishulian|buzhong|guoguan/).test(this.order_detail.gameId)) {
                            k = "{#|5355|6ce8#}或者{#|5355|9879#}限制引起{#|4e0b|6ce8#}失败".keyComment()
                        } else {
                            for (var d = 0; d < this.new_orders.length; d++) {
                                var a = this.new_orders[d];
                                k += this.order_detail.game + " " + a.no + " " + a.odds + " X " + a.amount;
                                if (!f.item_error[a.key]) {
                                    k += "(成功)\r\n";
                                    this.order_detail.game == "{#|5c3e|6570#}".keyComment() ? a.no = a.no.replace(/,.*/, "").replace(/\d(\d)/, "$1") + "尾" : "";
                                    l += "<li><span>" + this.order_detail.game + " " + a.no + "</span> " + a.amount + " X <em>" + a.odds + "</em></li>"
                                } else {
                                    k += "(错误：" + f.item_error[a.key] + ")\r\n"
                                }
                            }
                        }
                        j = k;
                        if (l != "") {
                            this.inner_new_order(l)
                        }
                        this.set_limit(f)
                    }
                } else {
                    if (c.length !== 12) {
                        j = "{#|4e0b|6ce8#}失败".keyComment()
                    } else {
                        this.user_info.credit = parseInt(f.credit, 10);
                        this.user_info.sum = parseInt(f.sum, 10);
                        this.account[4].innerHTML = this.user_info.credit;
                        this.account[5].innerHTML = this.user_info.sum;
                        this.account[6].innerHTML = this.user_info.credit - this.user_info.sum;
                        this.analysis_order(h);
                        if (c[1].substr(2) == "1") {
                            j = "{#|4e0b|6ce8#}成功".keyComment();
                            $.trigger("reset");
                            g.dealTOrder("", "0")
                        } else {
                            return
                        }
                    }
                }
            }
        }
    }
    this.show_orders("order_list");
    if (j != "" && !this.submit_cover.isAlert) {
        alert(j)
    }
}
;
Header.prototype.referVersionNumber = function() {
    var a = this;
    $.ajax({
        url: "ajax_req.htm",
        type: "POST",
        async: false,
        data: "act=refer_version_number",
        dataType: "json",
        success: function(b) {
            if (b == undefined) {
                if (!a.hasOwnProperty("countVersionNumber")) {
                    a.countVersionNumber = 0
                }
                a.countVersionNumber++;
                if (a.countVersionNumber > 5) {
                    alert("系统获取序列号失败，请刷新页面");
                    return
                }
                a.referVersionNumber();
                return
            }
            global_version_num = b;
            delete a.countVersionNumber;
            alert("系统已经重新取得序列号，请重新{#|4e0b|6ce8#}！".keyComment())
        }
    })
}
;
Header.prototype.refershOdds = function() {
    var a = this.order_detail.oddschg;
    if (a) {
        if (this.order_detail.gameId == "buzhong" || this.order_detail.gameId == "lianma") {
            this.mark.play.refersh(a)
        } else {
            this.mark.$.refersh(a)
        }
    }
}
;
Header.prototype.registEvent = function() {
    var a = this;
    $("#account td").each(function(c) {
            if (c % 2 == 1) {
                a.account.push(this)
            }
        }
    );
    a.fail_count = document.getElementById("fail_count").innerHTML;
    $(a.oc).click(function() {
            a.show_orders("order_list");
            $("#neworder_refresh").click();
            return false
        }
    );
    $(a.oa).click(function(d) {
            var c = d.target, f;
            if (c.disabled) {
                return false
            }
            c.disabled = true;
            f = a.submit_order();
            a.submit_cover.show(function() {
                    a.isTimeOut = true;
                    f.abort()
                }
            )
        }
    );
    var b = $("#product_menu");
    b.click(function(d) {
            var c = d.target;
            if (c.tagName == "SPAN" && c.parentNode.tagName == "A") {
                c = c.parentNode
            }
            if ("A" != c.tagName) {
                return
            }
            if ($(a.sure).css("display") == "block") {
                if (!confirm("您还有订单等待确认，放弃未确认的订单？")) {
                    return false
                }
            }
            if (c.tagName == "A" && c.target == "main") {
                var f = document.getElementById("main");
                f.src = "about:blank";
                try {
                    f.contentWindow.document.body.innerHTML = "";
                    f.contentWindow.document.clear()
                } catch (d) {}
                if ("CollectGarbage" in window) {
                    CollectGarbage()
                }
            }
            $("a", b).removeClass("on");
            $(c).addClass("on");
            a.show_orders("order_list");
            $("#yui-main").find(".yui-b").removeClass("g-w");
            $("#header_link a").removeClass("on")
        }
    );
    $("[name=logout]").click(function() {
            if (!confirm("您确定要退出吗?")) {
                return false
            }
        }
    );
    $("#header_link").click(function(h) {
            var f = h.target;
            if ("A" != f.tagName) {
                return
            }
            var d = f.getAttribute("name");
            if ($(a.sure).css("display") == "block") {
                if (!confirm("您还有订单等待确认，放弃未确认的订单？")) {
                    return false
                }
            }
            if (d == "result" || d == "history" || d == "detail") {
                var g = new Date();
                g = g.getTime();
                var c = 10 - parseInt((g - a.lock_link[d]) / 1000, 10);
                if (c > 0) {
                    alert("您的请求过于频繁，请在" + c + "秒后再查看。");
                    return false
                }
                a.lock_link[d] = g;
                this.setAttribute("hr", $(f).attr("href").replace(".htm", ""))
            }
            $("#product_menu a").removeClass("on");
            if (d == "role") {} else {}
            $("a", this).removeClass("on");
            $(f).addClass("on")
        }
    );
    $(".sys-btn").click(function() {
            if ($(a.sure).css("display") == "block") {
                if (!confirm("您还有订单等待确认，放弃未确认的订单？")) {
                    return false
                }
            }
        }
    );
    $("#neworder_refresh").click(function(c) {
            document.getElementById("new_orders").innerHTML = "<div class='cover_order'><span class='loadding_order'>请稍候...</span></div>";
            $("#account_info table").hide();
            if (!$("#account_info").has(".cover_order").get(0)) {
                $("#account_info").append("<div class='cover_order'><span class='loadding_order'>请稍候...</span></div>")
            }
            a.get_header_info()
        }
    );
    $(window).resize(function() {
            a.set_order_height()
        }
    );
    $.bind("multiple", function(f, c) {
            a.multiple = c;
            var d = "multiple=";
            if (c.isMultiple) {
                document.cookie = d + escape("1|" + c.multiple) + ";path=/"
            } else {
                document.cookie = d + escape("0|" + c.multiple) + ";path=/"
            }
        }
    )
}
;
Header.prototype.change_limit = function(a) {
    this.currGame = a || this.currGame;
    if (!this.plays_limit[$.cfg_category_key[this.currGame]]) {
        return
    }
    this.account[1].innerHTML = parseInt(this.plays_limit[$.cfg_category_key[this.currGame]][0], 10);
    this.account[2].innerHTML = parseInt(this.plays_limit[$.cfg_category_key[this.currGame]][1], 10);
    this.account[3].innerHTML = parseInt(this.plays_limit[$.cfg_category_key[this.currGame]][2], 10)
}
;
Header.prototype.refersh_sum_amount = function(b) {
    var a = parseInt(b, 10) + (!this.account[5].innerHTML ? "" : parseInt(this.account[5].innerHTML, 10));
    this.user_info.sum = a;
    this.account[5].innerHTML = a;
    this.account[6].innerHTML = parseInt(this.user_info.credit - a, 10)
}
;
Header.prototype.get_header_info = function() {
    var b = this;
    var a = function() {
            $.ajax({
                url: "ajax_req.htm?act=get_header_info|refer_version_number",
                dataType: "json",
                success: function(c) {
                    if (c.refer_version_number !== undefined) {
                        global_version_num = c.refer_version_number
                    }
                    b.set_header_info($.parseJSON(c.get_header_info));
                    b.ref_header_timmer = null
                },
                complete: function(d, c) {
                    if (c != "success") {
                        b.ref_header_timmer = setTimeout(a, 5000)
                    }
                }
            })
        }
        ;
    a()
}
;
Header.prototype.set_header_info = function(d) {
    if (!d) {
        return
    }
    $("#draws").text(d.draws);
    $("#account_info .cover_order").remove();
    $("#account_info table").show();
    $("#marquee").html("<a href='#' marquee='1' >" + d.marquee + "</a>");
    this.user_info.credit = d.credit;
    this.account[4].innerHTML = this.user_info.credit;
    this.account[5].innerHTML = "";
    this.refersh_sum_amount(d.sum);
    this.fail_count = d.fail_count;
    var a = d.new_order;
    var c = "";
    for (var b = 0; b < a.length; b++) {
        c += "<li><span>" + a[b][0] + "</span> " + a[b][1] + " X <em>" + a[b][2] + "</em></li>"
    }
    document.getElementById("new_orders").innerHTML = c;
    str = "<span class='fail_order_span'>失败{#|6ce8|5355#}</span>".keyComment();
    str += "<a class='fail_order_count' id='fail_count' href='order/fail_list.htm' target='main'>" + this.fail_count + "</a>";
    document.getElementById("failorderdiv").innerHTML = str;
    $.show_calc_status(d.calc_status);
    this.set_limit(d);
    if (d.lines) {
        global_lines = d.lines
    }
}
;
Header.prototype.set_limit = function(b) {
    if (b.hasOwnProperty("limit") && b.limit) {
        for (var a in b.limit) {
            if (this.plays_limit.hasOwnProperty(a)) {
                this.plays_limit[a] = b.limit[a]
            }
        }
        this.change_limit()
    }
}
;
Header.prototype.notice_popup = function(b) {
    var a = "/rule/noticehistory?act=new"
        , c = 322;
    if (b == "list") {
        a = "/rule/noticehistory?act=more"
    }
    if (b == "login") {
        a = "/rule/noticehistory"
    }
    JqueryDialog.Open1('<h2 class="g-tit">历史公告</h2>', a, 706, c, false, true)
}
;
Header.prototype.lineSwitch = function() {}
;
var TestLine = function(a) {
        this.id = a;
        this.init()
    }
    ;
TestLine.prototype.init = function() {
    var a = this;
    this.linex_box = $("#lines_box");
    this.isStop = true;
    this.response;
    this.lines = [];
    openLineSwitch = function() {}
    ;
    $(this.id).click(function(f) {
            var b = f.target;
            if (b.id === "testSpeed" && !b.disabled) {
                a.lines = [];
                a.response = null ;
                a.isStop = false;
                a.test()
            }
            if (b.type === "button" && b.getAttribute("url")) {
                var d = parent.$("#product_menu .on")
                    , c = $("#header_link").attr("hr")
                    , g = parent.frames[0].location.pathname.split("/");
                if (d.length) {
                    g = d.attr("href").replace(/\.html$/, "_l").replace(/\.htm$/, "")
                } else {
                    if (c) {
                        g = c
                    } else {
                        g = g[2] + "/" + g[3].replace(/\.html$/, "_l").replace(/\.htm$/, "")
                    }
                }
                g = "plays/tema";
                parent.location.href = b.getAttribute("url") + "?" + parent.document.cookie.replace(/\s/g, "").replace(/;/g, "&") + "&nav=" + g
            }
        }
    );
    this.test()
}
;
TestLine.prototype.test = function() {
    this.createQueue();
    this.testMange()
}
;
TestLine.prototype.createQueue = function() {
    var b = parent.global_lines || [], c = '<tr><td class="bg">线路{lineNo}： </td><td class="l"><span class="speed">反应时间: <span id="line{lineNo}" url="{url}"  class="time">测速中</span> </span> <input class="btn16" url="{url}" value="选择" type="button"/></td></tr>', f = [], g;
    for (var a = 0, d = b.length; a < d; a++) {
        g = {
            id: "line" + (a + 1),
            url: b[a].split("/").slice(0, 3).join("/") + "/speed.php?t="
        };
        f.push(c.replace(/{lineNo}/g, a + 1).replace(/{url}/g, b[a]));
        this.lines.push(g)
    }
    this.linex_box.html(f.join(""));
    return this.lines
}
;
TestLine.prototype.testMange = function() {
    lineInfo = this.lines.shift();
    var a;
    if (lineInfo) {
        a = document.getElementById(lineInfo.id);
        a.innerHTML = "测速中";
        lineInfo.count = 1;
        lineInfo.result = [];
        this.testEngine(lineInfo, this.testCallback)
    }
}
;
TestLine.prototype.testEngine = function(a, i) {
    var c, f, h, g, b, j = document.createElement("script"), d = this;
    b = setTimeout(function() {
            j.onload = j.onerror = j.onreadystatechange = null ;
            g = Math.floor((Math.random() * 120) + 180) + ".00毫秒";
            document.getElementsByTagName("head")[0].removeChild(j);
            i.call(a, g, h, d)
        }
        , 1000);
    j.onload = j.onreadystatechange = function() {
        if (/loaded|complete|undefined/.test(j.readyState)) {
            f = +new Date();
            if (!st || (st == 0 || st == -1)) {
                g = "无法链接"
            }
            h = f - c + st;
            st = -1;
            clearTimeout(b);
            document.getElementsByTagName("head")[0].removeChild(j);
            i.call(a, g, h, d)
        }
    }
    ;
    j.onerror = function() {
        g = "无法链接";
        clearTimeout(b);
        document.getElementsByTagName("head")[0].removeChild(j);
        i.call(a, g, h, d)
    }
    ;
    j.async = "async";
    j.src = a.url + Math.random();
    c = +new Date();
    document.getElementsByTagName("head")[0].appendChild(j)
}
;
TestLine.prototype.testCallback = function(a, f, d) {
    if (a) {
        document.getElementById(this.id).innerHTML = "<span class='red'>" + a + "</span>";
        d.testMange()
    } else {
        if (this.count == 2) {
            this.result.push(f);
            var h = 0
                , c = 0
                , g = this.result.length
                , b = "red";
            for (; c < g; c++) {
                h += this.result[c]
            }
            h = parseFloat(h / g);
            if (h < 50) {
                b = "green"
            }
            h = h.toFixed(3);
            document.getElementById(this.id).innerHTML = "<span class='" + b + "' >" + h + "ms</span>";
            d.testMange()
        } else {
            this.count += 1;
            this.result.push(f);
            d.testEngine(this, d.testCallback)
        }
    }
}
;
window.onbeforeunload = function() {
    var b = document.getElementById("main");
    try {
        b.src = "about:blank";
        b.contentWindow.document.body.innerHTML = "";
        b.contentWindow.document.clear()
    } catch (a) {}
    if ("CollectGarbage" in window) {
        CollectGarbage()
    }
}
;
var Lianma = function(f) {
        if (window.parent === window.self) {
            $("body").empty();
            alert("新窗口不可用，请关闭该窗口。");
            return
        }
        this.id = "lianma";
        $.game_ids = $.cfg_play_keys.erquanzh;
        this.info = $.evalJSON($(f).attr("info"));
        this.ids = {
            pa: "008",
            pb: "009",
            pc: "010",
            pd: "011",
            pe: "012"
        };
        this.odd_name = {
            pa: "{#|4e8c|5168|4e2d#}".keyComment(),
            pb: "中特/中二",
            pc: "{#|7279|4e32#}".keyComment(),
            pd: "三全中".keyComment(),
            pe: "中二/中三"
        };
        this.product_name = document.getElementById("product_name").innerHTML;
        this.animal = $.evalJSON($("#am").val());
        this.play = "pa";
        this.type = "ta";
        this.theme = "1000";
        this.choose_dan = [];
        this.choose = [];
        this.sw_dan = "";
        this.sw = "";
        this.show_str = "";
        this.show_char = "";
        this.game_ids = $.cfg_play_keys.erquanzh + "|" + $.cfg_play_keys.erzhongte + "|" + $.cfg_play_keys.techuan + "|" + $.cfg_play_keys.sanquanzh + "|" + $.cfg_play_keys.sanzher;
        var a = document.getElementById("time_stamp");
        this.time_stamp = a ? a.value : 0;
        var b = document.getElementById("cps_time");
        this.cps_time = b ? b.value : 0;
        $.last_update.time_stamp = this.time_stamp;
        a = f.getAttribute("status");
        this.status = a ? $.evalJSON(a)[$.game_ids] : 1;
        this.drawStatus = "";
        this.ustatus = 2;
        this.ath = null ;
        var c = this;
        this.main_tabel = $("#form_mark table")[0];
        this.odds_cell = {};
        this.thead_cell = $("thead td[colspan='2']", this.main_tabel);
        this.sumCtl = $("#amount");
        parent.$.bind("init." + c.id, function(j, i, d, h, g) {
                parent.$.unbind("init." + c.id);
                c.odds_set = i;
                c.ca = d;
                c.drawStatus = h;
                c.ustatus = g;
                c.init.call(c)
            }
        );
        parent.$.trigger("getinit");
        $(window).unload(function() {
                parent.$.unbind("." + c.id)
            }
        )
    }
    ;
Lianma.prototype.init = function() {
    parent.$.trigger("changelimit", "lianma2");
    var b = this;
    $("#balls :checkbox").each(function() {
            var f = this.parentNode.parentNode;
            var c = this.parentNode.cellIndex;
            var d = f.cells[c - 1];
            var g = $(f.cells[c - 2]).text();
            b.odds_cell[g] = d;
            d.id = b.ids[b.play] + g
        }
    );
    var a = function() {
            return ( setInterval(function() {
                    if ($.ontime()) {
                        return
                    }
                    $.getJSON("/odds/getOdds?game_ids=" + b.game_ids + "&odds_set=" + b.odds_set + "&time_stamp=" + b.time_stamp, function(c) {
                            b.refersh(c);
                            if (c.header.popup) {
                                window.parent.header.notice_popup("one")
                            }
                        }
                    )
                }
                , $.odds_refersh))
        }
        ;
    parent.$.bind("toajax." + b.id, function(c, f) {
            if (b.ath) {
                clearInterval(b.ath);
                b.ath = null
            }
            if (f && 1 === b.ustatus) {
                b.ath = a()
            }
        }
    );
    if (b.ca) {
        parent.$.bind("cpsdata." + b.id, function(f, g, c) {
                b.cometFresh.call(b, g, c)
            }
        );
        parent.$.trigger("changechannel", [b.id, b.cps_time])
    } else {
        if (1 === b.ustatus) {
            b.ath = a()
        }
    }
    this.balls = $("#balls input");
    this.plays = $("#plays input");
    this.types = $("#pabc_type input,#pde_type input");
    this.lianma_shengxiao = $("#lianma_shengxiao input");
    this.lianma_weishu = $("#lianma_weishu input");
    this.duipeng = $("#duipeng input");
    this.checkedballs = 0;
    this.balls.click(function() {
            b.checkbox_click(this)
        }
    );
    this.plays.click(function() {
            b.plays_click(this)
        }
    );
    this.types.click(function() {
            b.types_click(this)
        }
    );
    this.lianma_shengxiao.click(function() {
            b.sw_click(this)
        }
    );
    this.lianma_weishu.click(function() {
            b.sw_click(this)
        }
    );
    $("#balls em").click(function() {
            b.ball_click(this)
        }
    );
    $("#form_mark").submit(function(c) {
            if ($(":submit:first", c.target)[0].disabled) {
                return false
            }
            b.submit();
            return false
        }
    );
    $("#form_mark").bind("reset", function() {
            b.reset();
            $.trigger("renderMul");
            return false
        }
    );
    $.bind("curstop", function(d, c) {
            b.curstop(c)
        }
    );
    if (this.status) {
        this.disabl_theme()
    }
    parent.$.bind("reset." + b.id, function() {
            $("#form_mark").trigger("reset")
        }
    );
    parent.$.bind("resubmit." + b.id, function() {
            $("#form_mark").trigger("submit")
        }
    );
    parent.$.bind("ablesubmit." + b.id, function() {
            $(":submit").removeAttr("disabled")
        }
    )
}
;
Lianma.prototype.reset = function() {
    document.getElementById("amount").value = "";
    this.clear();
    $("#plays :radio:enabled:checked:first").trigger("click");
    $("#pabc_type :radio:enabled:checked:first").trigger("click")
}
;
Lianma.prototype.refersh = function(b) {
    if (b.hasOwnProperty("odds")) {
        for (var a in b.odds) {
            if (b.odds.hasOwnProperty(a)) {
                this.info.odds[a] = b.odds[a]
            }
        }
    }
    this.time_stamp = b.time_stamp;
    this.curstop(b.status[$.game_ids]);
    parent.$.trigger("cpsset", [{
        timestamp: b.time_stamp
    }]);
    $.refersh_odds_header(b)
}
;
Lianma.prototype.cometFresh = function(g, c) {
    var f = this;
    f.time_stamp = c;
    for (var b in g) {
        if (g.hasOwnProperty(b)) {
            if (("1" == f.drawStatus || "2" == f.drawStatus) && b.indexOf("odds") === 0 && b.indexOf(f.odds_set) === 9) {
                for (var a in g[b]) {
                    if (g[b].hasOwnProperty(a)) {
                        this.info.odds[a] = g[b][a]
                    }
                }
                $.refersh_odds(g[b]);
                continue
            }
            if ("drawStatus" == b) {
                if (f.drawStatus != g[b]) {
                    f.time_stamp = 1;
                    $.getJSON("/odds/getOdds?game_ids=" + f.game_ids + "&odds_set=" + f.odds_set + "&time_stamp=" + f.time_stamp, function(h) {
                            f.refersh(h)
                        }
                    );
                    f.drawStatus = g[b]
                }
                if ("2" == g[b]) {
                    g[b] = 0
                } else {
                    g[b] = parseInt(g[b], 10)
                }
                f.curstop(g[b]);
                continue
            }
            if (b == "curstop") {
                for (var c in g[b]) {
                    if (g[b].hasOwnProperty(c) && c == $.cfg_play_keys.erquanzh) {
                        f.curstop(g[b][c], c)
                    }
                }
            }
        }
    }
}
;
Lianma.prototype.curstop = function(a, b) {
    if (this.status === a) {
        return
    }
    if (a) {
        $("#form_mark").trigger("reset");
        $("#is_mul").removeAttr("disabled");
        $.trigger("renderMul")
    } else {
        $("input").attr("disabled", "disabled");
        $(":text").addClass("dis");
        $(":submit, :reset").addClass("bds")
    }
    this.status = a
}
;
Lianma.prototype.plays_click = function(a) {
    var b = this.play;
    if (this.play != a.value) {
        for (var c in this.odds_cell) {
            this.odds_cell[c].className = ""
        }
    }
    this.play = a.value;
    this.clear();
    this.refreshOddrs();
    if (a.value == "pa" || a.value == "pb" || a.value == "pc") {
        if (b == "pd" || b == "pe") {
            this.display_theme("pabc");
            setTimeout(function() {
                    parent.$.trigger("changelimit", "lianma2")
                }
                , 500)
        }
        this.disabl_theme()
    } else {
        if (a.value == "pd" || a.value == "pe") {
            if (b == "pa" || b == "pb" || b == "pc") {
                this.display_theme("pde");
                setTimeout(function() {
                        parent.$.trigger("changelimit", "lianma3")
                    }
                    , 500)
            }
        }
    }
}
;
Lianma.prototype.types_click = function(a) {
    this.type = a.value;
    if (this.play == "pa" || this.play == "pb" || this.play == "pc") {
        this.theme = a.getAttribute("theme");
        this.clear();
        this.disabl_theme()
    } else {
        this.clear()
    }
}
;
Lianma.prototype.ball_click = function(b) {
    var c = b.parentNode;
    var a = c.parentNode.cells[c.cellIndex + 2].firstChild;
    if (a.disabled) {
        return
    }
    a.checked = a.checked ? false : true;
    this.checkbox_click(a)
}
;
Lianma.prototype.checkbox_click = function(b) {
    if (b.checked) {
        this.checkedballs++
    } else {
        this.checkedballs--
    }
    if (this.checkedballs >= 10) {
        $("#balls input:not(:checked)").attr("disabled", "disabled")
    } else {
        $("#balls input:not(:checked)").removeAttr("disabled")
    }
    var a = b.value;
    var c = '<em class="ico n' + a + '">' + a + "</em>";
    if (b.checked) {
        this.set_dan(c, b)
    }
    this.show_order()
}
;
Lianma.prototype.set_dan = function(c, b) {
    var a = function(d) {
            d.innerHTML = c;
            b.disabled = true
        }
        ;
    if (this.checkedballs == 1) {
        if (this.type == "tb") {
            a(document.getElementById("dan_text"))
        } else {
            if (this.type == "tg") {
                a(document.getElementById("dan_text1"))
            }
        }
    } else {
        if (this.checkedballs == 2 && this.type == "tg") {
            a(document.getElementById("dan_text2"))
        }
    }
}
;
Lianma.prototype.sw_click = function(b) {
    var c, f, d;
    this.cl();
    switch (this.type) {
        case "tc":
            c = $("#lianma_shengxiao input:checked");
            this.disable_opposite(c);
            this.sw_dan = c.get(0).value;
            this.choose_dan = this.animal[this.sw_dan];
            break;
        case "ti":
            f = $("#lianma_shengxiao input:checked");
            d = $("#lianma_weishu input:checked");
            c = $(".shengwei input:checked");
            if (f.length == 1) {
                this.sw_dan = f.get(0).value;
                this.choose_dan = this.animal[this.sw_dan]
            } else {
                this.sw_dan = d.get(0).value;
                this.choose_dan = $.cfg_weishu[this.sw_dan.substr(0, 1)]
            }
            break;
        default:
            c = $("#lianma_weishu input:checked");
            this.disable_opposite(c);
            this.sw_dan = c.get(0).value;
            this.choose_dan = $.cfg_weishu[this.sw_dan.substr(0, 1)]
    }
    if (c.length == 2) {
        this.sw = c.get(1).value;
        switch (this.type) {
            case "tc":
                this.choose = this.animal[this.sw];
                break;
            case "ti":
                this.sw = d.get(0).value;
                this.choose = $.cfg_weishu[this.sw.substr(0, 1)];
                break;
            default:
                this.choose = $.cfg_weishu[this.sw.substr(0, 1)]
        }
    } else {
        this.sw = "";
        this.choose = []
    }
    var a = c.length;
    this.show_order(a)
}
;
Lianma.prototype.disable_opposite = function(b) {
    if (this.type == "tc") {
        this.lianma_shengxiao.removeAttr("disabled")
    } else {
        this.lianma_weishu.removeAttr("disabled")
    }
    var a = this;
    b.each(function(d) {
            var f = this.parentNode.parentNode;
            var c;
            if (a.type == "tc") {
                c = f.parentNode.rowIndex === 0 ? f.cellIndex + 12 : f.cellIndex;
                a.lianma_shengxiao.get(c).disabled = true
            } else {
                if (a.type == "td") {
                    c = f.parentNode.rowIndex === 0 ? f.cellIndex + 10 : f.cellIndex;
                    a.lianma_weishu.get(c).disabled = true
                }
            }
        }
    )
}
;
Lianma.prototype.clear = function() {
    this.checkedballs = 0;
    this.cl();
    this.balls.removeAttr("disabled").removeAttr("checked");
    this.plays.removeAttr("disabled");
    this.lianma_shengxiao.removeAttr("checked");
    this.lianma_weishu.removeAttr("checked");
    this.duipeng.val("");
    $("#re_text, #re_num, #dan_text, #dan_text1, #dan_text2").text("");
    $("#pabc_type input").removeAttr("disabled");
    $("#pde_type input").removeAttr("disabled");
    $("#amount").removeAttr("disabled").removeClass("dis").nextAll().removeAttr("disabled").removeClass("bds");
    $("#amount").val("")
}
;
Lianma.prototype.refreshOddrs = function() {
    var b = this;
    this.thead_cell.each(function(d, f) {
            f.innerHTML = b.odd_name[b.play]
        }
    );
    for (var c in this.odds_cell) {
        var a = this.ids[this.play] + c;
        this.odds_cell[c].id = a;
        this.odds_cell[c].innerHTML = this.info.odds[a];
        $.game_ids = this.ids[this.play]
    }
}
;
Lianma.prototype.cl = function() {
    this.choose = [];
    this.choose_dan = []
}
;
Lianma.prototype.disabl_theme = function() {
    if (this.theme.charAt(0) == "1") {} else {
        this.balls.attr("disabled", "disabled")
    }
    if (this.theme.charAt(1) == "1") {
        this.lianma_shengxiao.removeAttr("disabled")
    } else {
        this.lianma_shengxiao.attr("disabled", "disabled")
    }
    if (this.theme.charAt(2) == "1") {
        this.lianma_weishu.removeAttr("disabled")
    } else {
        this.lianma_weishu.attr("disabled", "disabled")
    }
    if (this.theme.charAt(3) == "1") {
        this.duipeng.removeAttr("disabled").removeClass("dis")
    } else {
        this.duipeng.attr("disabled", "disabled").addClass("dis")
    }
    if (this.theme.charAt(4) == "1") {
        $(".shengwei input").removeAttr("disabled").removeClass("dis")
    } else {}
}
;
Lianma.prototype.display_theme = function(a) {
    if (a == "pabc") {
        this.types.removeAttr("checked");
        $("#ta").click();
        $("#pabc_type").show();
        $("#pde_type").hide();
        $("#lianma_shengxiao").show();
        $("#lianma_weishu").show();
        $("#duipeng").show()
    } else {
        this.balls.removeAttr("disabled");
        this.types.removeAttr("checked");
        $("#tf").click();
        $("#pabc_type").hide();
        $("#pde_type").show();
        $("#lianma_shengxiao").hide();
        $("#lianma_weishu").hide();
        $("#duipeng").hide()
    }
}
;
Lianma.prototype.check_duipeng = function() {
    var f = "#";
    var c = $("#duipeng input[value!='']");
    this.cl();
    var b = "";
    for (var a = 0; a < c.length; a++) {
        var d = c.get(a);
        if (!$.isBall(d.value)) {
            alert("请输入正确的球号: 1-49");
            d.select();
            this.cl();
            return false
        }
        if ((f).indexOf("#" + d.value + "#") != -1) {
            alert("对碰的号码不能有相同。");
            d.select();
            this.cl();
            return false
        }
        f += d.value + "#";
        b = d.value;
        if (b.length == 1) {
            b = "0" + b
        }
        if (d.name == "front") {
            this.choose_dan.push(b)
        } else {
            this.choose.push(b)
        }
    }
    if (this.choose_dan.length === 0 || this.choose.length === 0) {
        alert("对碰的两组号码不能为空");
        this.cl();
        return false
    }
    return true
}
;
Lianma.prototype.submit = function() {
    var f = document.getElementById("amount");
    if (this.type == "tc" && (this.choose.length === 0 || this.choose_dan.length === 0)) {
        alert("{#|751f|8096#}对碰必须选择两个{#|751f|8096#}".keyComment());
        return
    }
    if (this.type == "td" && (this.choose.length === 0 || this.choose_dan.length === 0)) {
        alert("{#|5c3e|6570#}对碰必须选择两个{#|5c3e|6570#}".keyComment());
        return
    }
    if (this.type == "ti" && (this.choose.length === 0 || this.choose_dan.length === 0)) {
        alert("生尾对碰必须选择1个{#|5c3e|6570#}和1个{#|751f|8096#}".keyComment());
        return
    }
    if (!$.isInt(f.value)) {
        alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
        f.select();
        return
    }
    if (this.type == "te") {
        if (!this.check_duipeng()) {
            return
        }
        this.show_order()
    }
    var l = this.play + "_" + this.type;
    var p;
    var d = 1;
    switch (l) {
        case "pa_ta":
        case "pb_ta":
        case "pc_ta":
            if (this.choose.length < 2) {
                alert("号码选择不少于两个");
                return
            }
            p = $.assemble(this.choose.sort(function(k, i) {
                    return k - i
                }
            ), 2);
            break;
        case "pa_tb":
        case "pb_tb":
        case "pc_tb":
        case "pa_tc":
        case "pb_tc":
        case "pc_tc":
        case "pa_td":
        case "pb_td":
        case "pc_td":
        case "pa_te":
        case "pb_te":
        case "pc_te":
        case "pa_ti":
        case "pb_ti":
        case "pc_ti":
            if (this.choose.length + this.choose_dan.length < 2) {
                alert("号码选择不少于两个");
                return
            }
            p = $.assemble_array(this.choose_dan, this.choose);
            break;
        case "pd_tf":
        case "pe_tf":
            if (this.choose.length < 3) {
                alert("号码选择不少于三个");
                return
            }
            p = $.assemble(this.choose.sort(function(k, i) {
                    return k - i
                }
            ), 3);
            break;
        case "pd_tg":
        case "pe_tg":
            if (this.choose.length + this.choose_dan.length < 3) {
                alert("号码选择不少于三个");
                return
            }
            p = $.assemble_array2([this.choose_dan[0], this.choose_dan[1]], this.choose);
            break
    }
    var b = p;
    var r = document.getElementById(this.play).nextSibling;
    switch (this.type) {
        case "ta":
        case "tf":
            d = "1";
            break;
        case "tb":
        case "tg":
            d = "4" + this.choose_dan.join(",");
            break;
        case "tc":
            d = "2" + this.sw_dan;
            break;
        case "td":
            d = "30" + this.sw_dan.substr(0, 1);
            break;
        case "te":
            d = "5" + this.choose_dan.join(",");
            break;
        case "ti":
            d = "7" + this.sw_dan;
            break
    }
    var s = [];
    var g = [];
    for (var m = 0, h = this.choose_dan.length; m < h; m++) {
        var q = this.ids[this.play] + this.choose_dan[m];
        var c = this.info.odds[q];
        s.push(c);
        g.push(this.choose_dan[m])
    }
    for (var m = 0, h = this.choose.length; m < h; m++) {
        var q = this.ids[this.play] + this.choose[m];
        var c = this.info.odds[q];
        s.push(c);
        g.push(this.choose[m])
    }
    var a = {};
    var o = [];
    for (var m = 0; m < b.length; m++) {
        if (this.play == "pb" || this.play == "pe") {
            a[b[m]] = this.get_min_odds2(b[m])
        } else {
            a[b[m]] = this.get_min_odds(b[m])
        }
        o.push(b[m].replace(/\s/g, ","))
    }
    switch (this.type) {
        case "tc":
        case "td":
            g = this.show_str + "#" + g.join(",");
            break;
        case "ti":
            g = this.show_str + "#" + g.join(",");
            break;
        default:
            g = g.join(",")
    }
    var j = [];
    j.push({
        no: r.nodeValue + " " + document.getElementById(this.type).nextSibling.nodeValue,
        odds: s.join(","),
        key: this.ids[this.play],
        amount: f.value,
        nos: g,
        assemble_odd: a,
        show_arr: o,
        show_str: this.show_str,
        show_char: this.show_char,
        ordertype: d
    });
    parent.$.trigger("showneworder", {
        gameId: this.id,
        game: this.product_name,
        odds_set: this.odds_set,
        order: j,
        footer: b
    })
}
;
Lianma.prototype.get_min_odds = function(j) {
    var g = j.split(" ");
    var b = this.ids[this.play];
    var f = this.info.odds[b + g[0]];
    var d = parseFloat(f);
    var h = d.toFixed(3) + "|" + g[0];
    for (var c = 1; c < g.length; c++) {
        f = this.info.odds[b + g[c]];
        var a = parseFloat(f);
        if (a < d) {
            d = a;
            h = d.toFixed(3) + "|" + g[c]
        }
    }
    return h
}
;
Lianma.prototype.get_min_odds2 = function(a) {
    var c = a.split(" ");
    var d = this.ids[this.play];
    var m = this.info.odds[d + c[0]];
    var h = m.split("/");
    var f = parseFloat(h[0]);
    var l = parseFloat(h[1]);
    var j = f.toFixed(3) + "/" + l.toFixed(3) + "|" + c[0];
    for (var g = 1; g < c.length; g++) {
        m = this.info.odds[d + c[g]];
        h = m.split("/");
        var b = parseFloat(h[0]);
        var k = parseFloat(h[1]);
        if (b < f) {
            f = b
        }
        if (k < l) {
            l = k
        }
        j = f.toFixed(3) + "/" + l.toFixed(3) + "|" + c[g]
    }
    return j
}
;
Lianma.prototype.show_order = function(a) {
    var f = this.play + "_" + this.type;
    var g = "";
    var b = 0;
    var c = "";
    switch (f) {
        case "pa_ta":
        case "pb_ta":
        case "pc_ta":
            c = $("#balls input:checked");
            this.get_choose(c);
            g += this.checkedballs + "[ " + this.choose.join(" ") + " ]";
            this.show_str = this.choose.join(",");
            this.show_char = this.show_str;
            b = $.assemble(this.choose, 2).length;
            break;
        case "pa_tb":
        case "pb_tb":
        case "pc_tb":
            c = $("#balls input:checked");
            this.get_choose(c);
            g += this.checkedballs + "[" + this.choose_dan.join(" ") + "][" + this.choose.join(" ") + "]";
            this.show_str = this.choose_dan.join(",") + "," + this.choose.join(",");
            this.show_char = this.choose_dan.join(",") + "&nbsp;[拖]&nbsp;" + this.choose.join(",");
            b = this.choose.length;
            break;
        case "pa_tc":
        case "pb_tc":
        case "pc_tc":
            b = this.choose.length > 1 ? this.choose.length * this.choose_dan.length : 0;
            var d = "";
            if (this.sw) {
                d = $.cfg_number_shengxiao[this.sw]
            }
            g += "[" + $.cfg_number_shengxiao[this.sw_dan] + "]&nbsp;碰&nbsp;[" + d + "]";
            this.show_str = this.sw_dan + "," + this.sw;
            this.show_char = $.cfg_number_shengxiao[this.sw_dan] + "&nbsp;[碰]&nbsp;" + d;
            break;
        case "pa_td":
        case "pb_td":
        case "pc_td":
            b = this.choose.length > 1 ? this.choose.length * this.choose_dan.length : 0;
            g += "[" + this.sw_dan + "]&nbsp;碰&nbsp;[" + this.sw + "]";
            this.show_str = "0" + this.sw_dan.substr(0, 1) + ",0" + this.sw.substr(0, 1);
            this.show_char = this.sw_dan + "&nbsp;[碰]&nbsp;" + this.sw;
            break;
        case "pa_te":
        case "pb_te":
        case "pc_te":
            g += "[" + this.choose_dan.join(" ") + "]&nbsp;对碰&nbsp;[" + this.choose.join(" ") + "]";
            this.show_str = this.choose_dan.join(",") + "," + this.choose.join(",");
            this.show_char = this.choose_dan.join(",") + "&nbsp;[碰]&nbsp;" + this.choose.join(",");
            b = this.choose.length * this.choose_dan.length;
            break;
        case "pd_tf":
        case "pe_tf":
            c = $("#balls input:checked");
            this.get_choose(c);
            g += this.checkedballs + "[ " + this.choose.join(" ") + " ]";
            b = $.assemble(this.choose, 3).length;
            this.show_str = this.choose.join(",");
            this.show_char = this.show_str;
            break;
        case "pd_tg":
        case "pe_tg":
            c = $("#balls input:checked");
            this.get_choose(c);
            g += this.checkedballs + "[" + this.choose_dan.join(" ") + "][" + this.choose.join(" ") + "]";
            b = this.choose.length;
            this.show_str = this.choose_dan.join(",") + "," + this.choose.join(",");
            this.show_char = this.choose_dan.join(",") + "&nbsp;[拖]&nbsp;" + this.choose.join(",");
            break;
        case "pa_ti":
        case "pb_ti":
        case "pc_ti":
            if (a != 2) {
                b = this.choose.length > 1 ? this.choose.length * this.choose_dan.length : 0
            } else {
                b = $.assemble_array(this.choose_dan, this.choose).length
            }
            g += "[" + ($.cfg_number_shengxiao[this.sw_dan] || this.sw_dan) + "]&nbsp;碰&nbsp;[" + this.sw + "]";
            this.show_str = this.sw_dan + ",0" + this.sw.substr(0, 1);
            this.show_char = $.cfg_number_shengxiao[this.sw_dan] + "&nbsp;[碰]&nbsp;" + this.sw;
            break
    }
    document.getElementById("re_text").innerHTML = g;
    document.getElementById("re_num").innerHTML = b
}
;
Lianma.prototype.get_choose = function(b) {
    this.choose = [];
    this.choose_dan = [];
    for (var a = 0; a < b.length; a++) {
        if (b[a].disabled) {
            this.choose_dan.push(b[a].value)
        } else {
            this.choose.push(b[a].value)
        }
    }
    this.choose.sort(function(d, c) {
            return d - c
        }
    );
    this.choose_dan.sort(function(d, c) {
            return d - c
        }
    )
}
;
var PlaysGroup = function(f) {
        if (window.parent === window.self) {
            $("body").empty();
            alert("新窗口不可用，请关闭该窗口。");
            return
        }
        var c = this;
        this.d = f;
        this.orders = [];
        this.id = f.getAttribute("id");
        this.product_name = document.getElementById("product_name").innerHTML;
        this.game_ids = "";
        this.control_id = "";
        c.get_keys();
        $.game_ids = c.control_id;
        var a = document.getElementById("time_stamp");
        this.time_stamp = a ? a.value : 0;
        var b = document.getElementById("cps_time");
        this.cps_time = b ? b.value : 0;
        $.last_update.time_stamp = this.time_stamp;
        a = f.getAttribute("status");
        this.status = a ? $.evalJSON(a)[c.control_id] : 1;
        $.last_update.status = this.status;
        this.drawStatus = "";
        this.ustatus = 2;
        this.ath = null ;
        this.odds = {};
        this.sumCtl = $("#form_mark input:text,#w_fast_input");
        this.orderText = $("#main_tab input:text");
        parent.$.bind("init." + this.id, function(j, i, d, h, g) {
                parent.$.unbind("init." + this.id);
                c.odds_set = i;
                c.ca = d;
                c.drawStatus = h;
                c.ustatus = g;
                c.init.call(c)
            }
        );
        parent.$.trigger("getinit");
        $(window).unload(function() {
                parent.$.unbind("." + c.id)
            }
        );
        this.refreshCtl = $("#form_mark input,#w_fast_input")
        //this.act&&this.ath();
    }
    ;
PlaysGroup.prototype.init = function() {
    var f = this;
    parent.$.trigger("changelimit", f.id);
    $("#" + this.id + " tbody input[type='text']").each(function(h) {
            var l = this.parentNode;
            var g = this.name.substr(4);
            var j = l.parentNode.cells[l.cellIndex - 1];
            f.odds[g] = j;
            j.id = g
        }
    );
    var c = function() {
            return ( setInterval(function() {
                    if ($.ontime()) {
                        return
                    }
                $.getJSON("/odds/getOdds?game_ids=" + f.game_ids+"&isDefault=false" + "&odds_set=" + this.odds_set + "&time_stamp=" + $.last_update.time_stamp, function(g) {
                            $.refersh(g);
                            if (g.header.popup) {
                                window.parent.header.notice_popup("one")
                            }
                        }
                    )
                }
                , $.odds_refersh))
        }
        ;
    parent.$.bind("toajax." + f.id, function(g, h) {
            if (f.ath) {
                clearInterval(f.ath);
                f.ath = null
            }
            if (h && 1 === f.ustatus) {
                f.ath = c()
            }
        }
    );
    if (this.ca) {
        parent.$.bind("cpsdata." + f.id, function(h, i, g) {
                f.cometFresh.call(f, i, g)
            }
        );
        parent.$.trigger("changechannel", [f.id, f.cps_time])
    } else {
        if (1 === f.ustatus) {
            f.ath = c()
        }
    }
    f.regist_submit_click();
    parent.$.bind("reset." + f.id, function() {
            $("#form_mark").trigger("reset");
            $.trigger("renderMul")
        }
    );
    parent.$.bind("ablesubmit." + f.id, function() {
            $(":submit").removeAttr("disabled")
        }
    );
    $("#form_mark").bind("reset", function(g) {
            $("input:text", this).val("");
            $("#w_fast_input").val("");
            $("#w_fast input:radio").attr("checked", false);
            $.trigger("renderMul");
            return false
        }
    );
    if (f.id.match(/^(shengxiaobuzhong|shengxiao|texiao|weishu)$/g)) {
        var d = $("#w_fast")
            , b = $("#w_fast_input")
            , a = $(":radio", d);
        if (f.id === "weishu") {
            a.click(function(i) {
                    if (!b.val().match(/^\d+$/)) {
                        alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
                        $(this).attr("checked", false);
                        b.select();
                        return
                    }
                    var h = ""
                        , g = b.val();
                    $.each(a.filter(":checked"), function(j, k) {
                            h += k.value
                        }
                    );
                    f.orderText.val(function() {
                            var j = this.name.slice(-1) + "";
                            if (h.indexOf(j) > -1) {
                                return g
                            }
                            return ""
                        }
                    )
                }
            )
        } else {
            a.click(function(h) {
                    if (!b.val().match(/^\d+$/)) {
                        alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
                        $(this).attr("checked", false);
                        b.select();
                        return
                    }
                    var g = b.val(), i;
                    $.each(f.orderText, function(j, k) {
                            i = k.name.slice(-2) + "";
                            k.value = "";
                            if (i.match(/^(02|07|08|10|11|12)$/g) && h.target.value === "jiaqin") {
                                k.value = g
                            }
                            if (i.match(/^(01|03|04|05|06|09)$/g) && h.target.value === "yeshou") {
                                k.value = g
                            }
                        }
                    )
                }
            )
        }
        b.bind("keypress", function(g) {
                if (g.keyCode === 13) {
                    if (!this.value.match(/^\d+$/)) {
                        alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
                        return false
                    }
                    if (!a.filter(":checked").length) {
                        alert("请选择{#|73a9|6cd5#}".keyComment());
                        return false
                    }
                }
            }
        );
        d.bind("keypress", function(g) {
                if (g.keyCode === 13) {
                    $("#form_mark").submit()
                }
            }
        )
    }
}
;
PlaysGroup.prototype.curstop = function(a, b) {
    if (this.status === a) {
        return
    }
    if (0 === a) {
        $(":text").attr("disabled", "disabled").addClass("dis");
        $("#form_mark").find(":submit, :reset").attr("disabled", "disabled").addClass("bds");
        $("#multiple input").attr("disabled", "disabled")
    } else {
        $(":text").removeAttr("disabled").removeClass("dis");
        $("#form_mark").find(":submit, :reset").removeAttr("disabled").removeClass("bds");
        $("#is_mul").removeAttr("disabled");
        $.trigger("renderMul")
    }
    this.status = a
}
;
PlaysGroup.prototype.cometFresh = function(g, c) {
    var f = this;
    f.time_stamp = c;
    var a = function(h) {
            $.refersh(h);
            f.time_stamp = h.time_stamp
        }
        ;
    for (var b in g) {
        if (g.hasOwnProperty(b)) {
            if (("1" == f.drawStatus || "2" == f.drawStatus) && b.indexOf("odds") === 0 && b.indexOf(f.odds_set) === 9) {
                $.refersh_odds(g[b]);
                continue
            }
            if ("drawStatus" == b) {
                if (f.drawStatus != g[b]) {
                    f.time_stamp = 1;
                    f.drawStatus = g[b];
                    $.getJSON("/odds/getOdds?game_ids=" + f.game_ids + "&odds_set=" + f.odds_set + "&time_stamp=" + f.time_stamp, a)
                }
                if ("2" == g[b]) {
                    g[b] = 0
                } else {
                    g[b] = parseInt(g[b], 10)
                }
                f.curstop(g[b]);
                continue
            }
            if (b == "curstop") {
                for (var c in g[b]) {
                    if (g[b].hasOwnProperty(c) && c == f.control_id) {
                        f.curstop(g[b][c], c)
                    }
                }
            }
        }
    }
}
;
PlaysGroup.prototype.get_keys = function() {
    switch (this.id) {
        case "shengxiao":
            this.game_ids = $.cfg_play_keys.shxiao;
            this.control_id = $.cfg_play_keys.shxiao;
            break;
        case "shengxiaobuzhong":
            this.game_ids = $.cfg_play_keys.shengxiaobuzhong;
            this.control_id = $.cfg_play_keys.shengxiaobuzhong;
            break;
        case "weishu":
            this.game_ids = $.cfg_play_keys.weishu;
            this.control_id = $.cfg_play_keys.weishu;
            break;
        case "banbo":
            this.game_ids = $.cfg_play_keys.banbo;
            this.control_id = $.cfg_play_keys.banbo;
            break;
        case "texiao":
            this.game_ids = $.cfg_play_keys.texiao;
            this.control_id = $.cfg_play_keys.texiao;
            break;
        case "zhengma1to6":
            this.control_id = $.cfg_play_keys.lmzhmate1;
            this.game_ids = $.cfg_play_keys.lmzhmate1 + "|" + $.cfg_play_keys.lmzhmate2 + "|" + $.cfg_play_keys.lmzhmate3 + "|" + $.cfg_play_keys.lmzhmate4 + "|" + $.cfg_play_keys.lmzhmate5 + "|" + $.cfg_play_keys.lmzhmate6
    }
}
;
PlaysGroup.prototype.regist_submit_click = function() {
    var a = this;
    $("#form_mark").submit(function(b) {
            if ($(":submit:first", b.target)[0].disabled) {
                return false
            }
            if (a.get_orders(b)) {
                parent.$.trigger("showneworder", {
                    gameId: a.id,
                    game: a.product_name,
                    order: a.orders,
                    odds_set: a.odds_set
                })
            }
            return false
        }
    )
}
;
PlaysGroup.prototype.get_orders = function(c) {
    var a = $("#" + this.id + " tbody input[type='text'][value!='']");
    if (a.length <= 0) {
        alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
        return false
    }
    this.orders = [];
    var d = [];
    var b = this;
    a.each(function(h) {
            if ($.isInt(this.value)) {
                var g = this.name.substr(4);
                var f = parseFloat(b.odds[g].innerHTML);
                if (!$.isPfloat(f)) {
                    alert("{#|8d54|7387#}不正确，请刷新页面后重新提交！".keyComment());
                    return false
                }
                d.push({
                    no: b.get_proName(this.parentNode),
                    odds: b.odds[g].innerHTML,
                    amount: this.value,
                    key: g
                })
            } else {
                d = false;
                alert("请输入要{#|6295|6ce8#}的整数金额".keyComment());
                this.select();
                return false
            }
        }
    );
    if (d) {
        this.orders = d;
        return true
    }
    return false
}
;
PlaysGroup.prototype.get_proName = function(c) {
    var a = "";
    var b = c.parentNode;
    switch (this.id) {
        case "texiao":
        case "shengxiao":
        case "shengxiaobuzhong":
            a = b.cells[c.cellIndex - 3].innerHTML;
            break;
        case "zhengma1to6":
            a = b.cells[0].innerHTML + " " + c.offsetParent.rows[0].cells[c.cellIndex - 1].innerHTML;
            break;
        default:
            a = b.cells[c.cellIndex - 2].innerHTML
    }
    return $.stripTags(a)
}
;
var SWlian = function(g) {
        if (window.parent === window.self) {
            $("body").empty();
            alert("新窗口不可用，请关闭该窗口。");
            return
        }
        this.d = g;
        this.id = g.getAttribute("id");
        this.form = $("form", g)[0];
        this.orders = [];
        this.product_name = document.getElementById("product_name").innerHTML;
        this.type = "fushi";
        this.play_value = "";
        this.balls = $("#ball input");
        this.checked = [];
        this.choose_number = [];
        this.choose_dan = [];
        this.choose = [];
        this.all_game = $.cfg_play_keys[this.id];
        this.info = sw_all_info;
        var a = $("table input:checked").val();
        $.game_ids = this.game_ids = a.substr(1);
        this.limit = parseInt(a.substr(0, 1), 10);
        this.last_update = {};
        var b = document.getElementById("time_stamp");
        $.last_update.time_stamp = b ? b.value : 0;
        var c = document.getElementById("cps_time");
        this.cps_time = c ? c.value : 0;
        b = g.getAttribute("status");
        this.status = b ? $.evalJSON(b)[$.game_ids] : 1;
        this.drawStatus = "";
        this.ustatus = 2;
        this.ath = null ;
        this.odom = {};
        this.sumCtl = $("#sum");
        var f = this;
        parent.$.bind("init." + f.id, function(k, j, d, i, h) {
                parent.$.unbind("init." + f.id);
                f.odds_set = j;
                f.ca = d;
                f.drawStatus = i;
                f.ustatus = h;
                f.init.call(f)
            }
        );
        parent.$.trigger("getinit");
        $(window).unload(function() {
                parent.$.unbind("." + f.id)
            }
        )
    }
    ;
SWlian.prototype.init = function() {
    parent.$.trigger("changelimit", this.id);
    this.play_value = document.getElementById("default_play").nextSibling.nodeValue;
    var c = this;
    var b = function() {
            c.odom = {};
            c.balls.each(function() {
                    var g = this.parentNode.parentNode;
                    var f = g.parentNode.cells[g.cellIndex + 2];
                    var d = f.getAttribute("name").substr(4);
                    d = c.game_ids + d;
                    c.odom[d] = f;
                    f.id = d
                }
            )
        }
        ;
    b();
    var a = function() {
            return ( setInterval(function() {
                    if ($.ontime()) {
                        return
                    }
                    $.getJSON("/odds/getOdds?game_ids=" + c.all_game + "&odds_set=" + c.odds_set + "&time_stamp=" + $.last_update.time_stamp, function(f) {
                            c.ajaxRefersh(f);
                            if (f.header.popup) {
                                window.parent.header.notice_popup("one")
                            }
                        }
                    )
                }
                , $.odds_refersh))
        }
        ;
    parent.$.bind("toajax." + c.id, function(f, g) {
            if (c.ath) {
                clearInterval(c.ath);
                c.ath = null
            }
            if (g && 1 === c.ustatus) {
                c.ath = a()
            }
        }
    );
    if (this.ca) {
        parent.$.bind("cpsdata." + c.id, function(g, h, f) {
                c.cometFresh.call(c, h, f)
            }
        );
        parent.$.trigger("changechannel", [c.id, c.cps_time])
    } else {
        if (1 === c.ustatus) {
            c.ath = a()
        }
    }
    $("#plays input").click(function() {
            c.limit = parseInt(this.value.substr(0, 1), 10);
            $.game_ids = c.game_ids = this.value.substr(1);
            $.last_update = {};
            c.choose_dan = [];
            c.choose = [];
            c.play_value = this.nextSibling.nodeValue;
            c.uncheck();
            b();
            $.refersh(c.info);
            $(".light").removeClass("light")
        }
    );
    $("#types input").click(function() {
            c.type = this.value;
            c.uncheck()
        }
    );
    this.balls.click(function() {
            c.ball_click(this)
        }
    );
    $("#form_mark").submit(function(d) {
            if ($(":submit:first", d.target)[0].disabled) {
                return false
            }
            c.submit_bet();
            return false
        }
    );
    $("#form_mark").bind("reset", function() {
            c.uncheck();
            c.checked = [];
            c.choose_number = [];
            c.choose_dan = [];
            c.choose = [];
            $.trigger("renderMul");
            return false
        }
    );
    parent.$.bind("reset." + c.id, function() {
            $("#form_mark").trigger("reset")
        }
    );
    parent.$.bind("resubmit." + c.id, function() {
            $("#form_mark").trigger("submit")
        }
    );
    parent.$.bind("ablesubmit." + c.id, function() {
            $(":submit").removeAttr("disabled")
        }
    )
}
;
SWlian.prototype.ajaxRefersh = function(c) {
    for (var b in c) {
        if (c.hasOwnProperty(b)) {
            if (b == "odds") {
                for (var a in c.odds) {
                    if (c.odds.hasOwnProperty(a)) {
                        this.info.odds[a] = c.odds[a]
                    }
                }
            } else {
                if (b == "status") {
                    for (var a in c.status) {
                        if (c.status.hasOwnProperty(a)) {
                            this.info.status[a] = c.status[a]
                        }
                    }
                } else {
                    if (b == "time_stamp") {
                        this.info.time_stamp = c.time_stamp
                    }
                }
            }
        }
    }
    $.refersh(c)
}
;
SWlian.prototype.cometFresh = function(j, f) {
    var h = this;
    $.last_update.time_stamp = f;
    var b = function(i) {
            h.ajaxRefersh(i);
            if (i.header.popup) {
                window.parent.header.notice_popup("one")
            }
        }
        ;
    for (var c in j) {
        if (j.hasOwnProperty(c)) {
            if (("1" == h.drawStatus || "2" == h.drawStatus) && c.indexOf("odds") === 0 && c.indexOf(h.odds_set) === 9) {
                var g = j[c];
                for (var a in g) {
                    if (g.hasOwnProperty(a)) {
                        h.info.odds[a] = g[a]
                    }
                }
                $.refersh_odds(g);
                continue
            }
            if ("drawStatus" == c) {
                if (h.drawStatus != j[c]) {
                    $.getJSON("/odds/getOdds?game_ids=" + h.all_game + "&odds_set=" + h.odds_set + "&time_stamp=0", b);
                    h.drawStatus = j[c]
                }
                if ("2" == j[c]) {
                    j[c] = 0
                } else {
                    j[c] = parseInt(j[c], 10)
                }
                h.curstop(j[c]);
                continue
            }
            if (c == "curstop") {
                for (var f in j[c]) {
                    if (j[c].hasOwnProperty(f)) {
                        if (h.info.status.hasOwnProperty(f)) {
                            h.info.status[f] = j[c][f]
                        }
                        if (f == h.game_ids) {
                            h.curstop(j[c][f])
                        }
                    }
                }
            }
        }
    }
}
;
SWlian.prototype.curstop = function(a) {
    if (this.status === a) {
        return
    }
    if (a) {
        $("input").removeAttr("disabled").removeClass("dis").removeClass("bds");
        $.trigger("renderMul")
    } else {
        $("input").attr("disabled", "disabled");
        $(":text").addClass("dis");
        $(":submit, :reset").addClass("bds");
        $("#ball :checkbox:checked").attr("checked", false)
    }
    this.status = a
}
;
SWlian.prototype.uncheck = function() {
    this.checked = [];
    this.balls.removeAttr("checked").removeAttr("disabled");
    $("#sum").val("")
}
;
SWlian.prototype.ball_click = function(b) {
    this.checked = $("#ball input:checked");
    var a = $("#ball input:not(:checked)");
    if (this.checked.length >= 9) {
        a.attr("disabled", "disabled")
    } else {
        a.removeAttr("disabled")
    }
    if (this.type == "tuotou" && b.checked && this.checked.length < this.limit) {
        b.disabled = true
    }
}
;
SWlian.prototype.get_choose = function() {
    this.choose_number = [];
    this.choose = [];
    this.choose_dan = [];
    var b = this.checked;
    for (var a = 0; a < b.length; a++) {
        if (b[a].disabled) {
            this.choose_dan.push(b[a].value)
        } else {
            this.choose.push(b[a].value)
        }
        this.choose_number.push(b[a].value)
    }
    var c = this.type == "fushi" ? $.assemble(this.choose.sort(function(f, d) {
                return f - d
            }
        ), this.limit) : $.assemble_array2(this.choose_dan, this.choose);
    return c
}
;
SWlian.prototype.get_min_odds = function(g) {
    var b = document.getElementById(this.game_ids + g[0]).innerHTML;
    var d = parseFloat(b);
    var h = b + "|" + g[0];
    for (var c = 1; c < g.length; c++) {
        var f = document.getElementById(this.game_ids + g[c]).innerHTML;
        var a = parseFloat(f);
        if (a < d) {
            d = a;
            h = f + "|" + g[c]
        }
    }
    return h
}
;
SWlian.prototype.submit_bet = function() {
    if (this.checked.length < this.limit) {
        alert(this.play_value + "至少需要选择" + this.limit + "项");
        return
    }
    this.orders = [];
    var n = document.getElementById("sum");
    if ($.isInt(n.value)) {
        var h = this.get_choose();
        var m = [];
        var p = [];
        var r = [];
        var q = [];
        var l = [];
        if (this.type != "tuotou") {
            this.choose_number.sort(function(j, i) {
                    return j - i
                }
            )
        }
        for (var g = 0; g < this.choose_number.length; g++) {
            var s = document.getElementById(this.game_ids + this.choose_number[g]).innerHTML;
            if (!$.isPfloat(parseFloat(s))) {
                alert("{#|8d54|7387#}不正确，请刷新页面后重新提交！".keyComment());
                return false
            }
            m.push(s);
            if (this.id === "shengxiaolian") {
                r.push($.cfg_number_shengxiao[this.choose_number[g]])
            } else {
                r.push(this.choose_number[g].substr(1) + "尾")
            }
        }
        var b = "1";
        var f = "";
        var c = "";
        if (this.type == "tuotou") {
            m = [];
            b = "4" + this.choose_dan.join(",");
            for (g = 0; g < this.choose_dan.length; g++) {
                if (this.id === "shengxiaolian") {
                    q.push($.cfg_number_shengxiao[this.choose_dan[g]])
                } else {
                    q.push(this.choose_dan[g].substr(1) + "尾")
                }
                m.push(document.getElementById(this.game_ids + this.choose_dan[g]).innerHTML)
            }
            for (g = 0; g < this.choose.length; g++) {
                if (this.id === "shengxiaolian") {
                    l.push($.cfg_number_shengxiao[this.choose[g]])
                } else {
                    l.push(this.choose[g].substr(1) + "尾")
                }
                m.push(document.getElementById(this.game_ids + this.choose[g]).innerHTML)
            }
            f = q.join(",") + "[拖]" + l.join(",");
            c = this.choose_dan.join(",") + "," + this.choose.join(",")
        } else {
            f = r.join(",");
            c = this.choose_number.join(",")
        }
        var o = [];
        var a = [];
        var k = [];
        var d;
        for (g = 0; g < h.length; g++) {
            o = h[g].split(" ");
            a = [];
            p[h[g]] = (this.get_min_odds(o));
            for (d = 0; d < o.length; d++) {
                if (this.id === "shengxiaolian") {
                    a.push($.cfg_number_shengxiao[o[d]])
                } else {
                    a.push(o[d].substr(1) + "尾")
                }
            }
            k.push(a.join(" "))
        }
        this.orders.push({
            no: f,
            key: this.game_ids,
            odds: m.join(","),
            amount: n.value,
            nos: c,
            assemble_odd: p,
            show_arr: k,
            ordertype: b
        });
        parent.$.trigger("showneworder", {
            gameId: this.id,
            order: this.orders,
            odds_set: this.odds_set,
            game: this.play_value,
            footer: h
        })
    } else {
        alert("请输入一个整数金额");
        n.select()
    }
}
;
if (document.uniqueID && !window.XMLHttpRequest) {
    try {
        document.execCommand("BackgroundImageCache", false, true)
    } catch (e) {}
}
var loadTime = (new Date()).getTime();
if (document.all && !opener) {
    window.onbeforeunload = function(d) {
        d = d || window.event;
        var g = d.screenX - window.screenLeft;
        var a = g > document.documentElement.scrollWidth - 20;
        if (a && d.clientY < 0 || d.altKey) {
            $.get("ajax_req.htm?act=dstry")
        } else {
            if (document.getElementById("header")) {
                var f = new Date();
                var c = 10 - parseInt((f.getTime() - loadTime) / 1000);
                if (c > 0 && $.isOpTime(f)) {
                    return "{#|6295|6ce8#}期间，刷新本系统请间隔在10秒以上".keyComment()
                }
            }
        }
    }
}
try {
    $.extend(window.setting)
} catch (ex) {}
$.ajaxSetup({
    cache: false,
    global: false,
    error: function(c, g, f) {
        var a = function() {
                if (parent) {
                    parent.location.href = $.login_path
                } else {
                    location.href = $.login_path
                }
            }
            ;
        if (typeof (c.responseText) == "string") {
            if (c.responseText == "Duplicate session") {
                alert("您已经在其它地方登录");
                a()
            }
            if (c.responseText == "Lost session") {
                a()
            }
            if (c.responseText.indexOf("<error/>") >= 0) {
                a()
            }
            /*if (c.responseText.indexOf("404") >= 0) {
                if (parent) {
                    parent.location.href = "/error"
                } else {
                    location.href = "/error"
                }
            }*/
            if (c.responseText.indexOf("页面请求太频繁") > -1) {
                var b = document;
                if (top != self) {
                    b = parent.document
                }
                b.body.innerHTML = "页面请求太频繁，请不要频繁刷新，稍候再访问。"
            }
        }
        if (this.url && this.url.indexOf("act=get_odds") > 0) {
            parent.$.trigger("ajaxconnect", [-1])
        }
        if (window.console) {
            console.info(c, g, f)
        }
    },
    timeout: 22000,
    dataFilter: function(c, b) {
        if (typeof c === "string") {
            if (c.indexOf("window.top.location.href") > -1) {
                var a = window;
                while (a.top !== a.self) {
                    a = a.top
                }
                a.location.href = c.split('"')[3]
            }
            if (c == "corpStop") {
                if (parent) {
                    parent.document.body.innerHTML = "公司停用"
                } else {
                    document.body.innerHTML = "公司停用"
                }
            }
        }
        return c
    }
});
$.extend({
    multiple: function(j) {
        var f = $(j)
            , g = $(":checkbox", f)
            , i = $(":radio", f)
            , a = {
                hundred: 100,
                thousand: 1000,
                t_thousand: 10000
            }
            , k = 1
            , c = function(m) {
                var d = parseInt(m.value, 10);
                if (!isNaN(d)) {
                    m.value = d * k
                }
            }
            , h = false
            , l = function(d) {
                if (play && play.sumCtl) {
                    if (!d) {
                        play.sumCtl.unbind("blur");
                        h = false
                    } else {
                        if (!h) {
                            play.sumCtl.bind("blur", function(m) {
                                    if (m.type === "blur") {
                                        c(m.target)
                                    }
                                }
                            );
                            h = true
                        }
                    }
                }
            }
            , b = function() {
                var m = parent.header
                    , d = m ? m.multiple : null ;
                if (m && d) {
                    if (d.isMultiple) {
                        g.attr("checked", true);
                        if (!g[0].disabled) {
                            i.removeAttr("disabled")
                        }
                        k = a[d.multiple]
                    } else {
                        i.attr("disabled", "disabled")
                    }
                    i.removeAttr("checked").filter("#" + d.multiple).attr("checked", true)
                }
            }
            ;
        f.click(function(o) {
                var m = o.target
                    , d = {
                    isMultiple: true,
                    multiple: ""
                }
                    , n = g;
                rMultiple = i;
                if (m.type === "checkbox") {
                    if (m.checked === true) {
                        rMultiple.removeAttr("disabled");
                        k = a[rMultiple.filter(":checked", f).val()]
                    } else {
                        rMultiple.attr("disabled", "disabled");
                        k = 1
                    }
                }
                if (m.type === "radio") {
                    k = a[m.value]
                }
                if (m.nodeName === "INPUT") {
                    d.isMultiple = n[0].checked;
                    d.multiple = rMultiple.filter(":checked", f).val();
                    parent.$.trigger("multiple", [d])
                }
            }
        );
        if (play && play.sumCtl) {
            play.sumCtl.bind("keypress focus", function(d) {
                    if (d.type === "keypress" && d.keyCode === 13) {
                        $(d.target).triggerHandler("blur");
                        l(false);
                        h = false
                    }
                    if (d.type === "focus") {
                        l(true)
                    }
                }
            );
            l(true)
        }
        $.bind("renderMul", b);
        b()
    },
    loginCheck: function(f) {
        var c = f.getElementsByTagName("form")[0];
        $(":text,:password", c).val("");
        var b;
        $(c.name).focus(function() {
                if (b) {
                    clearInterval(b);
                    b = null
                }
                if (!c.password.value) {
                    b = setInterval(function() {
                            c.password.value = ""
                        }
                        , 99)
                }
            }
        ).blur(function() {
                if (b) {
                    clearInterval(b);
                    c.password.value = "";
                    b = null
                }
            }
        );
        if (c.status.value != "init") {
            var a = parseInt(c.status.value, 10);
            if (a == 2) {
                alert("账号或密码有误")
            } else {
                if (a < 0 && a > -5) {
                    alert("账号或密码有误")
                } else {
                    alert("账号已经被停用，请联系管理员.")
                }
            }
        }
        setTimeout(function() {
                c.name.focus()
            }
            , 0);
        c.onsubmit = function() {
            if (!$.validateForm(this)) {
                return false
            }
        }
    },
    loginAddress: function(j) {
        var o = $(j)
            , k = 0
            , g = $("#addresses")
            , c = [].concat(logCity || [])
            , m = []
            , i = '<tr><td class="bg">地址<span>{index}</span>：</td><td>{select}</td></tr>'
            , f = '   <a href="javascript:" class="del_address">删除</a>';
        function l(d, s) {
            var t, r = "", q = ["<option value='null'>请选择</option>"], p = "<option {selected} value='{value}'>{name}</option>";
            for (t in d) {
                if (t === s) {
                    r = "selected"
                } else {
                    r = ""
                }
                q.push(p.replace("{value}", t).replace("{name}", d[t].name || d[t]).replace("{selected}", r))
            }
            if (q.length == 2) {
                q.shift()
            }
            return q.join("")
        }
        function h(d, r) {
            var q = []
                , p = k++;
            d,
                pidSelect = "<select  id='pid_" + p + "' >{options}</select>",
                cidSelect = "<select  id='cid_" + p + "' >{options}</select>";
            if (r && d) {
                q = cityInfo[d].city
            }
            pidSelect = pidSelect.replace("{options}", l(cityInfo, d));
            cidSelect = cidSelect.replace("{options}", l(q, r));
            return pidSelect + cidSelect
        }
        function a(q) {
            var r, t = [], p = q || [];
            if (q.length === 0) {
                t.push(i.replace("{index}", 1).replace("{select}", h()))
            } else {
                for (var d = 0, s = q.length; d < s; d++) {
                    r = q[d].split("|");
                    m.push(r[1]);
                    t.push(i.replace("{index}", d + 1).replace("{select}", h(r[0], r[1]) + (d !== 0 ? f : "")))
                }
            }
            return t.join("")
        }
        function n() {
            var p = g.find("select")
                , d = [];
            $.each(p, function(q, r) {
                    if (/pid/.test(this.id)) {
                        var t = this.id.replace("pid_", "")
                            , s = document.getElementById("cid_" + t);
                        if (this.value !== "null" && s.value !== "null") {
                            d.push(s.value)
                        }
                    }
                }
            );
            return d
        }
        o.delegate("select", "change", function() {
                if (/pid/.test(this.id)) {
                    if (this.value === "null") {
                        $("#" + this.id.replace("pid", "cid")).html("<option value='null'>请选择</option>");
                        return
                    }
                    $("#" + this.id.replace("pid", "cid")).html(l(cityInfo[this.value].city))
                }
            }
        );
        o.delegate("a", "click", function() {
                if (this.className === "del_address") {
                    $(this).closest("tr").remove();
                    g.find("span").html(function(p) {
                            return p + 1
                        }
                    )
                }
                if (this.id === "add_address") {
                    var d = g.find("tr").length;
                    if (d === 5) {
                        alert("最多允许添加5个地点！");
                        return false
                    }
                    g.append(i.replace("{index}", d + 1).replace("{select}", h() + f))
                }
            }
        );
        $("form", o).bind("reset", function() {
                g.html(a(c))
            }
        ).bind("submit", function() {
                var u = document.getElementById("use_address")
                    , d = false
                    , s = false
                    , q = {};
                if (u.checked !== u.defaultChecked) {
                    d = true
                }
                var t = n();
                if (t.length === 0) {
                    alert("至少选择一个常用登录地址");
                    return false
                }
                for (var p = 0, r = t.length; p < r; p++) {
                    if (q[t[p]]) {
                        alert("请删除相同的地址!");
                        return false
                    }
                    q[t[p]] = 1;
                    if (m[p] !== t[p]) {
                        s = true
                    }
                }
                if (r !== m.length) {
                    s = true
                }
                if (d === false && s === false) {
                    alert("请修改后保存");
                    return false
                }
                if (s) {
                    this.insertAdjacentHTML("beforeEnd", '<input name="city" type="hidden" value="' + t.join("|") + '">')
                }
                if (d) {
                    this.insertAdjacentHTML("beforeEnd", '<input name="use_address" type="hidden" value="' + (u.checked ? "1" : "0") + '">')
                }
            }
        );
        g.html(a(c));
        var b = document.getElementsByName("status")[0].value;
        if (b === "success") {
            alert("保存成功")
        }
    },
    resetPassword: function(i) {
        var f = document.forms[0], h = $("#show_ip"), a = $("#diff_ip"), j = function() {
            clearTimeout(c);
            h.hide();
            document.cookie = "showIP=" + escape("1") + ";path=/" + location.pathname.split("/")[1]
        }
            , c;
        if (document.cookie.indexOf("showIP") == -1) {
            h.show();
            $("#show_ip_close").click(j);
            c = setTimeout(j, 5000)
        }
        if (a.length) {
            var b = $("<iframe allowTransparency='true' class='show_ip_shadow'></iframe>").appendTo("body");
            b.css("height", document.documentElement.scrollHeight + "px");
            a.show();
            $("button", a).click(function() {
                    a.remove();
                    b.remove()
                }
            );
            a.delegate("a", "click", function() {
                    a.remove();
                    b.remove()
                }
            )
        }
        setTimeout(function() {
                f.oldpwd.focus()
            }
            , 0);
        $("#cancel").click(function() {
                location.replace("logout.htm")
            }
        );
        f.onsubmit = function() {
            var d = function(k) {
                    if (k.newpwd1.value != k.newpwd2.value) {
                        alert("新密码与确认密码输入不一致");
                        k.newpwd1.select();
                        return false
                    }
                    if (k.oldpwd.value == k.newpwd1.value) {
                        alert("新密码与旧密码不能相同");
                        setTimeout(function() {
                                f.newpwd1.focus()
                            }
                            , 0);
                        return false
                    }
                }
                ;
            return $.validateForm(this) && d(this)
        }
        ;
        switch (f.status.value) {
            case "2":
                alert("新密码与确认密码输入不一致");
                f.newpwd1.select();
                break;
            case "3":
                alert("旧密码输入错误");
                f.oldpwd.select();
                break;
            case "5":
                alert("为了账号安全，密码不能和账号相同");
                f.newpwd1.select();
                break;
            case "6":
                if ($.isStrongPwd) {
                    alert("1.密码长度为6-12位，必须包含字母和数字；\n2.不能使用常用密码。")
                } else {
                    alert("1.密码长度为8-12位，必须包含字母和数字；\n2.密码连续3位不得重複；\n3.不能使用常用密碼。\n4.密码不可包含键盘横向连续三个字元, 范例: 不可包含有 123, ghj, xcv 等连续三个字元. \n5.密码不可包含键盘直向连续四个字元, 范例: 不可包含有 1qaz, 2wsx, 3edc 等连续四个字元. \n以下规则大小写视为相同字符:\n6.密码不可包含2组重複且连续的英文或数字, 反向也不行, 范例: 不可包含 aabb, 7788, 0099, ZZYY 等字元.\n7.密码不可包含3位连续的字元, 反向也不行, 范例: 不可包含 123, abc, CBA 等字元.\n")
                }
                f.newpwd1.select();
                break;
            case "4":
                alert("密码修改成功");
                if ("0" == f.title.value) {
                    location.replace("../index.htm")
                }
                break;
            case "7":
                alert("密码修改成功");
                location.replace("../index.htm");
                break;
            default:
                break
        }
        var g = $("<div></div>");
        g.css({
            position: "absolute",
            top: 0,
            left: 0,
            width: "100%",
            height: "100%",
            opacity: 0.3,
            background: "white",
            display: "none"
        }).prependTo(document.body);
        $("#oftenPasswordBtn").click(function(k) {
                g.show();
                var d = $("#drkusukp").show();
                d.css({
                    marginLeft: -1 * d.width() / 2,
                    marginTop: -1 * d.height() / 2
                })
            }
        );
        $("#oftenPasswordcancel").click(function() {
                $("#drkusukp").hide();
                g.hide()
            }
        )
    },
    resizeFrame: function(c) {
        var b = 0;
        var a = function() {
                var d;
                try {
                    d = (document.documentElement.clientHeight || document.body.clientHeight) - $(c).offset().top
                } catch (f) {}
                if (d !== b && d > 0) {
                    c.style.height = d + "px";
                    b = d
                }
                try {
                    document.documentElement.scrollTop = 0
                } catch (f) {}
            }
            ;
        $(window).resize(a);
        a()
    },
    protocol: function(a) {
        $(a).click(function(d) {
                var b = d.target;
                var c = b.getAttribute("href");
                if (c && "INPUT" == b.tagName) {
                    window.open(c, "_self")
                }
                if (document.cookie.indexOf("multiple") > -1) {
                    document.cookie = "multiple=" + escape("0|hundred") + ";path=/"
                }
            }
        );
        $(document).keydown(function(b) {
                if (13 == b.keyCode) {
                    $(a.getElementsByTagName("input")[0]).trigger("click")
                }
            }
        )
    },
    popLink: function(a) {
        $(a).click(function(h) {
                var b = $(h.target);
                if ("popup" === b.attr("target") && b.attr("href")) {
                    var d = (b.attr("fix") || "").split("|");
                    var g = b.attr("game_id");
                    if ("047" <= g && "052" >= g) {
                        var c = parseInt(d[0]) + 110 + 200
                    } else {
                        var c = parseInt(d[0]) + 110
                    }
                    var f = parseInt(d[1]) - 200;
                    JqueryDialog.Open1("{#|73a9|6cd5#}明细".keyComment(), b.attr("href"), c, f, false, true);
                    return false
                }
            }
        )
    },
    xiazhumsg: function(g) {
        var f = $("#check_number");
        var c = $("select[name='categoryId']");
        var b = $("input[name='to_link']");
        b.click(function(d) {
                radioValue = d.target.value;
                a(radioValue)
            }
        );
        var a = function(d) {
                location.replace(d)
            }
            ;
        c.change(function(k) {
                var j = c.val();
                var i = window.location.href;
                var h = i.indexOf("categoryId");
                if (h != -1) {
                    i = i.substring(0, h - 1)
                }
                if (i.indexOf("?") != -1) {
                    a(i + "&categoryId=" + j)
                } else {
                    a(i + "?categoryId=" + j)
                }
            }
        )
    },
    catch_inpt: function() {
        if (document.getElementById("psdlist") || document.getElementById("login")) {
            return
        }
        var a = $(":text");
        a.attr("maxlength", "9");
        a.attr("autocomplete", "off")
    },
    color4table: function() {
        $("tbody[movod='movod'] tr").hover(function() {
                $("td", this).addClass("new_odd")
            }
            , function() {
                $(".new_odd").removeClass("new_odd")
            }
        )
    },
    cancelRefersh: function() {
        $(document).keydown(function(c) {
                if (!!document.all && ((window.event.keyCode == 116) || (window.event.ctrlKey && window.event.keyCode == 82))) {
                    var b = new Date();
                    var a = 10 - parseInt((b.getTime() - loadTime) / 1000);
                    if (a > 0 && $.isOpTime(b)) {
                        window.event.keyCode = 0;
                        window.event.returnValue = false;
                        alert("{#|6295|6ce8#}期间，刷新本系统请间隔在10秒以上".keyComment())
                    }
                } else {
                    if (c.keyCode == 116 || (c.keyCode == 82 && c.ctrlKey)) {
                        var b = new Date();
                        var a = 10 - parseInt((b.getTime() - loadTime) / 1000);
                        if (a > 0 && $.isOpTime(b)) {
                            c.returnValue = false;
                            c.cancelBubble = true;
                            alert("{#|6295|6ce8#}期间，刷新本系统请间隔在10秒以上".keyComment());
                            return false
                        }
                    }
                }
            }
        )
    },
    last_update: {},
    game_ids: 0,
    refersh: function(c) {
        var b = c.status[$.game_ids]
            , a = play.refreshCtl || $("input");
        if ($.last_update.status && b != $.last_update.status[$.game_ids]) {
            if (0 === b) {
                a.attr("disabled", "disabled");
                $(":text").addClass("dis");
                $(":submit, :reset").addClass("bds");
                $(":checkbox:checked").attr("checked", false);
                $("#w_fast :radio").attr("disabled", "disabled")
            } else {
                a.removeAttr("disabled").removeClass("dis").removeClass("bds");
                $("#w_fast :radio").removeAttr("disabled");
                $.trigger("renderMul")
            }
        }
        $.last_update = c;
        parent.$.trigger("cpsset", [{
            timestamp: c.time_stamp
        }]);
        $.refersh_odds_header(c)
    },
    refersh_odds_header: function(a) {
        $.refersh_odds(a.odds);
        if (a.header) {
            parent.header.set_header_info(a.header)
        }
        if (a.time_stamp) {
            $.last_update.time_stamp = a.time_stamp
        }
    },
    refersh_odds: function(b) {
        var d = [];
        for (var c in b) {
            if (b.hasOwnProperty(c)) {
                var a = document.getElementById(c);
                if (!a) {
                    continue
                }
                if (a.innerHTML !== b[c]) {
                    d.push(a);
                    a.innerHTML = b[c]
                }
            }
        }
        $.lightOn(d)
    },
    ontime: function() {
        return parent.header.lock_submit
    },
    show_calc_status: function(a) {
        a = parseInt(a, 10);
        if (-1 == a) {
            if (!$("#rptprg").hasClass("hid")) {
                $.progress(8)
            }
        } else {
            $.progress(a)
        }
    },
    xiazhumsg_header_info: function(b) {
        var a = $("#xiazhumsg_header_info").val();
        if (a) {
            a = $.evalJSON(a);
            if (parent != window) {
                parent.header.set_header_info(a)
            }
        }
    },
    c_re_pgs: 0,
    is_delay_time: false,
    progress: function(d) {
        var a = [0, 20, 30, 50, 60, 70, 80, 90, 100, 100];
        $("#rptprg").removeClass("hid");
        var b = function() {
                $.is_delay_time = true;
                setTimeout(function() {
                        $.is_delay_time = false;
                        $("#rptprg").addClass("hid");
                        $.c_re_pgs = 0
                    }
                    , 3000)
            }
            ;
        if (8 == d && !$.is_delay_time) {
            b()
        }
        $.c_re_pgs = $.c_re_pgs < a[d] ? a[d] : $.c_re_pgs;
        var c = setInterval(function() {
                if ($.c_re_pgs == a[d + 1]) {
                    $("#progress").text($.c_re_pgs)
                }
                if ($.c_re_pgs == 100) {
                    b()
                }
                if ($.c_re_pgs < a[d + 1]) {
                    $("#progress").text($.c_re_pgs++)
                } else {
                    clearInterval(c);
                    c = null
                }
            }
            , $.time_result_progress)
    }
});
var header = "";
var play = "";
var init = {
    ready_count: 1,
    ready_timmer: null ,
    cover: new Cover("#fff",0.01,4),
    ready_try: function() {
        if ((self == top) || (parent.header && parent.header.init_ok)) {
            init.ready()
        } else {
            if (init.ready_timmer) {
                clearTimeout(init.ready_timmer)
            }
            init.ready_count++;
            init.ready_timmer = setTimeout(function() {
                    init.ready_try()
                }
                , 500);
            if (init.ready_count == 6) {
                init.cover.setStr("您可能遇到网络问题，请继续等待，或<a herf='' onclick='location.replace(location.href);'>刷新</a><span class='loadding2'/>")
            }
        }
    },
    ready: function() {
        $(document).ready(function() {
                var a = function(d, c) {
                    var f = document.getElementById(d);
                    if (f) {
                        c(f)
                    }
                }
                    , b = location.search;
                if (b && top === self) {
                    window.document.onkeydown = function(c) {
                        var d = window.event || c;
                        if (d.keyCode === 116) {
                            if (d.preventDefault) {
                                d.preventDefault()
                            } else {
                                d.keyCode = 0;
                                d.returnValue = false
                            }
                            location.href = location.href.replace(b, "");
                            return false
                        }
                    }
                } else {
                    if (top !== self) {
                        b = top.location.search;
                        if (b) {
                            window.document.onkeydown = function(c) {
                                var d = window.event || c;
                                if (d.keyCode === 116) {
                                    if (d.preventDefault) {
                                        d.preventDefault()
                                    } else {
                                        d.keyCode = 0;
                                        d.returnValue = false
                                    }
                                    top.location.href = top.location.href.replace(b, "");
                                    return false
                                }
                            }
                        }
                    }
                }
                a("main", $.resizeFrame);
                a("protocol", $.protocol);
                a("xiazhumsg", $.xiazhumsg);
                a("xiazhumsg", $.popLink);
                a("xiazhumsg_header_info", $.xiazhumsg_header_info);
                a("loginAddress", $.loginAddress);
                a("psdlist", $.resetPassword);
                a("header", function(c) {
                        header = new Header(c)
                    }
                );
                a("tema", function(c) {
                        play = new PlaysBall(c)
                    }
                );
                a("zhengma", function(c) {
                        play = new PlaysBall(c)
                    }
                );
                a("zhengmate1", function(c) {
                        play = new PlaysBall(c)
                    }
                );
                a("zhengmate2", function(c) {
                        play = new PlaysBall(c)
                    }
                );
                a("zhengmate3", function(c) {
                        play = new PlaysBall(c)
                    }
                );
                a("zhengmate4", function(c) {
                        play = new PlaysBall(c)
                    }
                );
                a("zhengmate5", function(c) {
                        play = new PlaysBall(c)
                    }
                );
                a("zhengmate6", function(c) {
                        play = new PlaysBall(c)
                    }
                );
                a("shengxiao", function(c) {
                        play = new PlaysGroup(c)
                    }
                );
                a("shengxiaobuzhong", function(c) {
                        play = new PlaysGroup(c)
                    }
                );
                a("zhengma1to6", function(c) {
                        play = new PlaysGroup(c)
                    }
                );
                a("weishu", function(c) {
                        play = new PlaysGroup(c)
                    }
                );
                a("banbo", function(c) {
                        play = new PlaysGroup(c)
                    }
                );
                a("texiao", function(c) {
                        play = new PlaysGroup(c)
                    }
                );
                a("lianma", function(c) {
                        play = new Lianma(c)
                    }
                );
                a("liuxiao", function(c) {
                        play = new Liuxiao(c)
                    }
                );
                a("guoguan", function(c) {
                        play = new Guoguan(c)
                    }
                );
                a("buzhong", function(c) {
                        play = new Buzhong(c)
                    }
                );
                a("weishulian", function(c) {
                        play = new SWlian(c)
                    }
                );
                a("shengxiaolian", function(c) {
                        play = new SWlian(c)
                    }
                );
                a("testline", function(c) {
                        play = new TestLine(c)
                    }
                );
                a("multiple", $.multiple);
                $.catch_inpt();
                $.color4table();
                $.cancelRefersh();
                init.cover.hide()
            }
        )
    }
};
init.cover.setStr("加载中，请稍候...<span class='loadding2'/>");
init.cover.show();
if (document.getElementById("htmlcover")) {
    document.getElementById("htmlcover").style.display = "none"
}
if (!document.getElementById("popupWindow")) {
    init.ready_try()
} else {
    init.ready()
}
;