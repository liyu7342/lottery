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
        return i ? e(a[0], b) : w
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
            for (r = j.length; n < r; n++)
                for (k = 0; k < u.length; k++) {
                    i = u[k];
                    if (j[n].selector === i.selector) {
                        o = j[n].elem;
                        f = null;
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
        return "live." + (a && a !== "*" ? a + "." : "") + b.replace(/\./g, "`").replace(/ /g, "&")
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
        })
    }
    function sa(a, b, d) {
        var f, e, j;
        b = b && b[0] ? b[0].ownerDocument || b[0] : s;
        if (a.length === 1 && typeof a[0] === "string" && a[0].length < 512 && b === s && !ta.test(a[0]) && (c.support.checkClone || !ua.test(a[0]))) {
            e = true;
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
        });
        return d
    }
    function wa(a) {
        return "scrollTo"in a && a.document ? a : a.nodeType === 9 ? a.defaultView || a.parentWindow : false
    }
    var c = function(a, b) {
        return new c.fn.init(a,b)
    }, Ra = A.jQuery, Sa = A.$, s = A.document, T, Ta = /^[^<]*(<[\w\W]+>)[^>]*$|^#([\w-]+)$/, Ua = /^.[^:#\[\.,]*$/, Va = /\S/, Wa = /^(\s|\u00A0)+|(\s|\u00A0)+$/g, Xa = /^<(\w+)\s*\/?>(?:<\/\1>)?$/, P = navigator.userAgent, xa = false, Q = [], L, $ = Object.prototype.toString, aa = Object.prototype.hasOwnProperty, ba = Array.prototype.push, R = Array.prototype.slice, ya = Array.prototype.indexOf;
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
                if ((d = Ta.exec(a)) && (d[1] || !b))
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
                    return c.merge(this, a)
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
            return a == null ? this.toArray() : a < 0 ? this.slice(a)[0] : this[a]
        },
        pushStack: function(a, b, d) {
            var f = c();
            c.isArray(a) ? ba.apply(f, a) : c.merge(f, a);
            f.prevObject = this;
            f.context = this.context;
            if (b === "find")
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
            return this.pushStack(c.map(this, function(b, d) {
                return a.call(b, d, b)
            }))
        },
        end: function() {
            return this.prevObject || c(null)
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
            if ((e = arguments[b]) != null)
                for (j in e) {
                    i = a[j];
                    o = e[j];
                    if (a !== o)
                        if (f && o && (c.isPlainObject(o) || c.isArray(o))) {
                            i = i && (c.isPlainObject(i) || c.isArray(i)) ? i : c.isArray(o) ? [] : {};
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
                    s.addEventListener("DOMContentLoaded", L, false);
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
            if (a.constructor && !aa.call(a, "constructor") && !aa.call(a.constructor.prototype, "isPrototypeOf"))
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
                return null;
            a = c.trim(a);
            if (/^[\],:{}\s]*$/.test(a.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, "")))
                return A.JSON && A.JSON.parse ? A.JSON.parse(a) : (new Function("return " + a))();
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
                        if (b.apply(a[f], d) === false)
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
            if (a != null)
                a.length == null || typeof a === "string" || c.isFunction(a) || typeof a !== "function" && a.setInterval ? ba.call(b, a) : c.merge(b, a);
            return b
        },
        inArray: function(a, b) {
            if (b.indexOf)
                return b.indexOf(a);
            for (var d = 0, f = b.length; d < f; d++)
                if (b[d] === a)
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
                if (e != null)
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
                } else if (b && !c.isFunction(b)) {
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
        c.browser.safari = true;
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
                parentNode: d.removeChild(d.appendChild(s.createElement("div"))).parentNode === null,
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
                    c.support.noCloneEvent = false;
                    d.detachEvent("onclick", k)
                });
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
            });
            a = function(k) {
                var n = s.createElement("div");
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
    })();
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
                    return null;
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
                });
            var d = a.split(".");
            d[1] = d[1] ? "." + d[1] : "";
            if (b === w) {
                var f = this.triggerHandler("getData" + d[1] + "!", [d[0]]);
                if (f === w && this.length)
                    f = c.data(this[0], a);
                return f === w && d[1] ? this.data(d[0]) : f
            } else
                return this.trigger("setData" + d[1] + "!", [d[0], b]).each(function() {
                    c.data(this, a, b)
                })
        },
        removeData: function(a) {
            return this.each(function() {
                c.removeData(this, a)
            })
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
                })
            }
        }
    });
    c.fn.extend({
        queue: function(a, b) {
            if (typeof a !== "string") {
                b = a;
                a = "fx"
            }
            if (b === w)
                return c.queue(this[0], a);
            return this.each(function() {
                var d = c.queue(this, a, b);
                a === "fx" && d[0] !== "inprogress" && c.dequeue(this, a)
            })
        },
        dequeue: function(a) {
            return this.each(function() {
                c.dequeue(this, a)
            })
        },
        delay: function(a, b) {
            a = c.fx ? c.fx.speeds[a] || a : a;
            b = b || "fx";
            return this.queue(b, function() {
                var d = this;
                setTimeout(function() {
                    c.dequeue(d, b)
                }, a)
            })
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
        , cb = /^(a|area)$/i
        , Ba = /radio|checkbox/;
    c.fn.extend({
        attr: function(a, b) {
            return X(this, a, b, true, c.attr)
        },
        removeAttr: function(a) {
            return this.each(function() {
                c.attr(this, a, "");
                this.nodeType === 1 && this.removeAttribute(a)
            })
        },
        addClass: function(a) {
            if (c.isFunction(a))
                return this.each(function(n) {
                    var r = c(this);
                    r.addClass(a.call(this, n, r.attr("class")))
                });
            if (a && typeof a === "string")
                for (var b = (a || "").split(ca), d = 0, f = this.length; d < f; d++) {
                    var e = this[d];
                    if (e.nodeType === 1)
                        if (e.className) {
                            for (var j = " " + e.className + " ", i = e.className, o = 0, k = b.length; o < k; o++)
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
                });
            if (a && typeof a === "string" || a === w)
                for (var b = (a || "").split(ca), d = 0, f = this.length; d < f; d++) {
                    var e = this[d];
                    if (e.nodeType === 1 && e.className)
                        if (a) {
                            for (var j = (" " + e.className + " ").replace(Aa, " "), i = 0, o = b.length; i < o; i++)
                                j = j.replace(" " + b[i] + " ", " ");
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
                });
            return this.each(function() {
                if (d === "string")
                    for (var e, j = 0, i = c(this), o = b, k = a.split(ca); e = k[j++]; ) {
                        o = f ? o : !i.hasClass(e);
                        i[o ? "addClass" : "removeClass"](e)
                    }
                else if (d === "undefined" || d === "boolean") {
                    this.className && c.data(this, "__className__", this.className);
                    this.className = this.className || a === false ? "" : c.data(this, "__className__") || ""
                }
            })
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
                            return null;
                        var j = b ? d : 0;
                        for (d = b ? d + 1 : e.length; j < d; j++) {
                            var i = e[j];
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
                        return b.getAttribute("value") === null ? "on" : b.value;
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
                            this.selected = c.inArray(c(this).val(), u) >= 0
                        });
                        if (!u.length)
                            this.selectedIndex = -1
                    } else
                        this.value = r
                }
            })
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
                return a === null ? w : a
            }
            return c.style(a, b, d)
        }
    });
    var O = /\.(.*)$/
        , db = function(a) {
        return a.replace(/[^\w\s\.\|`]/g, function(b) {
            return "\\" + b
        })
    };
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
                var e, j = 0, i, o, k, n, r, u, z = c.data(a), C = z && z.events;
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
                                                f == null && r.splice(B--, 1);
                                                n.remove && n.remove.call(a, u)
                                            }
                                            if (f != null)
                                                break
                                        }
                                    }
                                    if (r.length === 0 || f != null && r.length === 1) {
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
                                b.elem = null;
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
                    a.type = e = e.slice(0, -1);
                    a.exclusive = true
                }
                if (!d) {
                    a.stopPropagation();
                    c.event.global[e] && c.each(c.cache, function() {
                        this.events && this.events[e] && c.event.trigger(a, b, this.handle.elem)
                    })
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
            if (!a.isPropagationStopped() && f)
                c.event.trigger(a, b, f, true);
            else if (!a.isDefaultPrevented()) {
                f = a.target;
                var i, o = c.nodeName(f, "a") && e === "click", k = c.event.special[e] || {};
                if ((!k._default || k._default.call(d, a) === false) && !o && !(f && f.nodeName && c.noData[f.nodeName.toLowerCase()])) {
                    try {
                        if (f[e]) {
                            if (i = f["on" + e])
                                f["on" + e] = null;
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
            if (a.pageX == null && a.clientX != null) {
                b = s.documentElement;
                d = s.body;
                a.pageX = a.clientX + (b && b.scrollLeft || d && d.scrollLeft || 0) - (b && b.clientLeft || d && d.clientLeft || 0);
                a.pageY = a.clientY + (b && b.scrollTop || d && d.scrollTop || 0) - (b && b.clientTop || d && d.clientTop || 0)
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
                    c.each(c.data(this, "events").live || [], function() {
                        if (d === this.origType.replace(O, ""))
                            return b = false
                    });
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
            this.originalEvent = a;
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
    };
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
    });
    if (!c.support.submitBubbles)
        c.event.special.submit = {
            setup: function() {
                if (this.nodeName.toLowerCase() !== "form") {
                    c.event.add(this, "click.specialSubmit", function(a) {
                        var b = a.target
                            , d = b.type;
                        if ((d === "submit" || d === "image") && c(b).closest("form").length)
                            return na("submit", this, arguments)
                    });
                    c.event.add(this, "keypress.specialSubmit", function(a) {
                        var b = a.target
                            , d = b.type;
                        if ((d === "text" || d === "password") && c(b).closest("form").length && a.keyCode === 13)
                            return na("submit", this, arguments)
                    })
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
                    }).join("-") : "";
            else if (a.nodeName.toLowerCase() === "select")
                d = a.selectedIndex;
            return d
        }, fa = function(a, b) {
            var d = a.target, f, e;
            if (!(!da.test(d.nodeName) || d.readOnly)) {
                f = c.data(d, "_change_data");
                e = Fa(d);
                if (a.type !== "focusout" || d.type !== "radio")
                    c.data(d, "_change_data", e);
                if (!(f === w || e === f))
                    if (f != null || e) {
                        a.type = "change";
                        return c.event.trigger(a, b, d)
                    }
            }
        };
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
                    c.data(a, "_change_data", Fa(a))
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
                this.addEventListener(a, d, true)
            },
            teardown: function() {
                this.removeEventListener(a, d, true)
            }
        }
    });
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
                }) : e;
            if (d === "unload" && b !== "one")
                this.one(d, f, e);
            else {
                j = 0;
                for (var o = this.length; j < o; j++)
                    c.event.add(this[j], d, i, f)
            }
            return this
        }
    });
    c.fn.extend({
        unbind: function(a, b) {
            if (typeof a === "object" && !a.preventDefault)
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
            return arguments.length === 0 ? this.unbind("live") : this.die(b, null, d, a)
        },
        trigger: function(a, b) {
            return this.each(function() {
                c.event.trigger(a, b, this)
            })
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
            }))
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
            var i, o = 0, k, n, r = j || this.selector, u = j ? this : c(this.context);
            if (c.isFunction(f)) {
                e = f;
                f = w
            }
            for (d = (d || "").split(" "); (i = d[o++]) != null; ) {
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
                        }) : u.unbind(pa(i, r), e)
                }
            }
            return this
        }
    });
    c.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error".split(" "), function(a, b) {
        c.fn[b] = function(d) {
            return d ? this.bind(b, d) : this.trigger(b)
        }
        ;
        if (c.attrFn)
            c.attrFn[b] = true
    });
    A.attachEvent && !A.addEventListener && A.attachEvent("onunload", function() {
        for (var a in c.cache)
            if (c.cache[a].handle)
                try {
                    c.event.remove(c.cache[a].handle.elem)
                } catch (b) {}
    });
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
            , e = 0
            , j = Object.prototype.toString
            , i = false
            , o = true;
        [0, 0].sort(function() {
            o = false;
            return 0
        });
        var k = function(g, h, l, m) {
            l = l || [];
            var q = h = h || s;
            if (h.nodeType !== 1 && h.nodeType !== 9)
                return [];
            if (!g || typeof g !== "string")
                return l;
            for (var p = [], v, t, y, S, H = true, M = x(h), I = g; (f.exec(""),
                v = f.exec(I)) !== null; ) {
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
                        if (v == null)
                            v = h;
                        n.relative[D](y, v, M)
                    }
                } else
                    y = []
            }
            y || (y = t);
            y || k.error(D || g);
            if (j.call(y) === "[object Array]")
                if (H)
                    if (h && h.nodeType === 1)
                        for (g = 0; y[g] != null; g++) {
                            if (y[g] && (y[g] === true || y[g].nodeType === 1 && E(h, y[g])))
                                l.push(t[g])
                        }
                    else
                        for (g = 0; y[g] != null; g++)
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
        };
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
            return k(g, null, null, h)
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
                        if (m != null) {
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
                    if ((t = n.leftMatch[H].exec(g)) != null && t[2]) {
                        var M = n.filter[H], I, D;
                        D = t[1];
                        y = false;
                        t.splice(1, 1);
                        if (D.substr(D.length - 1) !== "\\") {
                            if (v === p)
                                p = [];
                            if (n.preFilter[H])
                                if (t = n.preFilter[H](t, v, l, p, m, S)) {
                                    if (t === true)
                                        continue
                                } else
                                    y = I = true;
                            if (t)
                                for (var U = 0; (D = v[U]) != null; U++)
                                    if (D) {
                                        I = M(D, t, U, v);
                                        var Ha = m ^ !!I;
                                        if (l && I != null)
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
                    if (y == null)
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
                                g[m] = l ? p.parentNode : p.parentNode === h;
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
                        return l.length === 0 ? null : l
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
                    for (var v; (v = h[p]) != null; p++)
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
                            g[3] = k(g[3], null, null, h);
                        else {
                            g = k.filter(g[3], h, l, true ^ q);
                            l || m.push.apply(m, g);
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
                        h = h[3];
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
                                for (m = p.firstChild; m; m = m.nextSibling)
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
                    g = n.attrHandle[l] ? n.attrHandle[l](g) : g[l] != null ? g[l] : g.getAttribute(l);
                    l = g + "";
                    var m = h[2];
                    h = h[4];
                    return g == null ? m === "!=" : m === "=" ? l === h : m === "*=" ? l.indexOf(h) >= 0 : m === "~=" ? (" " + l + " ").indexOf(h) >= 0 : !h ? l && g !== false : m === "!=" ? l !== h : m === "^=" ? l.indexOf(h) === 0 : m === "$=" ? l.substr(l.length - h.length) === h : m === "|=" ? l === h || l.substr(0, h.length + 1) === h + "-" : false
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
            n.leftMatch[u] = new RegExp(/(^(?:.|\r|\n)*?)/.source + n.match[u].source.replace(/\\(\d+)/g, function(g, h) {
                    return "\\" + (h - 0 + 1)
                }))
        }
        var z = function(g, h) {
            g = Array.prototype.slice.call(g, 0);
            if (h) {
                h.push.apply(h, g);
                return h
            }
            return g
        };
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
                if (!g.compareDocumentPosition || !h.compareDocumentPosition) {
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
        else if ("sourceIndex"in s.documentElement)
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
                    , m = h.ownerDocument.createRange();
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
                        return (q = q.getElementById(m[1])) ? q.id === m[1] || typeof q.getAttributeNode !== "undefined" && q.getAttributeNode("id").nodeValue === m[1] ? [q] : w : []
                }
                ;
                n.filter.ID = function(m, q) {
                    var p = typeof m.getAttributeNode !== "undefined" && m.getAttributeNode("id");
                    return m.nodeType === 1 && p && p.nodeValue === q
                }
            }
            l.removeChild(g);
            l = g = null
        })();
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
        })();
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
        }();
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
        })();
        var E = s.compareDocumentPosition ? function(g, h) {
                return !!(g.compareDocumentPosition(h) & 16)
            }
            : function(g, h) {
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
        };
        c.find = k;
        c.expr = k.selectors;
        c.expr[":"] = c.expr.filters;
        c.unique = k.uniqueSort;
        c.text = a;
        c.isXMLDoc = x;
        c.contains = E
    })();
    var eb = /Until$/
        , fb = /^(?:parents|prevUntil|prevAll)/
        , gb = /,/;
    R = Array.prototype.slice;
    var Ia = function(a, b, d) {
        if (c.isFunction(b))
            return c.grep(a, function(e, j) {
                return !!b.call(e, j, e) === d
            });
        else if (b.nodeType)
            return c.grep(a, function(e) {
                return e === b === d
            });
        else if (typeof b === "string") {
            var f = c.grep(a, function(e) {
                return e.nodeType === 1
            });
            if (Ua.test(b))
                return c.filter(b, f, !d);
            else
                b = c.filter(b, f)
        }
        return c.grep(a, function(e) {
            return c.inArray(e, b) >= 0 === d
        })
    };
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
            })
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
                var d = [], f = this[0], e, j = {}, i;
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
            var k = c.expr.match.POS.test(a) ? c(a, b || this.context) : null;
            return this.map(function(n, r) {
                for (; r && r.ownerDocument && r !== b; ) {
                    if (k ? k.index(r) > -1 : c(r).is(a))
                        return r;
                    r = r.parentNode
                }
                return null
            })
        },
        index: function(a) {
            if (!a || typeof a === "string")
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
            return c.dir(a, "parentNode", d)
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
            return c.nodeName(a, "iframe") ? a.contentDocument || a.contentWindow.document : c.makeArray(a.childNodes)
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
    });
    c.extend({
        filter: function(a, b, d) {
            if (d)
                a = ":not(" + a + ")";
            return c.find.matches(a, b)
        },
        dir: function(a, b, d) {
            var f = [];
            for (a = a[b]; a && a.nodeType !== 9 && (d === w || a.nodeType !== 1 || !c(a).is(d)); ) {
                a.nodeType === 1 && f.push(a);
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
        return hb.test(d) ? a : b + "></" + d + ">"
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
                    var d = c(this);
                    d.text(a.call(this, b, d.text()))
                });
            if (typeof a !== "object" && a !== w)
                return this.empty().append((this[0] && this[0].ownerDocument || s).createTextNode(a));
            return c.text(this)
        },
        wrapAll: function(a) {
            if (c.isFunction(a))
                return this.each(function(d) {
                    c(this).wrapAll(a.call(this, d))
                });
            if (this[0]) {
                var b = c(a, this[0].ownerDocument).eq(0).clone(true);
                this[0].parentNode && b.insertBefore(this[0]);
                b.map(function() {
                    for (var d = this; d.firstChild && d.firstChild.nodeType === 1; )
                        d = d.firstChild;
                    return d
                }).append(this)
            }
            return this
        },
        wrapInner: function(a) {
            if (c.isFunction(a))
                return this.each(function(b) {
                    c(this).wrapInner(a.call(this, b))
                });
            return this.each(function() {
                var b = c(this)
                    , d = b.contents();
                d.length ? d.wrapAll(a) : b.append(a)
            })
        },
        wrap: function(a) {
            return this.each(function() {
                c(this).wrapAll(a)
            })
        },
        unwrap: function() {
            return this.parent().each(function() {
                c.nodeName(this, "body") || c(this).replaceWith(this.childNodes)
            }).end()
        },
        append: function() {
            return this.domManip(arguments, true, function(a) {
                this.nodeType === 1 && this.appendChild(a)
            })
        },
        prepend: function() {
            return this.domManip(arguments, true, function(a) {
                this.nodeType === 1 && this.insertBefore(a, this.firstChild)
            })
        },
        before: function() {
            if (this[0] && this[0].parentNode)
                return this.domManip(arguments, false, function(b) {
                    this.parentNode.insertBefore(b, this)
                });
            else if (arguments.length) {
                var a = c(arguments[0]);
                a.push.apply(a, this.toArray());
                return this.pushStack(a, "before", arguments)
            }
        },
        after: function() {
            if (this[0] && this[0].parentNode)
                return this.domManip(arguments, false, function(b) {
                    this.parentNode.insertBefore(b, this.nextSibling)
                });
            else if (arguments.length) {
                var a = this.pushStack(this, "after", arguments);
                a.push.apply(a, c(arguments[0]).toArray());
                return a
            }
        },
        remove: function(a, b) {
            for (var d = 0, f; (f = this[d]) != null; d++)
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
            for (var a = 0, b; (b = this[a]) != null; a++)
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
            });
            if (a === true) {
                ra(this, b);
                ra(this.find("*"), b.find("*"))
            }
            return b
        },
        html: function(a) {
            if (a === w)
                return this[0] && this[0].nodeType === 1 ? this[0].innerHTML.replace(Ja, "") : null;
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
                        })
                    }) : this.empty().append(a);
            return this
        },
        replaceWith: function(a) {
            if (this[0] && this[0].parentNode) {
                if (c.isFunction(a))
                    return this.each(function(b) {
                        var d = c(this)
                            , f = d.html();
                        d.replaceWith(a.call(this, b, f))
                    });
                if (typeof a !== "string")
                    a = c(a).detach();
                return this.each(function() {
                    var b = this.nextSibling
                        , d = this.parentNode;
                    c(this).remove();
                    b ? c(b).before(a) : c(d).append(a)
                })
            } else
                return this.pushStack(c(c.isFunction(a) ? a() : a), "replaceWith", a)
        },
        detach: function(a) {
            return this.remove(a, true)
        },
        domManip: function(a, b, d) {
            function f(u) {
                return c.nodeName(u, "table") ? u.getElementsByTagName("tbody")[0] || u.appendChild(u.ownerDocument.createElement("tbody")) : u
            }
            var e, j, i = a[0], o = [], k;
            if (!c.support.checkClone && arguments.length === 3 && typeof i === "string" && ua.test(i))
                return this.each(function() {
                    c(this).domManip(a, b, d, true)
                });
            if (c.isFunction(i))
                return this.each(function(u) {
                    var z = c(this);
                    a[0] = i.call(this, u, b ? z.html() : w);
                    z.domManip(a, b, d)
                });
            if (this[0]) {
                e = i && i.parentNode;
                e = c.support.parentNode && e && e.nodeType === 11 && e.childNodes.length === this.length ? {
                        fragment: e
                    } : sa(a, this, o);
                k = e.fragment;
                if (j = k.childNodes.length === 1 ? (k = k.firstChild) : k.firstChild) {
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
    });
    c.extend({
        clean: function(a, b, d, f) {
            b = b || s;
            if (typeof b.createElement === "undefined")
                b = b.ownerDocument || b[0] && b[0].ownerDocument || s;
            for (var e = [], j = 0, i; (i = a[j]) != null; j++) {
                if (typeof i === "number")
                    i += "";
                if (i) {
                    if (typeof i === "string" && !jb.test(i))
                        i = b.createTextNode(i);
                    else if (typeof i === "string") {
                        i = i.replace(Ka, Ma);
                        var o = (La.exec(i) || ["", ""])[1].toLowerCase()
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
                        e = c.merge(e, i)
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
            for (var b, d, f = c.cache, e = c.event.special, j = c.support.deleteExpando, i = 0, o; (o = a[i]) != null; i++)
                if (d = o[c.expando]) {
                    b = f[d];
                    if (b.events)
                        for (var k in b.events)
                            e[k] ? c.event.remove(o, k) : Ca(o, k, b.handle);
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
        , ja = function(a, b) {
        return b.toUpperCase()
    };
    c.fn.css = function(a, b) {
        return X(this, a, b, true, function(d, f, e) {
            if (e === w)
                return c.curCSS(d, f);
            if (typeof e === "number" && !kb.test(f))
                e += "px";
            c.style(d, f, e)
        })
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
                    f.filter = Na.test(a) ? a.replace(Na, b) : b
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
                            e -= parseFloat(c.curCSS(a, "border" + this + "Width", true)) || 0
                    })
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
                    return null;
                if (a = e.getComputedStyle(a, null))
                    f = a.getPropertyValue(b);
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
            var b = a.offsetWidth
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
            if (typeof a !== "string")
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
            }).filter(function() {
                return this.name && !this.disabled && (this.checked || ub.test(this.nodeName) || vb.test(this.type))
            }).map(function(a, b) {
                a = c(this).val();
                return a == null ? null : c.isArray(a) ? c.map(a, function(d) {
                            return {
                                name: b.name,
                                value: d
                            }
                        }) : {
                            name: b.name,
                            value: a
                        }
            }).get()
        }
    });
    c.each("ajaxStart ajaxStop ajaxComplete ajaxError ajaxSuccess ajaxSend".split(" "), function(a, b) {
        c.fn[b] = function(d) {
            return this.bind(b, d)
        }
    });
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
            return c.get(a, null, b, "script")
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
                e.success && e.success.call(k, o, i, x);
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
                    N.test(e.url) || (e.url += (ka.test(e.url) ? "&" : "?") + (e.jsonp || "callback") + "=?");
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
            if (e.dataType === "script" && e.cache === null)
                e.cache = false;
            if (e.cache === false && n === "GET") {
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
                    var B = false;
                    C.onload = C.onreadystatechange = function() {
                        if (!B && (!this.readyState || this.readyState === "loaded" || this.readyState === "complete")) {
                            B = true;
                            b();
                            d();
                            C.onload = C.onreadystatechange = null;
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
                        c.lastModified[e.url] && x.setRequestHeader("If-Modified-Since", c.lastModified[e.url]);
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
                            E || d();
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
                }, e.timeout);
                try {
                    x.send(n === "POST" || n === "PUT" || n === "DELETE" ? e.data : null)
                } catch (m) {
                    c.handleError(e, x, null, m);
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
                return !a.status && location.protocol === "file:" || a.status >= 200 && a.status < 300 || a.status === 304 || a.status === 1223 || a.status === 0
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
                if (b === "json" || !b && f.indexOf("json") >= 0)
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
                    });
                else
                    !b && o != null && typeof o === "object" ? c.each(o, function(k, n) {
                            d(i + "[" + k + "]", n)
                        }) : f(i, o)
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
                });
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
                    !d && d !== "none" && c.data(this[a], "olddisplay", c.css(this[a], "display"))
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
                a == null || d ? this.each(function() {
                        var f = d ? a : c(this).is(":hidden");
                        c(this)[f ? "show" : "hide"]()
                    }) : this.animate(K("toggle", 3), a, b);
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
                        (j.specialEasing = j.specialEasing || {})[i] = a[i][1];
                        a[i] = a[i][0]
                    }
                }
                if (j.overflow != null)
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
                });
                return true
            })
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
            });
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
    });
    c.extend({
        speed: function(a, b, d) {
            var f = a && typeof a === "object" ? a : {
                    complete: d || !d && b || c.isFunction(a) && a,
                    duration: a,
                    easing: d && b || b && !c.isFunction(b) && b
                };
            f.duration = c.fx.off ? 0 : typeof f.duration === "number" ? f.duration : c.fx.speeds[f.duration] || c.fx.speeds._default;
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
            (c.fx.step[this.prop] || c.fx.step._default)(this);
            if ((this.prop === "height" || this.prop === "width") && this.elem.style)
                this.elem.style.display = "block"
        },
        cur: function(a) {
            if (this.elem[this.prop] != null && (!this.elem.style || this.elem.style[this.prop] == null))
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
                this.now = this.end;
                this.pos = this.state = 1;
                this.update();
                this.options.curAnim[this.prop] = true;
                for (var f in this.options.curAnim)
                    if (this.options.curAnim[f] !== true)
                        d = false;
                if (d) {
                    if (this.options.display != null) {
                        this.elem.style.overflow = this.options.overflow;
                        a = c.data(this.elem, "olddisplay");
                        this.elem.style.display = a ? a : this.options.display;
                        if (c.css(this.elem, "display") === "none")
                            this.elem.style.display = "block"
                    }
                    this.options.hide && c(this.elem).hide();
                    if (this.options.hide || this.options.show)
                        for (var e in this.options.curAnim)
                            c.style(this.elem, e, this.options.orig[e]);
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
            a.length || c.fx.stop()
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
                if (a.elem.style && a.elem.style[a.prop] != null)
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
            }).length
        }
        ;
    c.fn.offset = "getBoundingClientRect"in s.documentElement ? function(a) {
            var b = this[0];
            if (a)
                return this.each(function(e) {
                    c.offset.setOffset(this, a, e)
                });
            if (!b || !b.ownerDocument)
                return null;
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
            var b = this[0];
            if (a)
                return this.each(function(r) {
                    c.offset.setOffset(this, a, r)
                });
            if (!b || !b.ownerDocument)
                return null;
            if (b === b.ownerDocument.body)
                return c.offset.bodyOffset(b);
            c.offset.initialize();
            var d = b.offsetParent, f = b, e = b.ownerDocument, j, i = e.documentElement, o = e.body;
            f = (e = e.defaultView) ? e.getComputedStyle(b, null) : b.currentStyle;
            for (var k = b.offsetTop, n = b.offsetLeft; (b = b.parentNode) && b !== o && b !== i; ) {
                if (c.offset.supportsFixedPosition && f.position === "fixed")
                    break;
                j = e ? e.getComputedStyle(b, null) : b.currentStyle;
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
            if (c.offset.supportsFixedPosition && f.position === "fixed") {
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
                b = b.call(a, d, e);
            d = {
                top: b.top - e.top + j,
                left: b.left - e.left + i
            };
            "using"in b ? b.using.call(a, d) : f.css(d)
        }
    };
    c.fn.extend({
        position: function() {
            if (!this[0])
                return null;
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
                top: d.top - f.top,
                left: d.left - f.left
            }
        },
        offsetParent: function() {
            return this.map(function() {
                for (var a = this.offsetParent || s.body; a && !/^body|html$/i.test(a.nodeName) && c.css(a, "position") === "static"; )
                    a = a.offsetParent;
                return a
            })
        }
    });
    c.each(["Left", "Top"], function(a, b) {
        var d = "scroll" + b;
        c.fn[d] = function(f) {
            var e = this[0], j;
            if (!e)
                return null;
            if (f !== w)
                return this.each(function() {
                    if (j = wa(this))
                        j.scrollTo(!a ? f : c(j).scrollLeft(), a ? f : c(j).scrollTop());
                    else
                        this[d] = f
                });
            else
                return (j = wa(e)) ? "pageXOffset"in j ? j[a ? "pageYOffset" : "pageXOffset"] : c.support.boxModel && j.document.documentElement[d] || j.document.body[d] : e[d]
        }
    });
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
                return f == null ? null : this;
            if (c.isFunction(f))
                return this.each(function(j) {
                    var i = c(this);
                    i[d](f.call(this, j, i[d]()))
                });
            return "scrollTo"in e && e.document ? e.document.compatMode === "CSS1Compat" && e.document.documentElement["client" + b] || e.document.body["client" + b] : e.nodeType === 9 ? Math.max(e.documentElement["client" + b], e.body["scroll" + b], e.documentElement["scroll" + b], e.body["offset" + b], e.documentElement["offset" + b]) : f === w ? c.css(e, d) : this.css(d, typeof f === "string" ? f : f + "px")
        }
    });
    A.jQuery = A.$ = c
})(window);
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
    };
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
            iframe = null;
            httpHander = null;
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
    };
    var getLink = function() {
        return st.url + "subscribe?token=" + st.token + "&as_name=" + st.asname + "&timestamp=" + st.timestamp + "&domain=" + st.domain + "&type=" + type + "&channel_list=" + st.channel + "&uid_flag=" + st.uid_flag + "&uid_timestamp=" + st.uid_timestamp + "&_=" + (new Date()).getTime()
    };
    var offLink = function(b) {
        if (st.domain) {
            $.getJSON(st.url + "offline?token=" + st.token + "&jsoncallback=?", b)
        } else {
            $.get(st.url + "offline?token=" + st.token + "&jsoncallback=comet" + (new Date()).getTime(), function(x) {
                b(parseInt(x.substr(x.indexOf("(") + 1, 1), 10))
            })
        }
    };
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
                    timeHander = null;
                    cm.iback(XMLHttpRequest)
                }, 30000)
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
                    timeHander = null;
                    isOk = 1;
                    nextType()
                }, firstConnect == 1 ? st.timeFirst : st.time)
            } else {
                timeHander = setTimeout(function() {
                    clearTimeout(timeHander);
                    timeHander = null;
                    isOk = 1;
                    nextType()
                }, st.time)
            }
            linkhander = setTimeout(function() {
                clearTimeout(linkhander);
                linkhander = null;
                isOk = 1;
                sendEvent("cpsconnect", [-2])
            }, 30000)
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
                            timeHander = null;
                            isOk = 1;
                            nextType()
                        }, firstConnect == 1 ? st.timeFirst : st.time)
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
        httpHander = null;
        if (window.ActiveXObject) {
            try {
                CollectGarbage()
            } catch (y) {}
        }
    });
    st.doc.bind("cpsset.comet", function(e, d) {
        if ("object" == typeof (d)) {
            $.extend(st, d)
        }
    }).bind("keydown.comet", function(e) {
        if (27 === e.keyCode) {
            e.preventDefault()
        }
    });
    window.cm = $.comet
})(jQuery);
(function(d) {
    var c = (navigator.appVersion.indexOf("MSIE") != -1) ? true : false;
    var b = (navigator.appVersion.toLowerCase().indexOf("win") != -1) ? true : false;
    var a = (navigator.userAgent.indexOf("Opera") != -1) ? true : false;
    d.fn.runActive = function(g) {
        if (!this[0] || "object" !== typeof (g) || !g.src) {
            return
        }
        g.name = g.id = "flashactive" + (new Date()).getTime();
        var h = {
            embedAttrs: {
                width: "0",
                height: "0",
                quality: "high",
                pluginspage: "http://www.macromedia.com/go/getflashplayer",
                align: "middle",
                play: "true",
                loop: "true",
                scale: "showall",
                wmode: "window",
                devicefont: "false",
                bgcolor: "#FFF",
                menu: "true",
                allowFullScreen: "false",
                allowScriptAccess: "always",
                salign: "",
                type: "application/x-shockwave-flash"
            },
            params: {
                quality: "high",
                play: "true",
                loop: "true",
                scale: "showall",
                wmode: "window",
                devicefont: "false",
                bgcolor: "#FFF",
                menu: "true",
                allowFullScreen: "false",
                allowScriptAccess: "always",
                salign: ""
            },
            objAttrs: {
                codebase: "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0",
                width: "0",
                height: "0",
                align: "middle",
                classid: "clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
            }
        };
        d.each(g, function(j, k) {
            switch (j.toLowerCase()) {
                case "pluginspage":
                    h.embedAttrs[j] = k;
                    break;
                case "src":
                    h.embedAttrs.src = k;
                    h.params.movie = k;
                    break;
                case "onafterupdate":
                case "onbeforeupdate":
                case "onblur":
                case "oncellchange":
                case "onclick":
                case "ondblClick":
                case "ondrag":
                case "ondragend":
                case "ondragenter":
                case "ondragleave":
                case "ondragover":
                case "ondrop":
                case "onfinish":
                case "onfocus":
                case "onhelp":
                case "onmousedown":
                case "onmouseup":
                case "onmouseover":
                case "onmousemove":
                case "onmouseout":
                case "onkeypress":
                case "onkeydown":
                case "onkeyup":
                case "onload":
                case "onlosecapture":
                case "onpropertychange":
                case "onreadystatechange":
                case "onrowsdelete":
                case "onrowenter":
                case "onrowexit":
                case "onrowsinserted":
                case "onstart":
                case "onscroll":
                case "onbeforeeditfocus":
                case "onactivate":
                case "onbeforedeactivate":
                case "ondeactivate":
                case "type":
                case "codebase":
                case "id":
                case "classid":
                    h.objAttrs[j] = k;
                    break;
                case "width":
                case "height":
                case "align":
                case "vspace":
                case "hspace":
                case "class":
                case "title":
                case "accesskey":
                case "name":
                case "tabindex":
                    h.embedAttrs[j] = k;
                    h.objAttrs[j] = k;
                    break;
                default:
                    h.embedAttrs[j] = k;
                    h.params[j] = k
            }
        });
        var f = [];
        if (c && b && !a) {
            f.push("<object ");
            d.each(h.objAttrs, function(j, k) {
                f.push(j + '="' + k + '" ')
            });
            f.push(">");
            d.each(h.params, function(j, k) {
                f.push('<param name="' + j + '" value="' + k + '"/>')
            });
            f.push("</object>")
        } else {
            f.push("<embed ");
            d.each(h.embedAttrs, function(j, k) {
                f.push(j + '="' + k + '" ')
            });
            f.push("></embed>")
        }
        this[0].innerHTML = f.join("");
        return window[g.id] || document[g.id]
    }
})(jQuery);
var JqueryDialog = {
    cBorderSize: 2,
    cCloseText: "X 关闭",
    cCloseTitle: "关闭",
    cSubmitText: "确 认",
    cCancelText: "关 闭",
    Open: function(c, g, a, f, d, b) {
        if (undefined == d) {
            d = false
        }
        JqueryDialog.init(c, g, a, f, d, true, true, true, b)
    },
    Open1: function(a, j, c, b, h, f, g, d, k) {
        g = g ? g : false;
        d = d ? d : false;
        JqueryDialog.init(a, j, c, b, d, h, f, g, k)
    },
    init: function(m, s, u, k, n, q, c, o, h) {
        var j = document.body.clientWidth;
        var v = document.documentElement.scrollHeight;
        var g = h ? ',"' + h + '"' : "";
        if (typeof ($("#jd_shadow")[0]) == "undefined") {
            $("body").prepend("<iframe id='jd_shadow'></iframe>");
            var l = $("#jd_shadow");
            l.css("width", j + "px");
            l.css("height", v + "px")
        }
        if (typeof ($("#jd_dialog")[0]) != "undefined") {
            $("#jd_dialog").remove()
        }
        $("body").prepend("<div id='jd_dialog'></div>");
        var b = $("#jd_dialog");
        var r = (j - (u + JqueryDialog.cBorderSize * 2 + 5)) / 2;
        b.css("left", (r < 0 ? 0 : r) + document.documentElement.scrollLeft + "px");
        var p = (document.documentElement.clientHeight - (k + JqueryDialog.cBorderSize * 2 + 30 + 40 + 5)) / 2;
        b.css("top", (p < 0 ? 0 : p) + document.documentElement.scrollTop + "px");
        b.append("<div id='jd_dialog_s'>&nbsp;</div>");
        var f = $("#jd_dialog_s");
        f.css("width", u + JqueryDialog.cBorderSize * 2 + "px");
        f.css("height", k + JqueryDialog.cBorderSize * 2 + 30 + 40 + "px");
        b.append("<div id='jd_dialog_m'></div>");
        var a = $("#jd_dialog_m");
        a.css("width", u + "px");
        a.append("<div id='jd_dialog_m_h'></div>");
        var t = $("#jd_dialog_m_h");
        t.append("<span id='jd_dialog_m_h_l'>" + m + "</span>");
        t.append("<span id='jd_dialog_m_h_r' title='" + JqueryDialog.cCloseTitle + "' onclick='JqueryDialog.Close(" + n + g + ");'>" + JqueryDialog.cCloseText + "</span>");
        a.append("<div id='jd_dialog_m_b'></div>");
        a.append("<div id='jd_dialog_m_b_1'>&nbsp;</div>");
        var w = $("#jd_dialog_m_b_1");
        w.css("top", "30px");
        w.css("width", u + "px");
        w.css("height", k + "px");
        w.css("display", "none");
        a.append("<div id='jd_dialog_m_b_2'></div>");
        $("#jd_dialog_m_b_2").append("<iframe id='jd_iframe' src='" + s + "' height='" + k + "' scrolling='yes' allowtransparency='true' style='overflow:visible;overflow-x: hidden'/>");
        a.append("<div id='jd_dialog_m_t' class='module g-tn'></div>");
        var d = $("#jd_dialog_m_t");
        if (q) {
            d.append("<span><input id='jd_submit' class='btn2' value='" + JqueryDialog.cSubmitText + "' type='button' onclick='JqueryDialog.Ok();' /></span>")
        }
        if (c) {
            d.append("<span class='jd_dialog_m_t_s'><input id='jd_cancel' class='btn2' value='" + JqueryDialog.cCancelText + "' type='button' onclick='JqueryDialog.Close(" + n + g + ");' /></span>")
        }
        if (o) {
            DragAndDrop.Register(b[0], t[0])
        }
        if (q) {
            JqueryDialog.DisabledButton();
            $("#jd_dialog_m_b_2").append('<div class="mask" id="dialog_mask" style="height:' + k + 'px" id="dialog_mask"></div>');
            $("#jd_submit:enabled").focus();
            $(document).bind("keyup.dialog", function(x) {
                if ($("#jd_submit:enabled").get(0) && x.keyCode == 13) {
                    $("#jd_submit").click()
                }
            })
        }
    },
    Close: function(b, a) {
        $("#jd_iframe").remove();
        $("#jd_shadow").remove();
        $("#jd_dialog").remove();
        if ("CollectGarbage"in window) {
            CollectGarbage()
        }
        $(document).unbind("keyup.dialog");
        if (b) {
            if (window.location.href.indexOf("statis.htm") < 0) {
                window.location.href = window.location.href
            } else {
                $.trigger("ftongji")
            }
        }
        if (a !== undefined) {
            $.trigger(a)
        }
    },
    Ok: function() {
        var b = $("#jd_submit");
        if (true == b.attr("disabled")) {
            return false
        }
        b.attr("disabled", "disabled");
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
        $("#jd_submit").attr("disabled", "");
        $("#dialog_mask").remove()
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
                    var h = Number(window.location.href.indexOf("statis.htm"));
                    if (h < 0) {
                        if (d) {
                            if (b.indexOf(d) == -1) {
                                b = b.indexOf("?") != -1 ? b + "&" + d : b + "?" + d
                            }
                            window.location.href = b
                        } else {
                            window.location.href = window.location.href
                        }
                    } else {
                        $.trigger("ftongji")
                    }
                }
            }
            JqueryDialog.Close(false)
        }
    }
};
var DragAndDrop = function() {
    var m;
    var h;
    var j;
    var f;
    var c = false;
    var k;
    var d;
    var b = function(o) {
        return o.ownerDocument || o.document
    };
    var g = function(o) {
        if (f) {
            o = o || window.event;
            m = document.body.clientWidth;
            h = document.documentElement.scrollHeight;
            $("#jd_dialog_m_b_1").css("display", "");
            c = true;
            k = {
                x: $(f).offset().left,
                y: $(f).offset().top
            };
            d = {
                x: o.screenX,
                y: o.screenY
            };
            $(document).bind("mousemove", l);
            $(document).bind("mouseup", n);
            if (o.preventDefault) {
                o.preventDefault()
            } else {
                o.returnValue = false
            }
        }
    };
    var l = function(o) {
        if (c) {
            o = o || window.event;
            var p = {
                x: o.screenX,
                y: o.screenY
            };
            k.x = k.x + (p.x - d.x);
            k.y = k.y + (p.y - d.y);
            d = p;
            $(f).css("left", k.x + "px");
            $(f).css("top", k.y + "px");
            if (o.preventDefault) {
                o.preventDefault()
            } else {
                o.returnValue = false
            }
        }
    };
    var n = function(o) {
        if (c) {
            o = o || window.event;
            $("#jd_dialog_m_b_1").css("display", "none");
            a();
            c = false
        }
    };
    var a = function() {
        if (j) {
            $(j.document).unbind("mousemove");
            $(j.document).unbind("mouseup")
        }
    };
    return {
        Register: function(o, p) {
            f = o;
            j = p;
            $(j).bind("mousedown", g)
        }
    }
}();
(function(a) {
    a.fn.spinner = function(h) {
        var m = {
            cls: "g-spi",
            owndom: document,
            delay: 500,
            intv: 50,
            insval: 1,
            alternateval: 5,
            alternatekey: "shiftKey",
            defaultval: 0,
            minval: null,
            maxval: null,
            val: undefined,
            fixed: 0,
            allownull: 1,
            movezero: 0,
            msg_up: "",
            msg_down: "",
            msg_status: false,
            is_discount: false
        }, o = [], c, f;
        var g = false;
        var d = "不能小于最小值";
        var n = "不能大于最大值";
        var l = "不可以设置{#|9000|6c34#}值小于0".keyComment();
        var q = "不可以设置{#|9000|6c34#}大于系统设定{#|9000|6c34#}".keyComment();
        var k = 0;
        var b = a("#level").val();
        var j = a("#childcount").val();
        if (h) {
            a.extend(m, h)
        }
        a(m.owndom).bind("empty", function() {
            for (var r = 0; r < o.length; r++) {
                clearInterval(o[r])
            }
            o = []
        });
        a(document).bind("dragstart", function() {
            return false
        });
        var p = function(v, y, u, s, x) {
            var r = x[0].name.replace("discount", "")
                , z = a.game_name[parseInt(r.slice(-2), 10)]
                , w = r.replace(/\d/g, "").split("");
            if (r === "g12" || r === "g17") {
                z = r === "g12" ? "高1-2" : "高1-7";
                q = q.replace("系统", "公司")
            } else {
                if (w.length === 1) {
                    w = w + "盘"
                } else {
                    w = w[0] + "盘(特" + w[1] + ")"
                }
                z = z + "-" + w
            }
            if (-1 == k) {
                if (m.is_discount) {
                    if (0 == j) {
                        u = l
                    }
                }
                u = ("" == u) ? (d + v) : u;
                alert("[" + z + "]" + u)
            }
            if (1 == k) {
                if (m.is_discount) {
                    if (1 == b || "" == b) {
                        s = q
                    }
                }
                s = ("" == s) ? (n + y) : s;
                alert("[" + z + "]" + s)
            }
            x.select();
            g = false
        };
        return this.each(function() {
            if ("text" !== this.type) {
                return
            }
            var E = a.extend(true, {}, m), F = this, B = a(this), C, w = 1000, z, v = false;
            a(["delay", "intv", "fixed", "allownull", "movezero"]).each(function(x, t) {
                C = F.getAttribute(t);
                if (C) {
                    C = parseInt(C, 10);
                    if (!isNaN(C)) {
                        E[t] = C
                    }
                }
            });
            a(["insval", "alternateval", "defaultval", "minval", "maxval"]).each(function(x, t) {
                C = F.getAttribute(t);
                if (C) {
                    C = parseFloat(C);
                    if (!isNaN(C)) {
                        E[t] = C
                    }
                }
            });
            a(["cls", "alternatekey", "val"]).each(function(x, t) {
                C = F.getAttribute(t);
                if (C) {
                    E[t] = C
                }
            });
            if (undefined !== E.val) {
                F.value = E.val
            }
            var A = function(t) {
                t = parseFloat(undefined === t ? F.value : t.toFixed(E.fixed));
                if (isNaN(t)) {
                    if (E.allownull) {
                        F.value = "";
                        return
                    } else {
                        t = E.defaultval
                    }
                }
                if (null !== E.minval && t < E.minval) {
                    g = true;
                    t = E.minval
                } else {
                    if (null !== E.maxval && t > E.maxval) {
                        g = true;
                        t = E.maxval
                    }
                }
                t = t.toFixed(E.fixed);
                F.value = E.movezero ? parseFloat(t) : t
            };
            A();
            B.attr("autocomplete", "off").bind("setspinner", function(x, t) {
                if (t) {
                    a.extend(E, t)
                }
                if (undefined !== t.val) {
                    F.value = t.val
                }
                A()
            }).wrap('<em class="' + E.cls + '"></em>').after('<span><a href="javascript:" class="u" act="u"></a><ins></ins><a href="javascript:" class="d" act="d"></a></span>');
            var s = B.next();
            s.click(function(t) {
                t.preventDefault()
            });
            var r = function(H, x) {
                var t = parseFloat(F.value);
                if (isNaN(t)) {
                    t = E.defaultval
                } else {
                    var G = x ? E.alternateval : E.insval;
                    t = H ? t - G : t + G
                }
                A(t)
            };
            var u = function(t) {
                if (c) {
                    clearTimeout(c);
                    c = null
                }
                if (f) {
                    clearInterval(f);
                    f = null
                }
                if (!F.disabled && t && "mouseup" == t.type) {
                    F.focus()
                }
            };
            var y = function() {
                if (F.disabled !== v) {
                    A();
                    v = F.disabled;
                    if (v) {
                        s.addClass("ds");
                        B.addClass("ds")
                    } else {
                        s.removeClass("ds");
                        B.removeClass("ds")
                    }
                }
            };
            y();
            o.push(setInterval(y, 500));
            a(s).mousedown(function(G) {
                G.preventDefault();
                if (v) {
                    return
                }
                var x = G.target, I, H;
                switch (x.getAttribute("act")) {
                    case "u":
                        I = false;
                        H = G[E.alternatekey];
                        k = 1;
                        break;
                    case "d":
                        I = true;
                        H = G[E.alternatekey];
                        k = -1;
                        break
                }
                if (undefined !== I && undefined !== H) {
                    r(I, H);
                    if (c) {
                        clearTimeout(c)
                    }
                    c = setTimeout(function() {
                        c = null;
                        r(I, H);
                        if (f) {
                            clearInterval(f)
                        }
                        f = setInterval(function() {
                            r(I, H);
                            if (g && m.msg_status) {
                                u(G);
                                p(E.minval, E.maxval, E.msg_down, E.msg_up, B)
                            }
                        }, E.intv)
                    }, E.delay)
                }
                if (g && m.msg_status) {
                    p(E.minval, E.maxval, E.msg_down, E.msg_up, B)
                }
            }).mouseout(u).mouseup(u).click(function(t) {
                t.target.blur()
            });
            var D = function() {
                var t = F.value.replace(/[^\d\-\.]/g, "").replace(/^(.+)([\-]+)/g, "$1").replace(/^(\-?)0+([^\.])/, "$1$2").replace(/(\..*)\..*/g, "$1").replace(/\..*/, function(G) {
                    return E.fixed > 0 ? G.substr(0, E.fixed + 1) : ""
                });
                var x = parseFloat(t);
                if (!isNaN(x)) {
                    if (null !== E.minval && x < E.minval) {
                        g = true;
                        k = -1;
                        t = E.minval
                    } else {
                        if (null !== E.maxval && x > E.maxval) {
                            g = true;
                            k = 1;
                            t = E.maxval
                        }
                    }
                }
                if (g && m.msg_status) {
                    p(E.minval, E.maxval, E.msg_down, E.msg_up, B)
                }
                F.value = t
            };
            B.blur(function() {
                A()
            }).keyup(function() {
                if (z) {
                    clearTimeout(z)
                }
                z = setTimeout(D, w)
            }).keydown(function(t) {
                switch (t.keyCode) {
                    case 38:
                        r(false, t[E.alternatekey]);
                        t.preventDefault();
                        break;
                    case 40:
                        r(true, t[E.alternatekey]);
                        t.preventDefault();
                        break;
                    case 13:
                        A();
                        t.preventDefault();
                        break
                }
            }).bind("paste", function() {
                setTimeout(D, 0)
            })
        })
    }
})(jQuery);
$.extend({
    logjs: null,
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
        if (a == null) {
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
            timeHander = null;
            $._initLog4js()
        }, 1000)
    },
    _initLog4js: function() {
        if (!$.log4js_cfg.log4js_type) {
            return
        }
        var a = null;
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
        };
        if ($.log4js_cfg.log4js_type != 4) {
            b()
        }
        $.ajax({
            type: "GET",
            url: $.log4js_cfg.js_path + a,
            dataType: "script",
            success: function(f) {
                var c = null;
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
    var j = document.createElement("div");
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
    j.style.backgroundColor = b;
    j.style.filter = "alpha(opacity=" + parseInt(c * 100, 10) + ")";
    j.style.mozOpacity = "" + c;
    j.style.opacity = "" + c;
    j.style.position = "absolute";
    j.style.top = "0";
    j.style.left = "0";
    j.style.zIndex = "" + (h + 1);
    j.style.display = "none";
    d.style.position = "absolute";
    d.style.top = "0";
    d.style.left = "0";
    d.style.display = "none";
    d.style.backgroundColor = "#D3EAFC";
    d.style.zIndex = "" + (h + 2);
    document.body.appendChild(a);
    document.body.appendChild(j);
    document.body.appendChild(d);
    this.frame = a;
    this.div = j;
    this.span = d;
    this.alarm_notice = "";
    this.alarm_expire = 0;
    this.hideTrigger = null;
    this.alarmTimer = null;
    this.spanTimer = null;
    var g = this;
    var f = window.onresize;
    window.onresize = function() {
        if (f) {
            f()
        }
        Cover.setCoverSize(g)
    }
};
Cover.prototype.removeStr = function() {
    if (this.spanTimer) {
        clearTimeout(this.spanTimer)
    }
    this.span.style.display = "none"
}
;
Cover.prototype.show = function() {
    var b = this;
    this.frame.style.display = "";
    this.div.style.display = "";
    Cover.setCoverSize(this);
    try {
        this.div.focus()
    } catch (a) {}
    if (this.span.innerHTML) {
        if (this.spanTimer) {
            clearTimeout(this.spanTimer)
        }
        this.spanTimer = setTimeout(function() {
            if ("none" !== b.frame.style.display) {
                b.span.style.display = "";
                Cover.setCoverSize(b)
            }
        }, 1000)
    }
    if (this.alarm_expire > 0) {
        if (this.alarmTimer) {
            clearTimeout(this.alarmTimer)
        }
        this.alarmTimer = setTimeout(function() {
            if ("none" !== b.frame.style.display) {
                if (b.alarm_notice) {
                    alert(b.alarm_notice)
                }
                b.hide()
            }
            if (b.hideTrigger) {
                b.hideTrigger()
            }
        }, b.alarm_expire)
    }
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
            , j = "var r=[];\n"
            , l = 0;
        var k = function(m, n) {
            n ? (j += m.match(d) ? m + "\n" : "r.push(" + unescape('"' + m.split("|").join("\\u") + '"') + ");\n") : (j += m != "" ? 'r.push("' + m.replace(/"/g, '\\"') + '");\n' : "");
            return k
        };
        while (match = h.exec(g)) {
            k(g.slice(l, match.index))(match[1], true);
            l = match.index + match[0].length
        }
        k(g.substr(l, g.length - l));
        j += 'return r.join("");';
        return new Function(j.replace(/[\r\t\n]/g, "")).apply(f)
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
})(window);
$.extend({
    isInt: function(a) {
        return (/^-?\d+$/).test(a)
    },
    isPint: function(a) {
        return (/^\d+$/).test(a)
    },
    isRPint: function(a) {
        return (/^[1-9]\d*$/).test(a)
    },
    isGint: function(a) {
        return (/^\d+$/).test(a) ? ((/^0+$/).test(a) ? false : true) : false
    },
    isFloat: function(a) {
        return (/^(-?\d+)(\.\d+)?$/).test(a)
    },
    isPfloat: function(a) {
        return (/^\d+(\.\d+)?$/).test(a)
    },
    isBall: function(a) {
        return (/^[0-4]?[0-9]$/).test(a) ? ((/^0?0$/).test(a) ? false : a) : false
    },
    indexOf: function(b, a, k) {
        var f, c, j = "\\0";
        if (k !== null) {
            f = b.slice(k);
            c = k
        } else {
            f = b;
            c = 0
        }
        var h = j + f.join(j) + j
            , g = h.indexOf(j + a + j);
        if (g == -1) {
            return -1
        }
        c += h.slice(0, g).replace(/[^\0]/g, "").length;
        return c
    },
    getBallColor: function(b) {
        var a = $.products;
        if (!$.isBall(b)) {
            return ""
        }
        if (-1 != $.indexOf(a[1], b)) {
            return "red"
        }
        if (-1 != $.indexOf(a[2], b)) {
            return "blue"
        }
        return "green"
    },
    ajaxAction: function(c, a, b) {
        $.getJSON(b, function(d) {
            a.call(c, d)
        })
    },
    isUP: function(a) {
        return (/^[a-zA-Z0-9][a-zA-Z0-9_]{0,11}$/).test(a)
    },
    isName: function(b) {
        b = b.replace(/\s{2,}/g, " ");
        b = $.trim(b);
        var a = b.replace(/[^\x00-\xff]/g, "**").length;
        return (/^[a-zA-Z0-9_\.\u4e00-\u9fa5]+$/).test(b) && a > "0" && a < "17"
    },
    isPWD: function(a) {
        return (/^(?![^a-zA-Z]+$)(?!\D+$)[a-zA-Z0-9]{8,12}$/).test(a)
    },
    isValidDate: function(a, g, f) {
        g = g || 0;
        for (var d = g; d < 6; d++) {
            if (!$.isPint(a[d].value)) {
                alert(f);
                a[d].select();
                return false
            }
        }
        var c = [parseInt(a[g].value, 10), parseInt(a[g + 1].value, 10) - 1, parseInt(a[g + 2].value, 10), parseInt(a[g + 3].value, 10), parseInt(a[g + 4].value, 10), 0];
        var b = new Date(c[0],c[1],c[2],c[3],c[4],c[5]);
        if (b.getFullYear() !== c[0] || b.getMonth() !== c[1] || b.getDate() !== c[2] || b.getHours() !== c[3] || b.getMinutes() !== c[4]) {
            alert(f);
            if (c[0] < 1970) {
                a[g].select()
            } else {
                if (c[1] > 11) {
                    a[g + 1].select()
                } else {
                    if (c[3] > 23) {
                        a[g + 3].select()
                    } else {
                        if (c[4] > 59) {
                            a[g + 4].select()
                        } else {
                            a[g + 2].select()
                        }
                    }
                }
            }
            return false
        }
        return [b, c[0] + "-" + (c[1] + 1) + "-" + c[2] + " " + c[3] + ":" + c[4] + ":0", a[g].value + "-" + a[g + 1].value + "-" + a[g + 2].value + " " + a[g + 3].value + ":" + a[g + 4].value + ":00"]
    },
    _popup: null,
    popup: function(g, a, d, c, f) {
        a = a || 600;
        d = d || 200;
        c = c || "no";
        f = f || "no";
        var b = (screen.width) ? (screen.width - a) / 2 : 0;
        var k = (screen.height) ? (screen.height - d) / 2 : 0;
        if ($._popup) {
            try {
                $._popup.close()
            } catch (j) {}
        }
        $._popup = window.open(g, "popup", "height=" + d + ",width=" + a + ",top=" + k + ",left=" + b + ",scrollbars=" + c + ",resizable=" + f)
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
        }, $.odds_light)
    },
    initLight: function(b) {
        for (var a in b) {
            if (b.hasOwnProperty(a)) {
                b[a].removeAttribute("lightCount")
            }
        }
    },
    setCover: function(a) {
        cover.setStr(a)
    },
    coverSubmit: function() {
        $.setCover("处理中...，请不要刷新、关闭页面。<span class='loadding2'/>");
        cover.show()
    },
    disableAWhile: function(a) {
        a.disabled = true;
        setTimeout(function() {
            a.disabled = false
        }, 3000)
    },
    getCellIndex: function(c) {
        var b = $(c).parents("tr:first")[0];
        if (!b) {
            return -1
        }
        for (var a = 0; a < b.cells.length; a++) {
            if (b.cells[a] === c) {
                return a
            }
        }
    },
    selectEm: function(a) {
        setTimeout(function() {
            a.focus();
            a.select()
        }, 0)
    },
    isChangeForm: function(h) {
        var b = false;
        var a = h.elements;
        for (var g = 0; g < h.elements.length; g++) {
            var f = h.elements[g];
            var d = f.nodeName;
            if (d == "INPUT") {
                if ($(f).attr("alternateval")) {
                    if (Math.abs(f.value - f.defaultValue) > 0.000001) {
                        b = true;
                        break
                    }
                } else {
                    if (f.type == "radio" || f.type == "checkbox") {
                        if (f.checked != f.defaultChecked) {
                            b = true;
                            break
                        }
                    } else {
                        if (f.type != "hidden" && f.value != f.defaultValue) {
                            b = true;
                            break
                        }
                    }
                }
            } else {
                if (d == "SELECT") {
                    for (var c = 0; c < f.options.length; c++) {
                        if (f.options[c].selected != f.options[c].defaultSelected) {
                            b = true;
                            break
                        }
                    }
                    if (b) {
                        break
                    }
                } else {
                    if (d == "TEXTAREA") {
                        if (f.value != f.defaultChecked) {
                            b = true;
                            break
                        }
                    }
                }
            }
        }
        return b
    },
    formatTime: function() {
        for (var b = 0; b < arguments.length; b++) {
            var a = "00" + arguments[b].value;
            arguments[b].value = a.substring(a.length - 2)
        }
    },
    validateEm: function(a, g) {
        var j = $(a).attr("valid");
        var b = $(a).attr("gid");
        if ($.is_odds_declen3(g) || $.is_odds_declen3(b)) {
            j = j + "_odds3"
        }
        a.value = $.trim(a.value);
        var c = a.value;
        var l = true;
        var k = function() {
            var m = {
                name: "名称由汉字的简繁体(一个汉字2位字符)、圆点（.）、字母、数字、下划线组成，长度不超过16个英文字符或8个汉字！",
                account: "账号由1-12位英文字母、数字、下划线组成，且第一位不能是下划线",
                password: $.isStrongPwd ? "密码由6-12位字符组成，必须包含字母和数字" : "密码由4-16位字符组成",
                epassword: $.isStrongPwd ? "密码由6-12位字符组成，必须包含字母和数字" : "密码由4-16位字符组成",
                amount: "金额由不大于9位的正整数组成",
                amount: "金额由不大于9位的正整数组成",
                amount0: "金额由不大于9位的正整数组成,可以为0",
                credit: "{#|4fe1|7528|989d|5ea6#}由不大于9位的整数组成".keyComment(),
                odds: "{#|8d54|7387#}大于1，长度为1-4位整数，允许最多帶三位小數".keyComment(),
                autodis2: "自动{#|8c03|6c34#}下{#|8c03|6c34#}位由0-99组成，允许最多帶三位小數".keyComment(),
                order: "优先顺序由1-999的整数组成",
                dis: "{#|9000|6c34#}由小于100的数组成，允许输入一位小数".keyComment(),
                share: "{#|5360|6210#}由0-100的整数组成".keyComment(),
                adj: "差分长度为1-4位整数，允许最多帶三位小數",
                draw: "{#|671f|6570#}名称由1-8位数字组成".keyComment(),
                adj_odds: "连调比例由0-999组成(不包括0)，允许最多帶三位小數",
                max_view: "可查看{#|671f|6570#}由2位以内的正整数组成".keyComment(),
                meq_time: "参考公司{#|8d54|7387#}在跑马灯停留时间由3-99整数组成".keyComment(),
                max_com: "最大显示参考公司{#|8d54|7387#}数量范围是0-5".keyComment(),
                hour: "小时为24时制小时格式",
                minute: "分钟为24时制分钟格式",
                days: "日期不正确！",
                odds_odds3: "{#|8d54|7387#}大于1，长度为1-4位整数，允许最多带三位小数".keyComment(),
                autodis2_odds3: "自动{#|8c03|6c34#}下{#|8c03|6c34#}位由0-99组成，允许最多带三位小数".keyComment(),
                adj_odds3: "差分长度为1-5位整数，允许最多带三位小数"
            };
            alert(m[j]);
            $.selectEm(a)
        };
        switch (j) {
            case "name":
                a.value = c.replace(/\s{2,}/g, " ");
                a.value = $.trim(a.value);
                var h = a.value.replace(/[^\x00-\xff]/g, "**").length;
                l = (/^[a-zA-Z0-9_\.\u4e00-\u9fa5]+$/).test(a.value) && h > "0" && h < "17";
                break;
            case "account":
                l = (/^[a-zA-Z0-9]+[a-zA-Z0-9_]*$/).test(c) && c.length < 13;
                break;
            case "password":
                if ($.isStrongPwd) {
                    l = (/^(?![^a-zA-Z]+$)(?!\D+$)[a-zA-Z0-9]{6,12}$/).test(c)
                } else {
                    l = (/^[^\u4e00-\u9fa5]{4,16}$/).test(c)
                }
                break;
            case "epassword":
                if ($.isStrongPwd) {
                    l = (/^(?![^a-zA-Z]+$)(?!\D+$).{6,12}$/).test(c) || c == ""
                } else {
                    l = (/^[^\u4e00-\u9fa5]{4,16}$/).test(c) || c == ""
                }
                break;
            case "amount":
                l = (/^[1-9]\d{0,8}$/).test(c);
                break;
            case "amount0":
                l = (/^\d{1,9}$/).test(c);
                break;
            case "credit":
                l = (/^[1-9]\d{0,8}$/).test(c) || c == "0";
                break;
            case "order":
                l = (/^[1-9]\d{0,2}$/).test(c) && c.length < 1000;
                break;
            case "dis":
                l = (/^\d{1,3}(\.\d)?$/).test(c) && !(/^[0]\d+(\.\d+)?$/).test(c);
                break;
            case "share":
                l = (/^\d{1,3}$/).test(c) && !(/^[0]\d+$/).test(c) && c <= "100";
                break;
            case "adj":
                c = c.substr(0, 1) == "-" ? c.substr(1) : c;
                l = (/^\d{1,4}(\.\d{1,3})?$/).test(c) && !(/^[0]\d+(\.\d+)?$/).test(c);
                break;
            case "odds":
                l = (/^[1-9]\d{0,3}(\.\d{1,3})?$/).test(c) && parseFloat(c) > 1;
                break;
            case "autodis2":
                l = (/^\d{1,2}(\.\d{1,3})?$/).test(c) && !(/^[0]\d+(\.\d+)?$/).test(c);
                break;
            case "draw":
                l = (/^\d{1,8}$/).test(c);
                break;
            case "adj_odds":
                l = (/^\d{1,3}(\.\d{1,3})?$/).test(c) && !(/^[0]\d+(\.\d+)?$/).test(c) && c != 0;
                break;
            case "max_view":
                l = (/^[1-9]\d{0,1}$/).test(c);
                break;
            case "meq_time":
                l = (/^[1-9]\d{0,1}$/).test(c) && parseInt(c, 10) >= 3;
                break;
            case "max_com":
                l = (/^[0-5]$/).test(c);
                break;
            case "hour":
                var d = parseInt(c, 10);
                l = !(!(/^\d(\d)?$/).test(c) || d > 23 || d < 0);
                break;
            case "minute":
                var f = parseInt(c, 10);
                l = !(!(/^\d(\d)?$/).test(c) || f > 59 || f < 0);
                break;
            case "days":
                c = $.trim(c);
                l = (0 < c && c <= ($.getDaysOfMon()));
                break;
            case "odds_odds3":
                l = (/^[1-9]\d{0,3}(\.\d{1,3})?$/).test(c) && parseFloat(c) > 1;
                break;
            case "autodis2_odds3":
                l = (/^\d{1,2}(\.\d{1,3})?$/).test(c) && !(/^[0]\d+(\.\d+)?$/).test(c);
                break;
            case "adj_odds3":
                c = c.substr(0, 1) == "-" ? c.substr(1) : c;
                l = (/^\d{1,5}(\.\d{1,3})?$/).test(c) && !(/^[0]\d+(\.\d+)?$/).test(c);
                break;
            default:
                break
        }
        if (!l) {
            k()
        }
        return l
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
    evalJSON: function(t) {
        if (!t) {
            return {}
        }
        var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g;
        cx.lastIndex = 0;
        if (cx.test(t)) {
            t = t.replace(cx, function(a) {
                return "\\u" + ("0000" + a.charCodeAt(0).toString(16)).slice(-4)
            })
        }
        if (/^[\],:{}\s]*$/.test(t.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, ""))) {
            return eval("(" + t + ")")
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
    one: function(a, c, b) {
        $(document).one(a, c, b)
    },
    checkAll: function(c) {
        var b, a;
        b = $("thead th :checkbox", c).click(function(d) {
            a.each(function() {
                this.checked = b.checked
            })
        })[0];
        a = $("tbody :checkbox", c).click(function() {
            var d = true;
            a.each(function() {
                if (!this.checked) {
                    d = false;
                    return false
                }
            });
            b.checked = d
        })
    },
    back_filld: function(a) {
        if (typeof (back_fill) != "undefined") {
            for (var b in back_fill) {
                if (a[b] && a[b].type != "password" && a[b].type != "hidden" && !a[b].disabled) {
                    a[b].value = back_fill[b]
                }
            }
        }
    },
    getDaysOfMon: function(a) {
        var b = "";
        if (a) {
            b = new Date(a)
        } else {
            b = new Date()
        }
        b = new Date(b.getFullYear(),b.getMonth() + 1,0);
        return ( b.getDate())
    },
    heightLightSysconfig: function(c) {
        var b = window.location.href;
        if (window.location.search != "") {
            var a = b.indexOf("?");
            b = b.substr(0, a)
        }
        $("a", c).each(function() {
            if (b == this.href) {
                $(this).addClass("red");
                return false
            }
        })
    },
    heightLightAcount: function(b) {
        var a = $(b).attr("curl");
        $("a", b).each(function() {
            if (a == $(this).attr("curl")) {
                $(this).addClass("red");
                return false
            }
        })
    },
    movod: function() {
        $("tbody[nomovod!=''] tr").hover(function() {
            $("td", this).addClass("new_odd");
            $("th", this).addClass("new_odd")
        }, function() {
            $(".new_odd").removeClass("new_odd")
        })
    },
    getRound: function(b, a) {
        return Math.round(Math.random() * 1000) % (a - b) + b
    },
    replaceMoney: function(a) {
        if ($.trim(a) == "") {
            return 0
        }
        a = a.toString().replace(/\$|\,/g, "");
        return parseInt(a)
    },
    formatMoney: function(c) {
        if (isNaN(c)) {
            return 0
        }
        var b = (c == (c = Math.abs(c)));
        c = Math.floor(parseFloat((c + "").replace(/[^\d\.-]/g, ""))) + "";
        var a = c.split(".")[0].split("").reverse()
            , d = "";
        for (i = 0; i < a.length; i++) {
            d += a[i] + ((i + 1) % 3 == 0 && (i + 1) != a.length ? "," : "")
        }
        c = d.split("").reverse().join("");
        if ("0" == c) {
            return 0
        } else {
            return ( ((b) ? "" : "-") + c)
        }
    },
    isOrderId: function(d) {
        if ((/^[ZYBzyb]+[0-9]{12}$/).test(d)) {
            var b = d.substr(1, 6);
            var c = /^(\d{6})$/;
            var a = d.substr(7, 6);
            if (c.test(b) && "0" < b.substr(2, 2) < "13" && "0" < b.substr(4, 2) < "32" && !isNaN(parseInt(a))) {
                return true
            } else {
                return false
            }
        } else {
            return false
        }
    },
    products: {
        "1": ["01", "02", "07", "08", "12", "13", "18", "19", "23", "24", "29", "30", "34", "35", "40", "45", "46"],
        "2": ["03", "04", "09", "10", "14", "15", "20", "25", "26", "31", "36", "37", "41", "42", "47", "48"],
        "3": ["05", "06", "11", "16", "17", "21", "22", "27", "28", "32", "33", "38", "39", "43", "44", "49"],
        "4": ["01", "03", "05", "07", "09", "10", "12", "14", "16", "18", "21", "23", "25", "27", "29", "30", "32", "34", "36", "38", "41", "43", "45", "47", "49"],
        "5": ["02", "04", "06", "08", "11", "13", "15", "17", "19", "20", "22", "24", "26", "28", "31", "33", "35", "37", "39", "40", "42", "44", "46", "48"],
        "6": ["01", "03", "05", "07", "09", "11", "13", "15", "17", "19", "21", "23", "25", "27", "29", "31", "33", "35", "37", "39", "41", "43", "45", "47", "49"],
        "7": ["02", "04", "06", "08", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40", "42", "44", "46", "48"],
        "8": ["25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49"],
        "9": ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"],
        "10": ["01", "07", "13", "19", "23", "29", "35", "45"],
        "11": ["02", "08", "12", "18", "24", "30", "34", "40", "46"],
        "12": ["29", "30", "34", "35", "40", "45", "46"],
        "13": ["01", "02", "07", "08", "12", "13", "18", "19", "23", "24"],
        "14": ["03", "09", "15", "25", "31", "37", "41", "47"],
        "15": ["04", "10", "14", "20", "26", "36", "42", "48"],
        "16": ["25", "26", "31", "36", "37", "41", "42", "47", "48"],
        "17": ["03", "04", "09", "10", "14", "15", "20"],
        "18": ["05", "11", "17", "21", "27", "33", "39", "43", "49"],
        "19": ["06", "16", "22", "28", "32", "38", "44"],
        "20": ["27", "28", "32", "33", "38", "39", "43", "44", "49"],
        "21": ["05", "06", "11", "16", "17", "21", "22"],
        "22": ["25", "27", "29", "31", "33", "35", "37", "39", "41", "43", "45", "47", "49"],
        "23": ["26", "28", "30", "32", "34", "36", "38", "40", "42", "44", "46", "48"],
        "24": ["01", "03", "05", "07", "09", "11", "13", "15", "17", "19", "21", "23"],
        "25": ["02", "04", "06", "08", "10", "12", "14", "16", "18", "20", "22", "24"],
        "0": ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49"]
    },
    odds_light: 5000,
    popup_size: [910, 236],
    cps_connect_log: false,
    channel: {
        common: "commonset"
    },
    ajaxtimout: 5000,
    time_result_status: 2000,
    time_result_progress: 400,
    lianma_list: {
        game: {
            "008": {
                amt: 3100,
                list: {
                    "17,18": [7890, 109],
                    "27,28": [7890, 109],
                    "17,28": [7890, 109],
                    "37,28": [7890, 109]
                },
                sum: [5820, 100]
            },
            "009": {
                amt: 2200,
                list: {
                    "16,11": [6820, 160],
                    "26,21": [6820, 160],
                    "16,21": [6820, 160],
                    "36,21": [6820, 160]
                },
                sum: [5820, 100]
            },
            "010": {
                amt: 4100,
                list: {
                    "15,32": [8820, 101],
                    "25,34": [8820, 101],
                    "15,34": [8820, 101],
                    "35,34": [8820, 101]
                },
                sum: [5820, 100]
            },
            "011": {
                amt: 2400,
                list: {
                    "12,11,12": [9920, 100],
                    "24,21,24": [9920, 100],
                    "24,13,24": [9920, 100],
                    "24,22,24": [9920, 100],
                    "24,31,24": [9920, 100]
                },
                sum: [5820, 100]
            },
            "012": {
                amt: 2100,
                list: {
                    "11,12,11": [6660, 107],
                    "21,24,21": [6660, 107],
                    "13,24,13": [6660, 107],
                    "22,24,22": [6660, 107],
                    "31,24,31": [6660, 107]
                },
                sum: [5820, 100]
            }
        },
        time: "2534343434"
    },
    game_odds3: ",odds3,013,014,015,017,018,019,020,021,022,023,024,025,026,027,028,029,030,031,032,033,047,048,049,050,051,052,053,",
    game_name: {
        0: "{#|7279|7801#}".keyComment(),
        1: "{#|6b63|7801#}".keyComment(),
        2: "{#|6b63|7801#}特".keyComment(),
        3: "{#|8fde|7801#}二".keyComment(),
        4: "{#|8fde|7801#}三".keyComment(),
        5: "{#|8fc7|5173#}".keyComment(),
        6: "{#|751f|8096#}".keyComment(),
        7: "{#|5c3e|6570#}".keyComment(),
        8: "{#|534a|6ce2#}".keyComment(),
        9: "{#|516d|8096#}".keyComment(),
        10: "{#|4e24|9762#}".keyComment(),
        11: "{#|8272|6ce2#}".keyComment(),
        12: "{#|7279|8096#}".keyComment(),
        13: "{#|751f|8096|8fde#}".keyComment(),
        14: "{#|5c3e|6570|8fde#}".keyComment(),
        15: "{#|4e0d|4e2d#}".keyComment()
    }
});
var Header = function(b) {
    this.d = b;
    this.onDom = null;
    this.lastStatus;
    this.marquee = document.getElementById("marquee");
    this.open = $("#open");
    this.close = $("#close");
    this.ath = null;
    this.lock_link = {
        report: 0,
        result: 0
    };
    this.form = $("#drkusukp form")[0];
    this.netState = 0;
    this.gms_fcorp = window.gms_fcorp ? 1 : 0;
    var a = (new Date()).getTime();
    this.active_ajax = {
        refersh_draw: {
            active: true,
            last_time: a,
            timer: 1000,
            param: ""
        },
        getMarqueeOdds: {
            active: false,
            last_time: a,
            timer: 0,
            param: ""
        },
        get_monitor_data: {
            active: false,
            last_time: a,
            timer: 0,
            param: ""
        },
        get_statics_data: {
            active: false,
            last_time: a,
            timer: 0,
            param: ""
        },
        get_user_online: {
            active: false,
            last_time: a,
            timer: 1000,
            param: ""
        }
    };
    if (this.gms_fcorp === 1) {
        this.close.hide();
        this.open.hide();
        delete this.getMarqueeOdds
    }
    this.init();
    $.initLog4js()
};
Header.prototype.init = function() {
    this.init_header(header_info);
    this.bind();
    this.actions();
    if (this.gms_fcorp !== 1) {
        this.meq_corp_odds()
    }
    this.refersh();
    this.lineSwitch()
}
;
Header.prototype.refersh = function() {
    var f = this;
    var h = "";
    var g = "";
    var d = (new Date()).getTime();
    var c = 10000;
    for (var a in this.active_ajax) {
        var b = this.active_ajax[a];
        if (b.active && d - b.last_time >= b.timer) {
            $.log4js(a + b.timer + b.param);
            h += a + "|";
            g += b.param;
            if (b.timer > c) {
                c = b.timer
            }
        }
    }
    if (h) {
        $.ajax({
            url: "/ajax_req/req?act=" + h + g,
            dataType: "json",
            timeout: c,
            complete: function() {
                setTimeout(function() {
                    f.refersh()
                }, 1000)
            },
            success: function(m) {
                d = (new Date()).getTime();
                for (var j in m) {
                    if (!j) {
                        continue
                    }
                    var k = $.evalJSON(m[j]);
                    try {
                        switch (j) {
                            case "refersh_draw":
                                f.refershStatus(k);
                                break;
                            case "getMarqueeOdds":
                                if (f.gms_fcorp !== 1) {
                                    $.trigger("refersh_corp_odds", [k])
                                }
                                break;
                            case "get_monitor_data":
                                $.trigger("get_monitor_data", [k]);
                                break;
                            case "get_statics_data":
                                if (f.active_ajax[j].active) {
                                    $.trigger("get_statics_data", [k])
                                }
                                break;
                            case "get_user_online":
                                if (f.active_ajax[j].active) {
                                    $.trigger("get_user_online", [k])
                                }
                                break
                        }
                    } catch (l) {
                        f.active_ajax[j].active = false
                    }
                    if (f.active_ajax[j]) {
                        f.active_ajax[j].last_time = d
                    }
                }
            }
        })
    } else {
        setTimeout(function() {
            f.refersh()
        }, 1000)
    }
}
;
Header.prototype.bind = function() {
    var c = this
        , d = $("#odds_new").attr("level");
    $.bind("lightOperator", function(g, f) {
        c.lightOperator("" + f)
    });
    $.bind("log", function(h, f, g) {
        if (!$.cps_connect_log || !f || !g) {
            return
        }
        $.get("ajax_req.htm?act=savelog&l=" + g + "&m=" + encodeURIComponent(f))
    });
    $.bind("cpsdata.header", function(f, g) {
        if (g.backMarquee) {
            c.marquee.innerHTML = g.backMarquee
        }
        if (g.drawStatus) {
            c.lastStatus = g.drawStatus;
            c.lightOperator(g.drawStatus);
            $.trigger("pagefresh")
        }
        if ($("#progress_cover").text() == "" && g.calcstatus) {
            $.show_calc_status(g.calcstatus, false)
        }
    });
    c.isbChangeOrder = false;
    $.bind("isbChangeOrder", function(f, g) {
        if (1 == g && false === c.isbChangeOrder && "0" === d) {
            JqueryDialog.Open1("", "statis/b_change_order.htm", 480, 236, false, true, false, false, "resetbChangeOrder");
            c.isbChangeOrder = true
        } else {
            if (0 == g) {
                c.isbChangeOrder = false
            }
        }
    });
    $.bind("resetbChangeOrder", function() {
        c.isbChangeOrder = false
    });
    $(window).unload(function() {
        $.unbind(".header")
    });
    $.bind("getinit", function() {
        $.trigger("init", [{
            status: c.lastStatus
        }])
    });
    $.bind("qisustate", function(f, g) {
        c.lightOperator(g)
    });
    $.bind("toajax.header", function(f, g) {
        if (c.ath) {
            clearTimeout(c.ath);
            c.ath = null
        }
        if (g) {
            c.refershStatus({})
        }
    });
    $.bind("ajaxconnect", function(f, g) {
        switch (g) {
            case 0:
                c.setNetState(1);
                break;
            case -1:
                c.setNetState(-1);
                break
        }
    });
    $.bind("change_ajax_timer", function(g, f, h) {
        for (key in h) {
            if (h.hasOwnProperty(key)) {
                c.active_ajax[f][key] = h[key]
            }
        }
        if (f === "get_statics_data") {
            c.active_ajax.get_monitor_data["active"] = false
        } else {
            if (f === "get_monitor_data") {
                c.active_ajax.get_statics_data["active"] = false
            }
        }
    });
    if (cmset.cometAction) {
        $.bind("changechannel", function(h, g, f) {
            if (1 === c.netState || 0 === c.netState) {
                $.trigger("toajax", [1])
            }
            g = (g && $.channel[g]) ? $.channel.common + "|" + $.channel[g] : $.channel.common;
            f = f || 0;
            if (cmset.token) {
                cm.run({
                    url: cmset.cometUrl,
                    token: cmset.token,
                    asname: cmset.asname,
                    timestamp: f,
                    channel: g,
                    domain: domain,
                    filter: function(j) {
                        if ("2" == j.drawStatus) {
                            j.drawStatus = "1"
                        }
                        return j
                    }
                })
            } else {
                c.setNetState(0)
            }
        });
        $.bind("cpsconnect", function(f, g) {
            switch (g) {
                case 0:
                case 1:
                    c.setNetState(3);
                    break;
                case 2:
                    c.setNetState(2);
                    break;
                case -2:
                    c.setNetState(0);
                    break
            }
            $.trigger("log", ["cpsconnect: " + g, 1])
        });
        $.trigger("changechannel", [null, header_info.time_stamp]);
        setInterval(function() {
            $.ajax({
                url: "ajax_req.htm?act=keep_call"
            })
        }, 1000 * 9 * 60)
    }
    if (0 === domainOK) {
        $.trigger("log", ["Set domain fail.", 0])
    }
    var a = $("#show_ip").attr("popup");
    if (a == 1) {
        var b = "./rule/noticehistory.htm";
        JqueryDialog.Open1('<h2 class="g-tit">历史公告</h2>', b, 706, 322, false, true)
    }
}
;
Header.prototype.lightOperator = function(a) {
    if (!document.getElementById("open")) {
        return
    }
    if ("1" == a) {
        this.open.removeClass("oactive").addClass("oinact").attr("disabled", "disabled");
        this.close.addClass("cactive").removeClass("cinact").removeAttr("disabled")
    } else {
        this.open.addClass("oactive").removeClass("oinact").removeAttr("disabled");
        this.close.removeClass("cactive").addClass("cinact").attr("disabled", "disabled")
    }
    $.trigger("gameupdate", [{
        status: a
    }])
}
;
Header.prototype.refershStatus = function(d) {
    var g = this;
    this.setNetState(1);
    this.active_ajax.refersh_draw.timer = ("0" == d.status) ? 1000 : $.draw_refersh;
    this.active_ajax.get_user_online.timer = this.active_ajax.refersh_draw.timer;
    if (d.status) {
        this.lightOperator(d.status);
        if (d.status !== this.lastStatus) {
            $.trigger("pagefresh");
            $.trigger("gameupdate", [{
                status: d.status
            }]);
            this.lastStatus = d.status
        }
    }
    if (d.marquee) {
        this.marquee.innerHTML = "<a href='javascript:void()' marquee='1' >" + d.marquee + "</a>"
    }
    if (d.popup) {
        JqueryDialog.Close(false);
        var c = "./rule/noticehistory.htm?act=new";
        JqueryDialog.Open1('<h2 class="g-tit">历史公告</h2>', c, 706, 322, false, true)
    }
    if ($("#progress_cover").text() == "" && d.calc_status != undefined) {
        $.show_calc_status(d.calc_status, false)
    }
    if (d.hasOwnProperty("hasReport")) {
        d.hasReport = parseInt(d.hasReport, 10);
        var a = $("#adminheader ul li")
            , b = document.getElementById("grpt")
            , f = Math.floor(a.length / 2);
        if (d.hasReport == 1) {
            if (!b) {
                b = $('<li id="grpt" class=""><a act="report" href="totalreports/report.htm" target="main">总报表</a></li>');
                b.insertAfter(a.get(f))
            } else {
                b.style.cssText = "display:block"
            }
        } else {
            if (b) {
                $(b).remove()
            }
        }
    }
    if (d.lines) {
        window.global_lines = d.lines
    }
}
;
Header.prototype.createDraw = function(c, a, d) {
    var g = this;
    var b = a.split("-");
    var f = d.split("-");
    $("span[name='draw_dt_fix']").text(b[0] + " 年 " + b[1] + "月 " + b[2] + " 日 ");
    this.form.name.value = c;
    this.form.oth.value = b[3];
    this.form.otm.value = b[4];
    this.form.nth.value = f[3];
    this.form.ntm.value = f[4];
    cover.show();
    $("#drkusukp").show();
    setTimeout(function() {
        g.form.oth.focus()
    }, 0)
}
;
Header.prototype.actions = function() {
    var f = this, b = $("#diff_ip"), g = $("#show_ip"), h = function() {
        clearTimeout(d);
        g.hide()
    }, d;
    if (document.cookie.indexOf("showIP") == -1) {
        g.show();
        document.cookie = "showIP=" + escape("1") + ";path=/" + location.pathname.split("/")[1];
        $("#show_ip_close").click(h);
        d = setTimeout(h, 5000)
    }
    if (b.length) {
        var a = $("<iframe allowTransparency='true' class='diff_ip_shadow'></iframe>").appendTo("body");
        a.css("height", document.documentElement.scrollHeight + "px");
        b.show();
        $("button", b).click(function() {
            b.remove();
            a.remove()
        });
        b.delegate("a", "click", function() {
            $("#nav li").removeClass("on").last().addClass("on");
            f.active_ajax.get_monitor_data.active = false;
            f.active_ajax.get_statics_data.active = false;
            b.remove();
            a.remove()
        })
    }
    var c = function() {
        cover.hide();
        $(f.form.submit).removeAttr("disabled");
        $("#drkusukp").hide()
    };
    this.form.onsubmit = function() {
        $(this.submit).attr("disabled", "disabled");
        var k = function(l) {
            if (l.oth.value + l.otm.value >= l.nth.value + l.ntm.value) {
                return true
            } else {
                alert("非{#|7279|7801#}{#|505c|62bc#}时间不能大于{#|5173|76d8#}时间".keyComment());
                return false
            }
        };
        $.formatTime(this.oth, this.otm, this.nth, this.ntm);
        if (!$.validateForm(this) || !k(this)) {
            $(this.submit).removeAttr("disabled");
            return false
        }
        var j = function(l) {
            if ("error" == l.status) {
                alert(l.msg);
                $(f.form.submit).removeAttr("disabled")
            } else {
                alert("{#|5f00|76d8#}成功".keyComment());
                f.lightOperator("1");
                f.lastStatus = 1;
                c();
                $.trigger("pagefresh")
            }
        };
        $.getJSON("ajax_req.htm?act=open_draw&submit=submit&name=" + this.name.value + "&hour=" + this.oth.value + "&minute=" + this.otm.value + "&nhour=" + this.nth.value + "&nminute=" + this.ntm.value, j);
        return false
    }
    ;
    this.form.cancel.onclick = function() {
        c()
    }
    ;
    $(this.d).click(function(n) {
        var l = n.target;
        var o = l.parentNode;
        var k = $(l).attr("act");
        if ("A" === l.tagName && (k == "result" || k == "report")) {
            var m = new Date();
            m = m.getTime();
            var j = 10 - parseInt((m - f.lock_link[k]) / 1000);
            if (j > 0) {
                alert("您的请求过于频繁，请在" + j + "秒后再查看。");
                return false
            }
            f.lock_link[k] = m
        }
        if ("A" === l.tagName && o !== f.onDom && "LI" === o.tagName) {
            f.onDom ? $(f.onDom).removeClass("on") : $(f.d).find("li.on").removeClass("on");
            f.onDom = o;
            $(o).addClass("on");
            f.active_ajax.get_monitor_data.active = false;
            f.active_ajax.get_statics_data.active = false;
            return
        }
        switch (k) {
            case "logout":
                return window.confirm("你确定要退出吗?");
            case "open":
                if ($(l).hasClass("oactive") && confirm("你确认要{#|5f00|76d8#}吗".keyComment())) {
                    $.getJSON("ajax_req.htm?act=open_draw", function(p) {
                        if ("error" == p.status) {
                            alert(p.msg)
                        } else {
                            if ("create" == p.status) {
                                f.createDraw(p.name, p.end, p.stop)
                            } else {
                                alert("{#|5f00|76d8#}成功".keyComment());
                                f.lightOperator("1");
                                f.lastStatus = 1;
                                $.trigger("pagefresh")
                            }
                        }
                    })
                }
                return false;
            case "close":
                if ($(l).hasClass("cactive") && confirm("你确认要{#|5173|76d8#}吗".keyComment())) {
                    $.get("ajax_req.htm?act=close_draw", function(p) {
                        if ("no_close_draw" == p) {
                            alert("当前没有{#|5f00|76d8#}{#|671f|6570#}，不能执行此操作".keyComment());
                            return
                        }
                        if ("" != p) {
                            alert("{#|5173|76d8#}失败".keyComment());
                            return
                        }
                        alert("{#|5173|76d8#}成功".keyComment());
                        f.lightOperator("0");
                        f.lastStatus = 2;
                        $.trigger("pagefresh")
                    })
                }
                return false
        }
    });
    $("#marquee").bind("click", function() {
        var j = "./rule/noticehistory.htm?act=more";
        var k = 322;
        JqueryDialog.Open1('<h2 class="g-tit">历史公告</h2>', j, 706, k, false, true)
    })
}
;
Header.prototype.setNetState = function(c) {
    if ((1 === c && this.netState > 0) || -2 === this.netState) {
        return
    }
    var a = $(".ct>div")[0];
    switch (c) {
        case -2:
            a.className = "";
            a.title = "您的账户已经{#|505c|62bc#}，不可以{#|6295|6ce8#}".keyComment();
            $.trigger("toajax", [0]);
            break;
        case -1:
            a.className = "";
            a.title = "无法自动获取最新{#|8d54|7387#}，请手动刷新".keyComment();
            break;
        case 0:
            a.className = "";
            a.title = "无法自动获取最新{#|8d54|7387#}，转AJAX".keyComment();
            var b = setTimeout(function() {
                b = null;
                $.trigger("toajax", [1])
            }, $.getRound(5, 25));
            break;
        case 1:
            a.className = "a";
            a.title = "Ajax方式刷新";
            break;
        case 2:
            a.className = "b";
            a.title = "长轮询（long-polling）方式刷新";
            $.trigger("toajax", [0]);
            break;
        case 3:
            a.className = "c";
            a.title = "流（streaming）方式刷新";
            $.trigger("toajax", [0]);
            break
    }
    this.netState = c
}
;
Header.prototype.init_header = function(a) {
    this.marquee.innerHTML = "<a href='javascript:void()' marquee='1' >" + a.marquee + "</a>";
    this.lastStatus = a.status;
    this.lightOperator(a.status);
    if (!cmset.cometAction) {
        this.refershStatus(a)
    }
    if (a.lines) {
        window.global_lines = a.lines
    }
}
;
Header.prototype.meq_corp_odds = function() {
    var g = this;
    var h = $("#odds_new");
    if (h.attr("level") !== "0") {
        return
    }
    this.active_ajax.getMarqueeOdds.timer = parseInt(h.attr("time"), 10) || 5000;
    this.active_ajax.getMarqueeOdds.active = true;
    var j = 0;
    var q;
    var m = h.children("ul:first"), d = 500, f = [], c = 0, l = 18, b;
    h.click(function(u) {
        var s = u.target;
        if ("LI" != s.tagName) {
            s = $(s).parent("LI")[0];
            if (!s) {
                return
            }
        }
        $.trigger("newpeilv", [1, cover, ($(s).children("span:first")[0] ? 1 : 0)])
    });
    var p = $("div[sound]:first", h), o, a;
    if (p[0]) {
        a = window.ActiveXObject ? $("<bgsound />").appendTo(p)[0] : "";
        o = p.attr("sound")
    }
    var k = function() {
        if (b > 1) {
            if (b - c <= 1) {
                c = 0;
                m.css({
                    top: 0
                })
            }
            c++;
            m.animate({
                top: -c * l
            }, d)
        }
    };
    var r = function() {
        if (b > 1) {
            if (c <= 0) {
                c = b - 1;
                m.css({
                    top: -c * l
                })
            }
            c--;
            m.animate({
                top: -c * l
            }, d)
        }
    };
    var n = function(v) {
        if (1 === v.no_game) {
            f[0] = "";
            f[1] = "";
            m.html("");
            b = 0
        }
        var s = [], x, u = 0;
        if (v.self && v.self.length > 0) {
            for (x = 0; x < v.self.length; x++) {
                q = v.self[x].time_stamp;
                q = q.substr(0, 4) + q.substr(5, 2) + q.substr(8, 2) + q.substr(11, 2) + q.substr(14, 2) + q.substr(17, 2);
                s.push(v.self[x].game_name + " " + v.self[x].number_name + " " + v.self[x].odds);
                if (j < parseInt(q, 10)) {
                    j = q
                }
            }
            f[0] = "<span>" + v.self_name + "</span><em>|</em>" + s.join("<em>|</em>");
            u = 1
        } else {
            f[0] = undefined
        }
        s = [];
        if (v.corp && v.corp.length > 0) {
            for (x = 0; x < v.corp.length; x++) {
                q = v.corp[x].time_stamp;
                q = q.substr(0, 4) + q.substr(5, 2) + q.substr(8, 2) + q.substr(11, 2) + q.substr(14, 2) + q.substr(17, 2);
                s.push(v.corp[x].short_name + " " + v.corp[x].game_name + " " + v.corp[x].number_name + " " + v.corp[x].odds);
                if (j < parseInt(q, 10)) {
                    j = q
                }
            }
            f[1] = s.join("<em>|</em>");
            u = 1
        } else {
            f[1] = undefined
        }
        if (u) {
            m.html("<li>" + f.join("</li><li>") + "</li>").find("li:empty").remove();
            b = m.append($("li:first", m).clone()).children("li").length;
            if (b == 2) {
                c = 1;
                m.css({
                    top: -c * l
                });
                c--;
                m.animate({
                    top: -c * l
                }, d)
            }
            if (c >= b) {
                r()
            }
            if (a && o) {
                if (window.ActiveXObject) {
                    a.src = o
                } else {
                    try {
                        a.playsound(o)
                    } catch (w) {}
                }
            }
        } else {
            m.html("")
        }
        g.active_ajax.getMarqueeOdds.param = "&time_stamp=" + j
    };
    $.bind("refersh_corp_odds", function(s, t) {
        n(t)
    });
    $.bind("setpdtime", function(s, t) {
        g.active_ajax.getMarqueeOdds.timer = t
    });
    $(this.d).click(function(u) {
        var s = u.target;
        switch (s.getAttribute("act")) {
            case "up":
                r();
                break;
            case "down":
                k();
                break
        }
    })
}
;
Header.prototype.lineSwitch = function() {
    var n = document.getElementById("lines_box"), l = $("#linesSwitch"), k = $("#testSpeed"), c = true, j = new Cover("#fff",0.3,4), b, p = [], f = function() {
        c = true;
        if (b) {
            b.abort();
            b = null
        }
        l.addClass("hid");
        j.hide();
        p = []
    }, m = function() {
        p = [];
        b = null;
        c = false;
        l.removeClass("hid");
        h();
        j.show()
    };
    l.bind("click", function(u) {
        var q = u.target;
        if (q.id === "closeSpeed") {
            f()
        }
        if (q.id === "testSpeed" && !q.disabled) {
            m()
        }
        if (q.type === "button" && q.getAttribute("url")) {
            var s = $("#product_menu .on")
                , r = $("#header_link").attr("hr")
                , v = window.frames[0].location.pathname.split("/");
            if (s.length) {
                v = s.attr("href").replace(/\.html$/, "_l").replace(/\.htm$/, "")
            } else {
                if (r) {
                    v = r
                } else {
                    v = v[2] + "/" + v[3].replace(/\.html$/, "_l").replace(/\.htm$/, "")
                }
            }
            location.href = q.getAttribute("url") + "?" + document.cookie.replace(/\s/g, "").replace(/;/g, "&") + "&nav=" + v
        }
    });
    $("#linesSwitchBtn").bind("click", function() {
        if (l.hasClass("hid")) {
            m()
        }
    });
    var a = function() {
        var r = window.global_lines || [], s = '<div class="line">线路{lineNo}： <span class="speed">反应时间: <span id="line{lineNo}" url="{url}"  class="time">测速中</span> </span> <input  url="{url}" value="选择"  type="button"/> </div>', u = [], v;
        for (var q = 0, t = r.length; q < t; q++) {
            v = {
                id: "line" + (q + 1),
                url: r[q].split("/").slice(0, 3).join("/") + "/speed.php?t="
            };
            u.push(s.replace(/{lineNo}/g, q + 1).replace(/{url}/g, r[q]));
            p.push(v)
        }
        n.innerHTML = u.join("");
        return p
    }
        , d = function(q, v) {
        var x, r, u, s, w, t = document.createElement("script");
        w = setTimeout(function() {
            t.onload = t.onerror = t.onreadystatechange = null;
            s = Math.floor((Math.random() * 120) + 180) + ".00毫秒";
            document.getElementsByTagName("head")[0].removeChild(t);
            v.call(q, s, u)
        }, 1000);
        t.onload = t.onreadystatechange = function() {
            if (/loaded|complete|undefined/.test(t.readyState)) {
                r = +new Date();
                if (!st || (st == 0 || st == -1)) {
                    s = "无法链接"
                }
                u = r - x + st;
                st = -1;
                clearTimeout(w);
                document.getElementsByTagName("head")[0].removeChild(t);
                v.call(q, s, u)
            }
        }
        ;
        t.onerror = function() {
            s = "无法链接";
            clearTimeout(w);
            document.getElementsByTagName("head")[0].removeChild(t);
            v.call(q, s, u)
        }
        ;
        t.async = "async";
        t.src = q.url + Math.random();
        x = +new Date();
        document.getElementsByTagName("head")[0].appendChild(t)
    }
        , g = function(q, u) {
        if (q) {
            document.getElementById(this.id).innerHTML = "<span class='red'>" + q + "</span>";
            o()
        } else {
            if (this.count == 2) {
                this.result.push(u);
                var w = 0
                    , t = 0
                    , v = this.result.length
                    , s = "red";
                for (; t < v; t++) {
                    w += this.result[t]
                }
                w = parseFloat(w / v);
                if (w < 50) {
                    s = "green"
                }
                w = w.toFixed(2);
                document.getElementById(this.id).innerHTML = "<span class='" + s + "' >" + w + "ms</span>";
                o()
            } else {
                this.count += 1;
                this.result.push(u);
                d(this, g)
            }
        }
    }
        , o = function() {
        lineInfo = p.shift();
        var q;
        if (lineInfo) {
            q = document.getElementById(lineInfo.id);
            q.innerHTML = "测速中";
            lineInfo.count = 1;
            lineInfo.result = [];
            d(lineInfo, g)
        }
    }
        , h = function() {
        a();
        o()
    }
}
;
$.extend({
    actChgUserStatus: function(n, b, d) {
        var p = n.target;
        var m = p.getAttribute("act");
        if (null === m) {
            return true
        }
        var l = p.getAttribute("pid");
        var h = p.getAttribute("tid");
        var o = p.getAttribute("page");
        var g = 0;
        switch (m) {
            case "qiyong":
                g = 1;
                break;
            case "tingya":
                g = 2;
                break;
            case "shanchu":
                g = 4;
                break
        }
        var j = n.target.parentNode.parentNode;
        var r = $(".g-tit").html();
        if (1 == b || 0 == b) {
            r = r.substr(0, 3)
        } else {
            r = r.substr(0, 2)
        }
        var f = j.cells[2].innerHTML
            , k = "";
        if (0 == b) {
            k = j.cells[1].innerHTML.replace(/^\s+(\w+)\s+$/, "$1");
            if (!k) {
                k = j.cells[3].innerHTML
            }
            var q = f + "[" + k + "]"
        } else {
            f = f.replace(/<.*?>|&nbsp;/g, "");
           /* var a = f.split("[");
            var c = a[1].split(",");
            if (c[0].indexOf("]") > 0) {
                c[0] = c[0].replace("]", "")
            }
            var q = a[0] + "[" + c[0] + "]"*/
        }
        if (g == 4 && !confirm("確認刪除" + r + ":" + f + "嗎？刪除後不可恢復！")) {
            return false
        }
        $.getJSON($.getChgStatusUrl(b, h, g, l, d), function(s) {
            $.chgUserStatus(n, s, b, h, g, o, l, d)
        });
        return false
    },
    chgUserStatus: function(w, o, a, s, v, f, n, p) {
        var g = w.target;
        var k = w.target.parentNode.parentNode;
        var h = 0;
        if (g.href.indexOf("admin_list.htm") < 0) {
            for (var r = 1; r <= 5 - a; r++) {
                h = h + parseInt(k.cells[k.cells.length - 3 - r].innerHTML, 10)
            }
        }
        var x = k.cells.length - 3;
        var y = x + 2;
        if ("0" != o) {
            switch (o) {
                case 2:
                    alert("該賬號為初始賬號，不能執行該操作！");
                    break;
                case -2:
                    alert("必須先啟用上級賬號！");
                    break;
                case -3:
                    alert("上級賬號已停用！");
                    break;
                case -4:
                    alert("{#|5f00|76d8#}狀態下，不允許刪除！".keyComment());
                    break;
                case -5:
                    alert("該賬號已經被刪除，不能執行該操作！");
                    break;
                case -6:
                    alert("系統不允許刪除下級帳號！");
                    break;
                case -100:
                    alert("用戶正在啟用中，不可以刪除！");
                    break;
                case -200:
                    alert("此用戶為主管理員，不可以刪除！");
                    break;
                case -300:
                    alert("此用戶有下級用戶或者會員，不可以刪除！");
                    break;
                case -1001:
                    alert("當前用戶狀態異常，不可以刪除！");
                    break;
                default:
                    alert("操作失敗！");
                    break
            }
            return
        }
        if (v == 4) {
            alert("刪除賬號成功！");
            window.location.href = window.location.href;
            return
        }
        var z = ["<span class='red'>停用</span>", "启用", "<span class='red'>{#|505c|62bc#}</span>".keyComment()];
        k.cells[x].innerHTML = z[v];
        var u = [[0, 1, 2, 4], [1, 0, 2, 4], [2, 1, 0, 4]];
        var t = ["admin", "user1", "user2", "user2", "user2", "member"];
        var m = "<a class='a_btm_line' href='" + t[a] + "_create.htm?op=upd&id=" + s + "&pageId=" + f + "&keywordstatus=" + v + "&keyword=" + p + "&level=" + a + "&parentid=" + n + "'>修改</a>";
        var b = $.getStatusUrl(a, s, u[v][1], f, n);
        var c = $.getStatusUrl(a, s, u[v][2], f, n);
        var l = $(":hidden[name=drawstatus]")[0].value;
        var j = $(":hidden[name=delDownLine]").val() || 1;
        var q = $(k).find("input[name='delAccountAll']");
        if (v == 0 && h == 0 && l == 1 && j == 1) {
            var d = $.getStatusUrl(a, s, u[v][3], f, n);
            k.cells[y].innerHTML = b + "/&nbsp;" + c + "/&nbsp;" + d + "/&nbsp;" + m;
            q.show();
            q.attr("checked", false);
            $("input[name='checkAllAccount']").attr("checked", false)
        } else {
            k.cells[y].innerHTML = b + "/&nbsp;" + c + "/&nbsp;" + m;
            q.attr("checked", false);
            q.hide()
        }
    },
    getChgStatusUrl: function(f, d, c, a, b) {
        return "user/changStatus?level=" + f + "&pid=" + a + "&id=" + d + "&status=" + c + "&keyword=" + b
    },
    getStatusUrl: function(h, g, c, d, b) {
        var f = ["admin", "user", "user", "user", "user", "member"];
        var a = [["tingyong", "停用"], ["qiyong", "启用"], ["tingya", "{#|505c|62bc#}".keyComment()], ["tingyong", "停用"], ["shanchu", "删除"]];
        return "<a class='a_btm_line' act='" + a[c][0] + "' pid='" + b + "' tid='" + g + "' page='" + d + "' href='" + f[h] + "_list.htm?level=" + h + "'>" + a[c][1] + "</a>"
    },
    userList: function(l, b) {
        var n = ["admin", "user", "user", "user", "user", "member"]
            , f = $("select[name=parentid]:first", l)
            , r = $("select[name=keywordstatus]:first", l)
            , j = 0

            , g = -1
            , o = $("input[name='keyword']")
            , c = encodeURIComponent(o.val());
        if (o.val() == "請輸入名稱/賬號") {
            c = ""
        }
        f.change(function(d) {
            g = r[0].value;
            location.replace(n[b] + "_list.htm?op=slt&keywordstatus=" + g + "&keyword=" + c + "&parentid=" + (d.target).value + "&level=" + b)
        });
        r.change(function(d) {
            j = f[0] ? f[0].value : "";
            location.replace(n[b] + "_list.htm?op=slt&keywordstatus=" + (d.target).value + "&keyword=" + c + "&parentid=" + j + "&level=" + b)
        });
        $("tbody:first", l).click(function(d) {
            return $.actChgUserStatus(d, b, c)
        });
        var m = $(":submit");
        o.focus(function(s) {
            if ($(this).val() == "請輸入名稱/賬號") {
                $(this).val("")
            }
        });
        o.blur(function(s) {
            if ($.trim(this.value) == "") {
                $(this).val("請輸入名稱/賬號");
                $(this).addClass("gray")
            }
        });
        $(m).click(function() {
            var s = $.trim(o.val());
            if (s === "請輸入名稱/賬號") {
                o.val("")
            } else {
                var d = !$.isName(s);
                if (d) {
                    alert("輸入字符由漢字的簡繁體(一個漢字2位字符)、圓點（.）、字母、數字、下劃線組成，長度不超過16個英文字符或8個漢字！");
                    return false
                }
            }
        });
        var q = $("input[name='delAccountAll']");
        var a = $("input[name='checkAllAccount']");
        $("#batchDelSelectAll").click(function() {
            if (a.attr("checked")) {
                q.each(function() {
                    if ("none" != $(this).css("display")) {
                        q.attr("checked", true)
                    }
                })
            } else {
                q.attr("checked", false)
            }
        });
        q.click(function() {
            if ($(this).attr("checked")) {
                var s = 1;
                var d = false;
                q.each(function() {
                    if ("none" != $(this).css("display")) {
                        d = $(this).attr("checked");
                        if (!d) {
                            s = 0;
                            return false
                        }
                    }
                });
                if (s) {
                    a.attr("checked", true)
                }
            } else {
                a.attr("checked", false)
            }
        });
        $("#batchDelAll").click(function(d) {
            if (!confirm("確認刪除所有停用的賬號（包含管理員、代理商及會員）嗎？刪除後不可恢復！")) {
                return false
            }
            $.ajax({
                type: "GET",
                url: "ajax_req.htm?act=batch_remove_account",
                dataType: "json",
                success: function(s) {
                    msg = "";
                    if (0 == s.flag) {
                        if (0 == s.count) {
                            msg = "沒有已經停用的賬號！\n"
                        } else {
                            msg = "刪除所有已經停用的賬號成功！共成功刪除賬號" + s.count + "個\n"
                        }
                    } else {
                        s.flag = parseInt(s.flag, 10);
                        switch (s.flag) {
                            case -1:
                                msg = "您不是公司管理員，不能執行該操作！";
                                break;
                            case -2:
                                msg = "{#|5f00|76d8#}狀態下，不允許刪除！";
                                break;
                            default:
                                msg = "刪除失敗！";
                                break
                        }
                    }
                    alert(msg.keyComment());
                    window.location = window.location
                }
            })
        });
        $("#batchDel").click(function(s) {
            var t = "";
            $("input[name='delAccountAll'][@type=checkbox][checked]").each(function() {
                if ("none" != $(this).css("display")) {
                    t += $(this).val() + "|"
                }
            });
            t = t.slice(0, t.length - 1);
            if (t) {
                if (!confirm("確認刪除已選賬號嗎？刪除後不可恢復！")) {
                    return false
                }
                var u = s.target.getAttribute("level");
                var d = "ajax_req.htm?act=batchdel_account&id=" + t + "&level=" + u;
                $.ajax({
                    type: "GET",
                    url: d,
                    dataType: "json",
                    success: function(x) {
                        var y = "";
                        var w = "";
                        var v = "";
                        $.each(x, function(A, z) {
                            if ("success" == z.flag) {
                                w += z.id + "  刪除成功\n"
                            } else {
                                var B = "";
                                z.flag = parseInt(z.flag, 10);
                                switch (z.flag) {
                                    case 2:
                                        B = "該賬號為初始賬號，不能執行該操作！";
                                        break;
                                    case -4:
                                        B = "{#|5f00|76d8#}狀態下，不允許刪除！";
                                        break;
                                    case -6:
                                        B = "系統不允許刪除下級帳號！";
                                        break;
                                    case -100:
                                        B = "用戶正在啟用中，不可以刪除！";
                                        break;
                                    case -200:
                                        B = "此用戶為主管理員，不可以刪除！";
                                        break;
                                    case -300:
                                        B = "此用戶有下級用戶或者會員，不可以刪除！";
                                        break;
                                    case -1000:
                                        B = "此用戶已經被刪除或不存在！";
                                        break;
                                    case -1001:
                                        B = "當前用戶狀態異常，不可以刪除！";
                                        break;
                                    default:
                                        B = "操作異常";
                                        break
                                }
                                y += z.id + "  刪除失敗,原因:" + B + "\n"
                            }
                        });
                        if (w.length) {
                            v += w
                        }
                        if (y.length) {
                            if (v.length) {
                                v += y
                            } else {
                                v = y
                            }
                        }
                        alert(v);
                        window.location = window.location
                    }
                })
            } else {
                alert("請選擇要刪除的賬號");
                return false
            }
        });
        var h = ""
            , k = []
            , p = $("tbody td[id]", l);
        if (b) {
            $.each(p, function(d, s) {
                k[d] = s.id
            });
            h = "&id=" + k.join(",") + "&level=" + b;
            parent.$.trigger("change_ajax_timer", ["get_user_online", {
                active: true,
                param: h
            }]);
            parent.$.bind("get_user_online." + l.id, function(s, d) {
                if ($.isArray(d)) {
                    $.each(p, function(t, u) {
                        if ($.inArray(parseInt(u.id, 10), d) > -1) {
                            u.className = u.className.replace(/offline|online/, "online")
                        } else {
                            u.className = u.className.replace(/offline|online/, "offline")
                        }
                    })
                } else {
                    p.removeClass("online").addClass("offline")
                }
            });
            $(window).unload(function() {
                parent.$.trigger("change_ajax_timer", ["get_user_online", {
                    active: false,
                    param: ""
                }]);
                parent.$.unbind("get_user_online." + l.id)
            })
        }
    },
    adminReloadData: function(a) {
        $.userList(a, 0)
    },
    dgdList: function(a) {
        $.userList(a, 1)
    },
    gdList: function(a) {
        $.userList(a, 2)
    },
    zdlList: function(a) {
        $.userList(a, 3)
    },
    dlList: function(a) {
        $.userList(a, 4)
    },
    memberReloadData: function(a) {
        $.userList(a, 5)
    },
    adminRelaod: function(a) {
        $.checkAll($("#permission_body"))
    },
    gudongRelaod: function(a) {
        $.checkAll($("#gudong_discount_body"))
    },
    zdlRelaod: function(a) {
        $.checkAll($("#zdl_discount_body"))
    },
    dlsRelaod: function(a) {
        $.checkAll($("#dls_discount_body"))
    },
    subObjMaxlength: function(f) {
        var a = f.maxLength;
        var g = f.value;
        var b = "";
        var c, d;
        d = 0;
        for (c = 0; c < g.length; c++) {
            if ((g.charCodeAt(c) >= 0) && (g.charCodeAt(c) <= 255)) {
                d = d + 1
            } else {
                d = d + 2
            }
            if (d <= a) {
                b += g.charAt(c)
            } else {
                f.value = b;
                break
            }
        }
    },
    userCheck: function(r) {
        var f = r.getElementsByTagName("form")[0];
        $("#c_username input").blur(function() {
            $.subObjMaxlength(this)
        });
        $("#c_username input").keyup(function() {
            $.subObjMaxlength(this)
        });
        $(":text[valid=account]", f).focus(function(d) {
            if (this.defaultValue == this.value) {
                $(this).removeClass("gray");
                $(this).val("");
                $(this).click();
                $(this).data("val", this.defaultValue)
            }
        }).blur(function(w) {
            if (this.value == "" && $(this).data("val")) {
                $(this).val($(this).data("val"));
                $(this).addClass("gray")
            } else {
                if (this.value != "") {
                    var j = this.value
                        , u = $(this)
                        , d = u.data("old")
                        , x = "賬號已存在，請重新輸入！";
                    if (j == d) {
                        return
                    }
                    $.get("/user/checkAccount?account=" + j, function(v) {
                        if (v == 1) {
                            u.data("old", j);
                            alert(x);
                            u.select();
                            return
                        }
                    })
                }
            }
        });
        $(":text[valid=credit]", f).focus(function() {
            if (this.defaultValue == this.value) {
                $(this).removeClass("gray");
                $(this).val("");
                $(this).click();
                $(this).data("val", this.defaultValue)
            }
        }).blur(function() {
            if (this.value == "" && $(this).data("val")) {
                $(this).val($(this).data("val"));
                $(this).addClass("gray")
            }
        });
        $.back_filld(f);
        var b = f.shareParent ? parseInt(f.shareParent.value, 10) : 0;
        if (f.shareUp) {
            $(f.shareUp).change(function(y) {
                var w = y.target;
                var d = b - parseInt(w.value, 10);
                var x = f.shareTotal;
                var j = parseInt(x.value, 10) || 0;
                j = d > j ? j : d;
                x.length = 0;
                var v = (f.sharedown) ? parseInt(f.sharedown.value, 10) : 0;
                for (var u = v; u <= d; u += 5) {
                    var z = document.createElement("option");
                    z.setAttribute("value", u.toString());
                    z.appendChild(document.createTextNode(u.toString()));
                    if (u === j) {
                        z.setAttribute("selected", "selected")
                    }
                    x.appendChild(z)
                }
            })
        }
        var c = $("tr.discount_A input", f), h = $("tr.discount_B input", f), k = $("tr.discount_C input", f), a;
        if (f.handicap) {
            if (!f.handicap.disabled) {
                a = function() {
                    if (!f.handicap.disabled) {
                        var d = f.handicap.value;
                        c.attr("disabled", d === "A" ? false : true);
                        h.attr("disabled", d === "B" ? false : true);
                        k.attr("disabled", d === "C" ? false : true)
                    }
                }
                ;
                a();
                $(f.handicap).change(a)
            }
        }
        if (f.sys_user_oddsSet) {
            if (!f.sys_user_oddsSet.disabled) {
                var q = f.sys_user_oddsSet.value.charCodeAt(0);
                a = function(d) {
                    var j = f.sys_user_oddsSet.value.charCodeAt(0)
                        , u = false;
                    if (typeof d === "boolean") {
                        u = true
                    }
                    c.attr("disabled", j >= 65 ? false : true);
                    h.attr("disabled", function() {
                        var v = j >= 66 ? false : true
                            , w = !parseFloat(this.value)
                            , x = !!parseFloat(this.getAttribute("maxval"));
                        if (!v && w && x && !u && q < 66) {
                            this.value = this.getAttribute("maxval")
                        }
                        return v
                    });
                    k.attr("disabled", function() {
                        var v = j >= 67 ? false : true
                            , w = !parseFloat(this.value)
                            , x = !!parseFloat(this.getAttribute("maxval"));
                        if (!v && w && x && !u && q < 67) {
                            this.value = this.getAttribute("maxval")
                        }
                        return v
                    })
                }
                ;
                a(true);
                $(f.sys_user_oddsSet).change(a)
            }
        }
        if (f.sys_user_corpRptSum) {
            $(f.sys_user_corpRptSum).change(function() {
                var d = this.value;
                if (d == "0") {
                    f.sys_user_corpRptList.setAttribute("disabled", "disabled");
                    f.sys_user_corpRptList.value = "0"
                }
                if (d == "1") {
                    f.sys_user_corpRptList.removeAttribute("disabled");
                    f.sys_user_corpRptList.value = "0"
                }
            })
        }
        var m = ("create" == f.op.value) ? false : true;
        var g;
        var o;
        $(f).submit(function(K) {
            console.log(K);
            try {
                var F = this;
                var w = $(":text[valid=account]", this), C, d;
                if (w.length>0&& !w.attr("disabled")) {
                    C = w.val().replace(/\s/g, "");
                    d = w.data("old");
                    if (C == d) {
                        alert("賬號已存在，請重新輸入！");
                        setTimeout(function() {
                            w.select()
                        }, 10);
                        return false
                    }
                }
                if (F.userName) {
                    if (!$.validateForm(this)) {
                        return false
                    }
                    if (F.password.value !== F.sys_user_repassword2.value) {
                        alert("密碼兩次輸入不一致");
                        F.password.select();
                        return false
                    }
                    if (F.sys_user_permission) {
                        var G = [];
                        $(F).find('input[type="checkbox"]:checked').each(function(v) {
                            G.push(this.value)
                        });
                        F.sys_user_permission.value = G.join(",");
                        if (m) {
                            if (!$.isChangeForm(this)) {
                                alert("請修改後再保存");
                                return false
                            }
                        }
                        return true
                    }
                    if (F.credits && F.childsumcredit && parseInt(F.credits.value, 10) < parseInt(F.childsumcredit.value, 10)) {
                        alert("上級信用總額必須大於下級信用總額之和: " + F.childsumcredit.value);
                        return false
                    }
                    if (F.credits && F.parentcredit && parseInt(F.credits.value, 10) > parseInt(F.parentcredit.value, 10)) {
                        alert("下級信用總額不能超過上級剩餘{#|4fe1|7528|989d|5ea6#}: ".keyComment() + F.parentcredit.value);
                        return false
                    }
                } else {
                    if (F.__member_memberName) {
                        if (!$.validateForm(this)) {
                            return false
                        }
                        if (F.member_password.value !== F.member_repassword2.value) {
                            alert("密碼兩次輸入不一致");
                            F.member_password.select();
                            return false
                        }
                        if (F.member_credit && F.parentcredit && parseInt(F.member_credit.value, 10) > parseInt(F.parentcredit.value, 10)) {
                            alert("下級信用總額不能超過上級剩餘{#|4fe1|7528|989d|5ea6#}: ".keyComment() + F.parentcredit.value);
                            return false
                        }
                    }
                }
                if (F.user_hkms_status && r.id !== "u1create") {
                    if ($("input[name=parent_hkms_status]").val() == "0") {
                        if (F.user_hkms_status.value == "1") {
                            alert("上級{#|9ad8|989d|5f69#}已停用，不能啟用{#|9ad8|989d|5f69#}".keyComment());
                            return false
                        }
                    }
                }
                var I = ["ordermin", "ordermax", "itemmax", "pordermin", "pordermax", "cordermin", "cordermax", "pitemmax", "citemmax"];
                for (var H = 0; H < 16; H++) {
                    var y = parseInt(F[I[0] + H].value, 10);
                    var x = parseInt(F[I[1] + H].value, 10);
                    var u = parseInt(F[I[2] + H].value, 10);
                    var L = $.game_name[H];
                    if (F.parent_id && "1" == F.parent_id.value) {
                        continue
                    }
                    if (x > u) {
                        alert("[" + L + "]{#|5355|6ce8#}最高必須小於或等於{#|5355|9879#}最高".keyComment());
                        F[I[1] + H].select();
                        return false
                    }
                    if (y > x || y > u) {
                        alert("[" + L + "]{#|5355|6ce8#}最低必須小於或等於{#|5355|6ce8#}最高或{#|5355|9879#}最高".keyComment());
                        F[I[0] + H].select();
                        return false
                    }
                    if (F[I[3] + H]) {
                        var j = parseInt(F[I[3] + H].value, 10);
                        if (j > y) {
                            alert("[" + L + "]{#|5355|6ce8#}最低必須大於或等於上級{#|5355|6ce8#}最低(".keyComment() + j + ")");
                            F[I[0] + H].select();
                            return false
                        }
                        var z = parseInt(F[I[4] + H].value, 10);
                        if (z < x) {
                            alert("[" + L + "]{#|5355|6ce8#}最高必須小於或等於上級{#|5355|6ce8#}最高(".keyComment() + z + ")");
                            F[I[1] + H].select();
                            return false
                        }
                        var D = parseInt(F[I[7] + H].value, 10);
                        if (D < u) {
                            alert("[" + L + "]{#|5355|9879#}最高必須小於或等於上級{#|5355|9879#}最高(".keyComment() + D + ")");
                            F[I[2] + H].select();
                            return false
                        }
                    }
                    if (m && F[I[5] + H]) {
                        var A = parseInt(F[I[5] + H].value, 10);
                        if (A < y) {
                            alert("[" + L + "]{#|5355|6ce8#}最低必須小於或等於下級{#|5355|6ce8#}最低(".keyComment() + A + ")");
                            F[I[0] + H].select();
                            return false
                        }
                        var E = parseInt(F[I[6] + H].value, 10);
                        if (E > x) {
                            alert("[" + L + "]{#|5355|6ce8#}最高必須大於或等於下級{#|5355|6ce8#}最高(".keyComment() + E + ")");
                            F[I[1] + H].select();
                            return false
                        }
                        var B = parseInt(F[I[8] + H].value, 10);
                        if (B > u) {
                            alert("[" + L + "]{#|5355|9879#}最高必須大於或等於下級{#|5355|9879#}最高(".keyComment() + B + ")");
                            F[I[2] + H].select();
                            return false
                        }
                    }
                }
                if (m) {
                    if (!$.isChangeForm(this)) {
                        alert("請修改後再保存");
                        return false
                    }
                }
                $(":disabled").removeAttr("disabled");
                cover.show()
            } catch (J) {
                alert(J);
                return false
            }
        });
        var l = $(r).find(":radio");
        var t = [false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false];
        for (var n = 0; n < l.length; n++) {
            if (l[n].checked) {
                t[n] = true
            } else {
                t[n] = false
            }
        }
        $(l).click(function() {
            if (this.name != "checkall") {
                var u = parseInt(this.name.substr(this.name.length - 2), 10);
                if (this.checked === t[u]) {
                    this.checked = !this.checked
                }
                t[u] = this.checked;
                if (!t[u]) {
                    t[0] = l[0].checked = false
                } else {
                    var j = true;
                    for (var d = 1; d < l.length; d++) {
                        if (!l[d].checked) {
                            j = false
                        }
                    }
                    if (j) {
                        t[0] = l[0].checked = true
                    }
                }
            } else {
                if (this.checked === t[0]) {
                    this.checked = !this.checked
                }
                t[0] = this.checked;
                for (var d = 1; d < l.length; d++) {
                    l[d].checked = t[0];
                    t[d] = t[0]
                }
            }
        });
        if (f.betting) {
            var s = $("tbody:eq(1)", r).find(":text");
            s.each(function() {
                this.setAttribute("defaultValue", this.value)
            });
            s.change(function() {
                if (this.value != this.getAttribute("defaultValue")) {
                    f.betting.value = "1"
                } else {
                    if ("1" == f.betting.value) {
                        s.each(function() {
                            if (this.value != this.getAttribute("defaultValue")) {
                                return
                            }
                        });
                        f.betting.value = "0"
                    }
                }
            })
        }
        var p = r.getElementsByTagName("input");
        if (p[0].disabled) {
            p[2].focus()
        } else {
            p[0].focus()
        }
        p = null
    }
});
(function() {
    if (typeof Array.prototype.filter != "function") {
        Array.prototype.filter = function(f, d) {
            var a = [];
            if (typeof f === "function") {
                for (var c = 0, b = this.length; c < b; c++) {
                    f.call(d, this[c], c, this) && a.push(this[c])
                }
            }
            return a
        }
    }
    if (!Array.isArray) {
        Array.isArray = function(a) {
            return Object.prototype.toString.call(a) === "[object Array]"
        }
    }
})();
$.extend({
    registerOrder: function(h) {
        var k = function(p) {
            var m = "";
            var n = p + "category";
            var o = $("input[name='" + n + "']");
            var d = o.length;
            if (d > 0) {
                for (var l = 0; l < d; l++) {
                    if (o[l].checked) {
                        m += "," + o[l].value
                    }
                }
            }
            if (!m) {
                m = m.substring(1)
            }
            return m
        };
        var b = function(q) {
            var l = q + "all";
            var o = q + "category";
            var n = $("input[name='" + l + "']")[0];
            if (n.checked) {
                return 1
            }
            var p = $("input[name='" + o + "']");
            var d = p.length;
            if (d > 0) {
                for (var m = 0; m < d; m++) {
                    if (p[m].checked) {
                        return 2
                    }
                }
            }
            return 0
        };
        var c = $("input[name='export']")[0];
        if (c) {
            c.onclick = function() {
                if (!parent.$("#rptprg").hasClass("hid")) {
                    alert("報表計算中，請稍候導出數據!");
                    return false
                } else {
                    var o = $("select[name='drawDate']")[0];
                    if (!o || o.value === "") {
                        alert("請選擇{#|671f|6570#}!".keyComment());
                        return false
                    }
                    if (0 === parseInt(o.value)) {
                        alert("沒有歷史{#|671f|6570#}，無法導出數據!".keyComment());
                        return false
                    }
                    var n = new Date();
                    var d = n.getDate().toString();
                    d = d.length == 1 ? "0" + d : d;
                    var m = n.getFullYear().toString() + (n.getMonth() + 1) + d;
                    if (o.value == m) {
                        var l = parent.$("#close").attr("disabled");
                        if (parseInt(parent.header.lastStatus, 10) >= 2) {
                            g(o)
                        } else {
                            alert("當前期沒有{#|5173|76d8#}，不可以導出!".keyComment());
                            return false
                        }
                    } else {
                        g(o)
                    }
                }
            }
        }
        var g = function(t) {
            var q = "e";
            var o = 1;
            var m = b(q);
            if (0 === m) {
                alert("請選擇要導出的類別!");
                return false
            } else {
                if (m == 2) {
                    o = k(q)
                }
            }
            var d = t.value;
            var p = $("input[name='un_account']")[0];
            var r = (-1 !== p.value.indexOf(d) ? 1 : 0);
            var l = "toexcel.htm?drawDate=" + d + "&categoryId=" + o + "&iun_acc=" + r;
            var n = document.body.clientWidth / 2 - 50;
            var s = document.body.clientHeight / 2 + 30;
            window.open(l, "_self", "height=1,width=1,status=no,toolbar=no,menubar=no,location=no,left=" + n + ",top=" + s)
        };
        var a = function() {
            var n = this.name;
            var m = $("input[name='" + n.substring(0, 1) + "all']")[0];
            var o = $("input[name='" + n + "']");
            var d = o.length;
            m.checked = true;
            for (var l = 0; l < d; l++) {
                if (!o[l].checked) {
                    m.checked = false;
                    break
                }
            }
        };
        var f = function(o) {
            var m = o + "category";
            var n = $("input[name='" + m + "']");
            var d = n.length;
            if (d > 0) {
                for (var l = 0; l < d; l++) {
                    $(n[l]).click(a)
                }
            }
        };
        var j = $("input[name='eall']")[0];
        if (j) {
            j.onclick = function() {
                $("[name='ecategory']").attr("checked", j.checked)
            }
            ;
            $("[name='ecategory']").attr("checked", true);
            j.checked = true;
            f("e")
        }
    },
    order_check: function(f, h, c) {
        var d = [];
        var j = ("3" == c) ? [2, 2] : [3, 4];
        var k = ("3" == c) ? "取消" : "恢復";
        var g = false;
        var b = $("select[name='date']").val();
        var a;
        h.each(function() {
            a = $(this);
            if (a.attr("checked") && (j[0] == a.attr("statu") || j[1] == a.attr("statu"))) {
                d.push('{"status":"' + c + '","date":"' + a.attr("date") + '","number":"' + encodeURI(a.attr("number")) + '","game_id":"' + a.attr("game_id") + '","order_id":"' + a.attr("order_id") + '","refOrderId":"' + a.attr("refOrderId") + '","orderTime":"' + a.attr("orderTime") + '","toCorpId":"' + a.attr("toCorpId") + '","toHubId":"' + $(this).attr("toHubId") + '","shortCoverFlag":"' + $(this).attr("shortCoverFlag") + '","nnnn":"' + b + '"}');
                g = true
            }
        });
        if (!g) {
            alert("沒有需要" + k + "的{#|6ce8|5355#}".keyComment());
            f.removeAttr("disabled");
            return false
        } else {
            if (!confirm("確定要" + k + "已選擇{#|6ce8|5355#}嗎？".keyComment())) {
                f.removeAttr("disabled");
                return false
            }
        }
        d = "[" + d.join(",") + "]";
        $.ajax({
            type: "POST",
            url: "ajax_req.htm?act=batch_change_order",
            data: "orders=" + d,
            dataType: "json",
            success: function(n) {
                var o = "";
                var m = "";
                var l = "";
                $.each(n, function(q, p) {
                    if ("success" == p.flag) {
                        m += p.id + k + "成功\n"
                    } else {
                        o += p.id + k + "失敗 ! " + p.msg + "\n"
                    }
                });
                if (m.length) {
                    l += m
                }
                if (o.length) {
                    if (l.length) {
                        l += o
                    } else {
                        l = o
                    }
                }
                alert(l);
                f.removeAttr("disabled");
                location.reload();
                return false
            }
        })
    },
    xiazhumsg: function(j) {
        var b = window.parent.document.getElementsByName("framList");
        $(b).height(document.body.scrollHeight + 150);
        var c = $("#q_acc");
        var f = $("#q_order_id");
        var a = "";
        var k = "";
        c.blur(function() {
            k = $.trim(c.val());
            if ("" == k) {
                c.val("請輸入賬號");
                return false
            } else {
                if ("請輸入賬號" != k) {
                    q_acc_len = k.length;
                    if (!$.isUP(k) || q_acc_len > 12 || q_acc_len < 1) {
                        alert("請輸入合法的賬號");
                        c.val("請輸入賬號");
                        return false
                    }
                }
            }
        });
        c.focus(function() {
            if ("請輸入賬號" == $.trim(c.val())) {
                c.val("");
                return false
            }
        });
        f.blur(function() {
            a = f.val().replace(/\s/g, "");
            if ("" == a) {
                f.val("多個{#|6ce8|5355#}號之間以「|」分隔".keyComment());
                return false
            } else {
                if ("多個{#|6ce8|5355#}號之間以「|」分隔".keyComment() != a) {
                    var d = a.split("|");
                    for (var m = 0, l = d.length; m < l; m++) {
                        if ("" != d[m] && !$.isOrderId(d[m])) {
                            alert("請輸入合法的{#|6ce8|5355#}號".keyComment());
                            f.val("多個{#|6ce8|5355#}號之間以「|」分隔".keyComment());
                            return false
                        }
                    }
                }
            }
        });
        f.focus(function(d) {
            if ("多個{#|6ce8|5355#}號之間以「|」分隔".keyComment() == $.trim(f.val())) {
                f.val("");
                return false
            }
        });
        $("#q_order").click(function() {
            var r = $("select[name='categoryId']").val();
            var s = parseInt($("select[name='Type']").val());
            var l = $("select[name='start_hour']").val();
            var p = $("select[name='start_minutes']").val();
            var t = $("select[name='start_second']").val();
            var n = $("select[name='end_hour']").val();
            var m = $("select[name='end_minutes']").val();
            var u = $("select[name='end_second']").val();
            var d = l + p + t;
            var q = n + m + u;
            if (d >= q && "000000" != d) {
                alert("開始時間大於等於結束時間，請重新選擇");
                return false
            }
            if (s < 1 || s > 3) {
                alert("請選擇{#|6ce8|5355#}類型再進行查詢".keyComment());
                return false
            }
            var o = $("select[name='date']").val();
            a = f.val().replace(/\s/g, "");
            a = a == "多個{#|6ce8|5355#}號之間以「|」分隔".keyComment() ? "" : a;
            k = $.trim(c.val());
            k = k == "請輸入賬號" ? "" : k;
            window.location.href = "list.htm?TypeId=" + s + "&categoryId=" + r + "&date=" + o + "&start=" + d + "&end=" + q + "&order_id=" + a + "&account=" + k
        });
        $("#clear_text").click(function() {
            $("select[name!='categoryId'] option").each(function() {
                if ($(this).val() == "00") {
                    $(this).attr("selected", "selected")
                }
            });
            f.val("多個{#|6ce8|5355#}號之間以「|」分隔".keyComment());
            c.val("請輸入賬號")
        });
        var g = $("#checkAllOrder");
        var h = $("input[name='checkOrder']");
        g.click(function(d) {
            if (g.attr("checked")) {
                h.each(function() {
                    h.attr("checked", true)
                })
            } else {
                h.attr("checked", false)
            }
        });
        h.click(function() {
            if ($(this).attr("checked")) {
                var l = 1;
                var d = false;
                h.each(function() {
                    d = $(this).attr("checked");
                    if (!d) {
                        l = 0;
                        return false
                    }
                });
                if (l) {
                    g.attr("checked", true)
                }
            } else {
                g.attr("checked", false)
            }
        });
        $("#reset_order").click(function(l) {
            $(this).attr("disabled", "disabled");
            var d = "2";
            $.order_check($(this), h, d)
        });
        $("#cancel_order").click(function(l) {
            $(this).attr("disabled", "disabled");
            var d = "3";
            $.order_check($(this), h, d)
        })
    },
    odetail: function(u) {
        var h = function(c) {
            return document.getElementById(c)
        }, f, g = h("pager_page");
        var n = function(F, E, G, y, C) {
            if (!F) {
                return ""
            } else {
                F = F.split(",")
            }
            C = C ? C.split(",") : [];
            var d = F[6] || "te", B = F.slice(0, 6), c = E.indexOf(d) > -1, D = B.filter(function(H) {
                return E.indexOf($.trim(H)) > -1
            }), A, z = ["一", "二", "三", "四", "五", "六", "七"];
            switch (D.length) {
                case 6:
                    A = 1;
                    break;
                case 5:
                    A = c ? 2 : 3;
                    break;
                case 4:
                    A = c ? 4 : 5;
                    break;
                case 3:
                    A = c ? 6 : 7;
                    break;
                default:
                    A = 8
            }
            if (G == "g17") {
                A < 8 ? $(y).addClass("grey") : $(y).removeClass("grey");
                return A < 8 ? "<p>" + z[A - 1] + "等獎" + (C[A - 1] ? "：<span class='red'>" + C[A - 1] + "</span>" : "") + "</p>" : ""
            } else {
                if (G == "g12") {
                    A < 3 ? $(y).addClass("grey") : $(y).removeClass("grey");
                    return A < 3 ? "<p>" + z[A - 1] + "等獎" + (C[A - 1] ? "：<span class='red'>" + C[A - 1] + "</span>" : "") + "</p>" : ""
                }
            }
        }
            , s = function(c, d) {
            var y = [];
            (function z(D, B, E) {
                if (E == 0) {
                    return y.push(D)
                }
                for (var C = 0, A = B.length; C <= A - E; C++) {
                    z(D.concat(B[C]), B.slice(C + 1), E - 1)
                }
            })([], c, d);
            return y
        }
            , a = function(y, c, d, A) {
            var B = "";
            for (var z = 0; z < 30; z++) {
                if (y[z]) {
                    B = n(d, y[z] + "", c, h("em" + z).parentNode, A);
                    h("em" + z).innerHTML = y[z].join(",") + B;
                    B = ""
                } else {
                    h("em" + z).innerHTML = "&nbsp;"
                }
            }
        };
        if (!h("balls")) {
            return
        }
        var w = h("balls").value
            , j = h("gameid").value
            , l = {
            g17: "高1-7",
            g12: "高1-2"
        }[j]
            , k = parseFloat(h("num").value.replace(/,/g, ""))
            , m = parseInt(h("money").value.replace(/,/g, ""), 10)
            , b = h("result").value
            , q = h("prize").value;
        if (w.match(/\>/)) {
            var r = w.split(">")
                , x = r[0].split(",")
                , t = r[1].split(",");
            f = s(t, 6 - x.length);
            for (var v = 0, p = f.length; v < p; v++) {
                Array.prototype.unshift.apply(f[v], x)
            }
        } else {
            w = w.split(",");
            f = s(w, 6)
        }
        if (typeof w == "string") {
            var o = w.split(">");
            if (o.length == 2) {
                o[0] = "<span class='red'>膽 " + o[0] + "</span>";
                o[1] = "拖 " + o[1];
                o = o.join("-")
            }
        } else {
            var o = w
        }
        h("orders").innerHTML = '<span class="red">' + l + "</span>  " + o;
        h("nm").innerHTML = '<span class="red">(' + k + "×" + (m / f.length) + ")</span>";
        h("order_num").innerHTML = f.length;
        h("order_money").innerHTML = m;
        if (f.length > 30) {
            $("#pager").removeClass("hid").bind("click", function(z) {
                var y = z.target
                    , d = g.innerHTML.split("/")
                    , A = 0
                    , c = 30;
                if (y.tagName === "A") {
                    if (y.id == "pager_pre") {
                        if (d[0] == 1) {
                            return
                        }
                        d[0] = parseInt(d[0], 10) - 1
                    }
                    if (y.id == "pager_next") {
                        if (d[0] == d[1]) {
                            return
                        }
                        d[0] = parseInt(d[0], 10) + 1
                    }
                    A = d[0] * 30 - 30;
                    c = A + 30;
                    a(f.slice(A, c), j, b, q);
                    g.innerHTML = d[0] + "/" + d[1]
                }
            });
            g.innerHTML = "1/" + Math.ceil(f.length / 30)
        }
        a(f.slice(0, 30), j, b, q)
    }
});
var BuHuo = function(a) {
    this.dom = a;
    this.special_text_name = ["flag_00", "flag_02", "flag_08"];
    this.str = "." + this.special_text_name.join(".") + ".";
    this.radios = $("#buhuo_body input[type='radio']");
    this.fields = $("#buhuo_body input[type='text']");
    this.init()
};
BuHuo.prototype.init = function() {
    var c = this;
    var b = $("form").get(0);
    var a = b.status.value.split("|");
    if ("success" === a[0]) {
        if (a.length > 1) {
            alert("{#|8865|8d27#}設定值保存成功！".keyComment() + a[1] + "請使用手動{#|8865|8d27#}！".keyComment())
        } else {
            alert("保存成功!")
        }
    }
    $("#buhuo_body").bind("click keypress", function(f) {
        if (f.type === "click") {
            var d = f.target;
            if ("check_all" == d.name) {
                c.check_all(d)
            } else {
                if ("radio" == d.type) {
                    c.check_radio(d)
                }
            }
        } else {
            if (f.type === "keypress" && f.keyCode === 13) {
                $("#sysconfig_buhuo").click()
            }
        }
    });
    $("#sysconfig_buhuo").click(function(j) {
        var h = [], g, d, f = false;
        for (g = 0; g < c.fields.length; g++) {
            d = c.fields.get(g);
            if (d.value != d.defaultValue) {
                if (!$.validateEm(d)) {
                    return false
                }
                h.push('"' + d.name + '":"' + d.value + '"')
            }
        }
        for (g = 0; g < c.radios.length; g++) {
            d = c.radios.get(g);
            if (d.checked && !d.defaultChecked) {
                h.push('"' + d.name + '":"' + d.value + '"');
                if (d.value == "1") {
                    f = true
                }
            }
        }
        if (h.length > 0) {
            var tl=[];
            for (g = 0; g < c.fields.length; g++) {
                d = c.fields.get(g);
                if (!$.validateEm(d)) {
                    return false
                }
                tl.push('"' + d.name + '":"' + d.value + '"')
            }
            for (g = 0; g < c.radios.length; g++) {
                d = c.radios.get(g);
                if (d.checked) {
                    tl.push('"' + d.name + '":"' + d.value + '"');
                }
            }
            $("#sysconfig_buhuo").attr("disabled", "disabled");
            tl.value = "{" + tl.join(",") + "}";
            $.ajax({
                type: "POST",
                url: "/sysconfig/save",
                data: "chg=" + tl.value,
                dataType: "text",
                async: false,
                success: function(l) {
                    if (l == 1 || l == 2) {
                        $("#buhuo_status").attr("value", "success");
                        if (f && l == 1) {
                            alert("保存成功！自動{#|8865|8d27#}在後台處理，請到{#|6536|4ed8|7edf|8ba1#}中查看！".keyComment())
                        } else {
                            alert("保存成功！")
                        }
                        document.location = document.location
                    }
                    var k = {
                        "1001": "金額由0或者不大於9位的正整數組成！",
                        "1002": "{#|8865|8d27#}類型格式不對！".keyComment()
                    };
                    k[l] ? alert(k[l]) : (l != 1 || l != 2 ? "保存不成功，稍後再試！" : "")
                }
            });
            $("#sysconfig_buhuo").attr("disabled", "")
        } else {
            alert("請做修改後再保存");
            return false
        }
    });
    b.onsubmit = function() {
        var g = [], f, d;
        for (f = 0; f < c.fields.length; f++) {
            d = c.fields.get(f);
            if (d.value != d.defaultValue) {
                if (!$.validateEm(d)) {
                    return false
                }
                g.push('"' + d.name + '":"' + d.value + '"')
            }
        }
        for (f = 0; f < c.radios.length; f++) {
            d = c.radios.get(f);
            if (d.checked && !d.defaultChecked) {
                g.push('"' + d.name + '":"' + d.value + '"')
            }
        }
        if (g.length > 0) {
            this.chg.value = "{" + g.join(",") + "}"
        } else {
            alert("請做修改後再保存");
            return false
        }
    }
}
;
BuHuo.prototype.check_all = function(c) {
    for (var b = 0; b < this.radios.length; b++) {
        var a = this.radios.get(b);
        if (c.checked) {
            if ("0" == a.value) {
                a.checked = true;
                if (this.str.indexOf("." + a.name + ".") != -1) {
                    $("#" + a.name).html("<span class='blue'>{#|4ed3|4f4d#}</span>".keyComment())
                }
            }
        } else {
            if ("1" == a.value) {
                a.checked = true;
                if (this.str.indexOf("." + a.name + ".") != -1) {
                    $("#" + a.name).html("{#|5360|6210#}".keyComment())
                }
            }
        }
    }
}
;
BuHuo.prototype.check_radio = function(a) {
    if (this.str.indexOf("." + a.name + ".") != -1) {
        var b = (a.value == "0" && a.checked) ? "<span class='blue'>{#|4ed3|4f4d#}</span>" : "{#|5360|6210#}".keyComment();
        $("#" + a.name).html(b)
    }
}
;
var GongsiBuHuo = function(a) {
    this.init();
    $("form[name=form_m] :text", a).keyup(function(c) {
        var b = c.target;
        b.value = b.value.replace(/[^0-9]/g, "");
        if ("0" == b.value) {
            b.value = ""
        }
    });
    $.checkAll($("#corp_body"));
    $.checkAll($("#cfgg"))
};
GongsiBuHuo.prototype.init = function() {
    var a = this;
    $("#gongsibuhuo form").submit(function(h) {
        var l = h.target, k = [], c = $("tbody :checkbox", l), f, m, g, d = false, j = 0, b = true;
        if (c.length > 0) {
            c.each(function() {
                if (this.checked != this.defaultChecked) {
                    d = true
                }
                if (this.checked) {
                    j++
                }
                k.push('"' + this.name.substr(9) + '":"' + (this.checked ? 1 : 0) + '"')
            })
        } else {
            if ("form_m" == l.name) {
                $("tbody :text", l).each(function() {
                    if (!$.validateEm(this)) {
                        b = false;
                        d = true;
                        return false
                    }
                    if (this.value != this.defaultValue) {
                        f = $(this).nextAll(":hidden");
                        m = f[0].value;
                        g = f[1].value;
                        k.push('"' + m + ":" + g + '":"' + this.value + '"');
                        d = true
                    }
                })
            } else {
                d = true
            }
        }
        if (!b) {
            return false
        }
        if (!d) {
            alert("請做修改後再保存");
            return false
        }
        if (k.length > 0) {
            l.chg.value = "{" + k.join(",") + "}"
        }
        $(":submit:first", l).attr("disabled", true)[0].blur()
    });
    $("#gongsibuhuo input[name=status]").each(function() {
        if ("success" == this.value) {
            alert("保存成功！")
        }
        return false
    });
    $("input[type=button]").click(function() {
        cover.hide();
        $("#gsbhm").hide();
        $("#gsbho").hide();
        $("input[name=__login_id]", a.dom).val("");
        $("input[name=password]", a.dom).val("");
        $("input[name=password2]", a.dom).val("");
        $("input[name=order_flag]", a.dom).val("")
    });
    cover.hide();
    $("#gsbhm").hide();
    $("#corp_body").click(function(d) {
        var b = d.target;
        if (b.getAttribute("cid")) {
            var g = $("#gsbho");
            var f = b.getAttribute("cid");
            $("span:first", g)[0].innerHTML = b.innerHTML;
            $("input[name=to_corp_id]", g).val(f);
            if (adjust_odds[f]) {
                $(":text", g).each(function(c) {
                    this.value = adjust_odds[f][this.name]
                })
            } else {
                $(":text", g).each(function(c) {
                    this.value = 0
                })
            }
            cover.show();
            g.show()
        }
    });
    $("#gsbho").hide();
    $("#gongsibuhuo").click(function(f) {
        var d = $("#gongsibuhuo select")[0];
        if (!d) {
            return
        }
        var h = d.options[d.selectedIndex].value;
        var g = d.options[d.selectedIndex].text;
        var c = f.target;
        var b = c.getAttribute("act");
        if ("del" == b) {
            return confirm("確定要刪除嗎？")
        } else {
            if ("add" == b) {
                if (h != "-1") {
                    $("span", a.dom)[0].innerHTML = g;
                    $("input[name=to_corp_id2]", a.dom).val(h);
                    cover.show();
                    $("#gsbhm").show()
                } else {
                    alert("請選擇{#|8865|8d27#}公司".keyComment())
                }
                return false
            }
        }
    })
}
;
$.extend({
    sysConfig: function(a) {
        a.onsubmit = function() {
            var c = [];
            var b = false;
            $("input[type='text']").each(function(x) {
                if (this.value != this.defaultValue) {
                    b = true;
                    if (!$.validateEm(this)) {
                        c = [];
                        return false
                    }
                    c.push('"' + this.name + '":"' + this.value + '"');
                    if (document.getElementById("sysshuiwei")) {
                        if ((/^odds_A_/).test(this.name)) {
                            var z = this.name.replace("_A_", "_B_");
                            var B = this.name.replace("_A_", "_C_");
                            var G = a[z].value;
                            var E = a[B].value;
                            var h = this.name.split("_");
                            if ("99" == h[4] || "98" == h[4] || "97" == h[4]) {
                                var J = "max" + this.name.replace(h[4], "1")
                            } else {
                                var J = "max" + this.name
                            }
                            var t = a[J].value;
                            if (((parseFloat(a[this.name].value) * 1000 + parseFloat(G) * 1000) / 1000).toFixed(3) < 1) {
                                alert("此{#|8d54|7387#}與差分會使B盤{#|8d54|7387#}小於1,請修改".keyComment());
                                this.select();
                                c = [];
                                return false
                            }
                            if (((parseFloat(a[this.name].value) * 1000 + parseFloat(E) * 1000) / 1000).toFixed(3) < 1) {
                                alert("此{#|8d54|7387#}與差分會使C盤{#|8d54|7387#}小於1,請修改".keyComment());
                                this.select();
                                c = [];
                                return false
                            }
                            if (parseFloat(a[this.name].value) > parseFloat(t)) {
                                alert("A盤{#|8d54|7387#}大於最高{#|8d54|7387#},請修改".keyComment());
                                this.select();
                                c = [];
                                return false
                            }
                            if (((parseFloat(a[this.name].value) * 1000 + parseFloat(G) * 1000) / 1000).toFixed(3) > parseFloat(t)) {
                                alert("聯調後B盤{#|8d54|7387#}超過最高{#|8d54|7387#},請修改".keyComment());
                                this.select();
                                c = [];
                                return false
                            }
                            if (((parseFloat(a[this.name].value) * 1000 + parseFloat(E) * 1000) / 1000).toFixed(3) > parseFloat(t)) {
                                alert("聯調後C盤{#|8d54|7387#}超過最高{#|8d54|7387#},請修改".keyComment());
                                this.select();
                                c = [];
                                return false
                            }
                            c.push('"' + z + '":"' + G + '"');
                            c.push('"' + B + '":"' + E + '"')
                        } else {
                            if ((/^odds_B_/).test(this.name)) {
                                var w = this.name.replace("_B_", "_A_");
                                var H = a[w].value;
                                var h = w.split("_");
                                if ("99" == h[4] || "98" == h[4] || "97" == h[4]) {
                                    var J = "max" + w.replace(h[4], "1")
                                } else {
                                    var J = "max" + w
                                }
                                var t = a[J].value;
                                if (((parseFloat(a[this.name].value) * 1000 + parseFloat(H) * 1000) / 1000).toFixed(3) < 1) {
                                    alert("此差分會使B盤{#|8d54|7387#}小於1,請修改.".keyComment());
                                    this.select();
                                    c = [];
                                    return false
                                }
                                if (((parseFloat(a[this.name].value) * 1000 + parseFloat(H) * 1000) / 1000).toFixed(3) > parseFloat(t)) {
                                    alert("此差分會使B盤{#|8d54|7387#}大於最高{#|8d54|7387#},請修改.".keyComment());
                                    this.select();
                                    c = [];
                                    return false
                                }
                            } else {
                                if ((/^odds_C_/).test(this.name)) {
                                    var w = this.name.replace("_C_", "_A_");
                                    var H = a[w].value;
                                    var h = w.split("_");
                                    if ("99" == h[4] || "98" == h[4] || "97" == h[4]) {
                                        var J = "max" + w.replace(h[4], "1")
                                    } else {
                                        var J = "max" + w
                                    }
                                    var t = a[J].value;
                                    if (((parseFloat(a[this.name].value) * 1000 + parseFloat(H) * 1000) / 1000).toFixed(3) < 1) {
                                        alert("此差分會使C盤{#|8d54|7387#}小於1,請修改.".keyComment());
                                        this.select();
                                        c = [];
                                        return false
                                    }
                                    if (((parseFloat(a[this.name].value) * 1000 + parseFloat(H) * 1000) / 1000).toFixed(3) > parseFloat(t)) {
                                        alert("此差分會使C盤{#|8d54|7387#}大於最高{#|8d54|7387#},請修改.".keyComment());
                                        this.select();
                                        c = [];
                                        return false
                                    }
                                } else {
                                    if ((/^maxodds_A_/).test(this.name)) {
                                        var w = this.name.replace("max", "");
                                        var H = a[w].value;
                                        var z = w.replace("_A_", "_B_");
                                        var B = w.replace("_A_", "_C_");
                                        var G = a[z].value;
                                        var E = a[B].value;
                                        G = ((parseFloat(H) * 1000 + parseFloat(G) * 1000) / 1000).toFixed(3);
                                        E = ((parseFloat(H) * 1000 + parseFloat(E) * 1000) / 1000).toFixed(3);
                                        var t = a[this.name].value;
                                        var h = w.split("_");
                                        var y = true;
                                        if ("047" == h[3] || "048" == h[3] || "049" == h[3] || "050" == h[3] || "051" == h[3] || "052" == h[3]) {
                                            var F = "97"
                                        } else {
                                            if ("015" == h[3] || "042" == h[3] || "044" == h[3] || "046" == h[3]) {
                                                var F = "98"
                                            } else {
                                                if ("034" == h[3] || "014" == h[3] || "035" == h[3] || "037" == h[3] || "039" == h[3]) {
                                                    var F = "99"
                                                } else {
                                                    y = false
                                                }
                                            }
                                        }
                                        if (y) {
                                            var k = w.substr(0, w.lastIndexOf(h[4])) + F;
                                            var I = z.substr(0, z.lastIndexOf(h[4])) + F;
                                            var o = B.substr(0, z.lastIndexOf(h[4])) + F;
                                            var f = a[k].value;
                                            var n = a[I].value;
                                            var A = a[o].value;
                                            n = ((parseFloat(f) * 1000 + parseFloat(n) * 1000) / 1000).toFixed(3);
                                            A = ((parseFloat(f) * 1000 + parseFloat(A) * 1000) / 1000).toFixed(3)
                                        }
                                        if ((parseFloat(t)) < parseFloat(G) || (y && (parseFloat(t)) < parseFloat(n))) {
                                            alert("最高{#|8d54|7387#}小於B盤{#|8d54|7387#},請修改.".keyComment());
                                            this.select();
                                            c = [];
                                            return false
                                        }
                                        if ((parseFloat(t)) < parseFloat(E) || (y && (parseFloat(t)) < parseFloat(A))) {
                                            alert("最高{#|8d54|7387#}小於C盤{#|8d54|7387#},請修改.".keyComment());
                                            this.select();
                                            c = [];
                                            return false
                                        }
                                        if ((parseFloat(t)) < parseFloat(H) || (y && (parseFloat(t)) < parseFloat(f))) {
                                            alert("最高{#|8d54|7387#}小於A盤{#|8d54|7387#},請修改.".keyComment());
                                            this.select();
                                            c = [];
                                            return false
                                        }
                                    } else {
                                        if (/^(?:odds|maxodds)_[ABC][AB]_(\d\d_\d{3}_\d{1,2})$/.test(this.name)) {
                                            var g = this.name, p = /^(odds|maxodds)_([ABC][AB])_(\d\d_\d{3}_\d{1,2})$/, u = parseFloat(a[g.replace(p, "odds_AA_$3")].value) * 1000, v = parseFloat(a[g.replace(p, "odds_AB_$3")].value) * 1000, m = parseFloat(a[g.replace(p, "odds_BA_$3")].value) * 1000, d = parseFloat(a[g.replace(p, "odds_CA_$3")].value) * 1000, K = parseFloat(a[g.replace(p, "maxodds_AA_$3")].value) * 1000, j = [0, m, d], l = g.match(p), C;
                                            var s = function(O, Q) {
                                                var M = ["A", "A"], P = ["A", "B", "C"], L = 0, N, r;
                                                for (; L < 6; L++) {
                                                    if (L > 2) {
                                                        M[0] = P[L - 3];
                                                        M[1] = "B";
                                                        N = u + v + j[L - 3]
                                                    } else {
                                                        M[0] = P[L];
                                                        N = u + j[L]
                                                    }
                                                    r = O(N, K);
                                                    if (r) {
                                                        break
                                                    }
                                                }
                                                if (r) {
                                                    Q(M, r)
                                                }
                                                return r
                                            };
                                            if (l[1] === "odds") {
                                                C = s(function(r, L) {
                                                    if (r > L) {
                                                        return "big"
                                                    }
                                                    if (r < 1) {
                                                        return "small"
                                                    }
                                                }, function(r, L) {
                                                    if (L === "big") {
                                                        alert("使" + r[0] + "盤特" + r[1] + "{#|8d54|7387#}大於最高{#|8d54|7387#},請修改.".keyComment())
                                                    }
                                                    if (L === "small") {
                                                        alert("使" + r[0] + "盤特" + r[1] + "{#|8d54|7387#}小於1,請修改.".keyComment())
                                                    }
                                                })
                                            } else {
                                                if (l[1] === "maxodds") {
                                                    C = s(function(r, L) {
                                                        if (r > L) {
                                                            return true
                                                        }
                                                    }, function(r, L) {
                                                        alert("最高{#|8d54|7387#}小於".keyComment() + r[0] + "盤特" + r[1] + "{#|8d54|7387#},請修改.".keyComment())
                                                    })
                                                }
                                            }
                                            if (C) {
                                                this.select();
                                                c = [];
                                                return false
                                            } else {
                                                if (/^odds_AA_/.test(g)) {
                                                    c.push('"' + g.replace(p, "odds_AB_$3") + '":"' + (v / 1000) + '"');
                                                    c.push('"' + g.replace(p, "odds_BA_$3") + '":"' + (m / 1000) + '"');
                                                    c.push('"' + g.replace(p, "odds_CA_$3") + '":"' + (d / 1000) + '"')
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (document.getElementById("systouzhu")) {
                        var D = this.name.split("_");
                        var q = D[1];
                        if (parseInt(a["omin_" + q].value, 10) > parseInt(a["omax_" + q].value, 10)) {
                            alert("{#|5355|6ce8#}最低要小於{#|5355|6ce8#}最高".keyComment());
                            this.select();
                            c = [];
                            return false
                        } else {
                            if (parseInt(a["omax_" + q].value, 10) > parseInt(a["imax_" + q].value, 10)) {
                                alert("{#|5355|6ce8#}最高要小於或等於{#|5355|9879#}最高".keyComment());
                                this.select();
                                c = [];
                                return false
                            }
                        }
                    }
                }
            });
            if (c.length > 0) {
                a.chg.value = "{" + c.join(",") + "}";
                return true
            } else {
                if (!b) {
                    alert("請做修改後再保存")
                }
            }
            return false
        }
        ;
        if ("success" === a.status.value) {
            alert("保存成功！")
        }
    },
    otherConfig2: function(a) {
        a.onsubmit = function() {
            var b = [];
            $("select").each(function() {
                var c = $(this).attr("def");
                if (this.value != c) {
                    b.push('"' + this.name + '":"' + this.value + '"')
                }
            });
            if (b.length === 0) {
                alert("請做修改後再保存");
                return false
            }
            a.chg.value = "{" + b.join(",") + "}"
        }
        ;
        if ("success" === a.status.value) {
            alert("保存成功！")
        }
    },
    otherConfig: function(b) {
        var c = function(d) {
            return ("00" + d).substr(d.length)
        };
        var a = function() {
            b.cfg_1.value = c(b.cfg_1.value);
            b.cfg_2.value = c(b.cfg_2.value);
            b.cfg_3.value = c(b.cfg_3.value);
            b.cfg_4.value = c(b.cfg_4.value)
        };
        $("select").each(function() {
            var d = $(this).attr("def");
            this.value = d;
            if (this.className == "colorselector") {
                $(this).css("background-color", d);
                $(this).find("option").attr("style", function() {
                    if (this.value == d) {
                        this.selected = true
                    }
                    return "background-color:" + this.value
                });
                $(this).change(function() {
                    $(this).css("background-color", this.value)
                })
            }
        });
        b.onsubmit = function() {
            var f = [];
            var d = 1;
            $("select").each(function() {
                var h = $(this).attr("def");
                if (this.value != h) {
                    f.push('"' + this.name + '":"' + this.value + '"')
                }
            });
            a();
            $(":text, :radio").each(function() {
                if ("radio" === this.type) {
                    if (this.checked && !this.defaultChecked) {
                        f.push('"' + this.name + '":"' + this.value + '"')
                    }
                } else {
                    if (this.value != this.defaultValue) {
                        if (!$.validateEm(this)) {
                            d = 0;
                            f = [];
                            return false
                        }
                        if (("cfg_1" == this.name || "cfg_2" == this.name || "cfg_3" == this.name || "cfg_4" == this.name) && 0 === this.value - this.defaultValue) {} else {
                            f.push('"' + this.name + '":"' + this.value + '"')
                        }
                    }
                }
            });
            if (d === 0) {
                return false
            }
            if (f.length === 0) {
                alert("請做修改後再保存");
                return false
            }
            if (b.cfg_1.value + b.cfg_2.value >= b.cfg_3.value + b.cfg_4.value) {
                alert("默認{#|5173|76d8#}時間要晚於默認{#|5f00|76d8#}時間".keyComment());
                f = [];
                d = 0;
                return false
            }
            if (parseInt(b.cfg_11.value, 10) > parseInt(b.cfg_12.value, 10) || parseInt(b.cfg_12.value, 10) > parseInt(b.cfg_13.value, 10)) {
                alert("設置數據的顏色顯示的三檔設定值必須是依次遞增");
                return false
            }
            b.chg.value = "{" + f.join(",") + "}";
            var g = parseInt(document.getElementById("cfg_9").value, 10) * 1000;
            parent.$.trigger("setpdtime", [g])
        }
        ;
        if ("success" === b.status.value) {
            alert("保存成功！")
        }
    },
    marqueeConfig: function(a) {
        $(".add,.view,.edit,.del").bind("click", function() {
            var b = $(this).attr("class");
            var f = {
                add: "新增公告信息",
                view: "查看公告信息",
                edit: "修改公告信息",
                del: "刪除公告信息"
            };
            var g = "";
            g = $(this).parent().parent().attr("id");
            g = g ? "&id=" + g : "";
            var c = "../sysconfig/notice.htm?act=" + b + g;
            var d = 322;
            if (b == "del") {
                d = 60
            }
            if (b == "view") {
                JqueryDialog.Open1('<h2 class="g-tit">' + f[b] + "</h2>", c, 706, d, false, true);
                return
            }
            JqueryDialog.Open('<h2 class="g-tit">' + f[b] + "</h2>", c, 706, d, true)
        });
        $("input[type='checkbox']").bind("click", function() {
            var b = "../sysconfig/notice.htm";
            var c = $(this).parent().parent().attr("id");
            $.get(b, {
                act: "popup",
                id: c,
                popup: this.checked
            }, function(f) {
                if (f == 1) {
                    alert("保存成功！")
                } else {
                    alert("保存不成功，稍後再試!")
                }
            })
        })
    },
    marqueeConfig_ok: function(c) {
        var d = $("#newannouncement", c);
        var b = $(c).attr("actType");
        if (b == "view" || b == "noticehistory") {
            window.parent.JqueryDialog.Close(false);
            return
        }
        if (b == "del") {
            c.submit();
            return
        }
        var a = d.val().length;
        if (a === 0) {
            alert("跑馬燈設置不能為空");
            window.parent.JqueryDialog.ResetButton();
            return
        }
        if ((1000 - a) < 0) {
            alert("跑馬燈設置不超過1000個字符");
            window.parent.JqueryDialog.ResetButton();
            return
        }
        c.submit()
    },
    gameRule: function() {
        var a = {
            sixplay: "hkms",
            hkms: "sixplay"
        }
            , b = {
            sixplay: "{#|516d|5408|5f69#}遊戲規則".keyComment(),
            hkms: "{#|9ad8|989d|5f69#}遊戲規則".keyComment()
        };
        $("#tabs").click(function(f) {
            var d = f.target, c;
            if (d.tagName === "A") {
                c = a[d.id];
                $(d).addClass("tab_on");
                $("#ol_" + d.id).removeClass("hid");
                $("#" + c).removeClass("tab_on");
                $("#ol_" + c).addClass("hid");
                document.getElementById("rule_name").innerHTML = b[d.id]
            }
        })
    }
});
var Monitor = function(b) {
    if (self === top) {
        $("body").empty();
        alert("新窗口不可用，請關閉該窗口。");
        return
    }
    var a = this;
    this.data = {};
    this.odds_refersh = {};
    this.no_name = {};
    this.pro_odds = {};
    this.key_odds = {};
    this.key_detail = {};
    this.play_total = {};
    this.plays = {};
    this.is_total_win_loss = 0;
    this.dom = b;
    this.alarm = "";
    this.time_stamp = 0;
    this.odds_set = "S_SA";
    this.step_type_all = 3;
    this.c_step_type = 3;
    this.menu_id = $("#total_plays .on").get(0).id;
    this.gms_fcorp = window.gms_fcorp ? 1 : 0;
    if (this.gms_fcorp == 1) {
        $("td[title]", "#rate_detail").removeAttr("title")
    }
    this.game_id = "000";
    if (this.menu_id == "1013" || this.menu_id == "1010") {
        this.game_id = $("#game_id").val();
        current_game_id = this.game_id;
        $("#buzhongmenu a,#lianmamenu a").each(function(c) {
            if ($(this).attr("gid") == current_game_id) {
                $(this).addClass("on")
            } else {
                $(this).removeClass("on")
            }
        })
    }
    $("#totalwinlos").bind("click", function(c) {
        $("#totalwinlos[id=" + c.target.id + "]").attr("disabled", "disabled");
        a.is_total_win_loss = c.target.checked ? 1 : 0;
        $("#totalwinlos_td").html(a.is_total_win_loss ? "總項贏虧" : "{#|80dc|51fa|91d1|989d#}".keyComment());
        a.time_stamp = 0;
        a._refersh();
        $("#orders_page_1").show();
        $("#orders_page_2").hide()
    });
    if (1001 != this.menu_id) {
        this.odds_set = "S"
    }
    this.chg_odds_set = 1;
    this.status = "1";
    this.lastStatus = "1";
    this.stops = [];
    this.ajaxload = 0;
    this.order_hander = null;
    parent.$.bind("init." + b.id, function(d, c) {
        parent.$.unbind("init." + b.id);
        a.status = c.status;
        a.onOffStatus();
        a.buhuo = $("input:text[name=buhuo]");
        a.init();
        a.regist_clicks();
        a.set_alarm();
        a.colorLimit = {
            val: [50000, 100000, 300000],
            color: ["#EC6941", "#E60012", "#A40000"],
            flag: 0
        };
        setInterval(function() {
            a.set_alarm.call(a)
        }, 1000)
    });
    parent.$.trigger("getinit");
    $(window).unload(function() {
        parent.$.unbind("." + b.id)
    })
};
Monitor.prototype.init = function() {
    this.reset_alarm_time();
    if (document.getElementById("orders_pager")) {
        $("#orders_pager").bind("click", function(b) {
            var a = b.target.getAttribute("act");
            if (a == "up") {
                $("#orders_page_1").show();
                $("#orders_page_2").hide()
            } else {
                if (a == "down") {
                    $("#orders_page_1").hide();
                    $("#orders_page_2").show()
                }
            }
            return false
        })
    }
    if (document.getElementById("orders")) {
        this.order_hander = document.getElementById("order_hander");
        this.leftDom = $(this.order_hander.parentNode.parentNode)
    }
    $.ajaxAction(this, this.set_datas, "ajax_req.htm?act=get_monitor_data&menu_id=" + this.menu_id + "&odds_set=" + this.odds_set + "&time_stamp=" + this.time_stamp + "&cat_ids=" + this.init_stop_game() + "&is_total_win_loss=" + this.is_total_win_loss);
    this.init_plays()
}
;
Monitor.prototype.onOffStatus = function() {
    var a = this;
    if (a.lastStatus !== a.status) {
        if ("1" == a.status) {
            $("body:first").removeClass("off")
        } else {
            $("body:first").addClass("off")
        }
        a.lastStatus = a.status
    }
}
;
Monitor.prototype.set_datas = function(h) {
    var j = this;
    this.data = h;
    if (h.oddsStep && j.gms_fcorp === 0 && h.oddsStep) {
        $("#adjustment_steps").val(h.oddsStep);
        $("#adjustment_steps").show()
    }
    if (h.hide && this.order_hander) {
        this.leftDom.addClass("g-hr")
    }
    if (h.colorLimit) {
        this.colorLimit = h.colorLimit
    }
    this.time_stamp = this.data.time.join(",");
    var l = document.getElementById("total_plays").cells;
    for (var g = 0; g < l.length; g++) {
        this.set_total(l[g], this.data.menus[l[g].id]);
        this.play_total[l[g].id] = l[g]
    }
    var d = $("table .bg");
    var k;
    var c = function(t) {
        var s = this;
        k = setTimeout(function() {
            k = null;
            var u = $(s);
            var v = u.offset();
            $.trigger("bover", [j.odds_set, u.attr("product"), v.left + u.width(), v.top])
        }, 999)
    };
    var n = function(s) {
        if (k) {
            clearTimeout(k);
            k = null
        } else {
            $.trigger("bout", $(s.target).attr("product"))
        }
    };
    for (g = 0; g < d.length; g++) {
        var r = d[g].previousSibling
            , p = "title='{#|8865|8d27#}'".keyComment();
        if (j.gms_fcorp === 0) {
            $(r).hover(c, n)
        } else {
            p = ""
        }
        var o = r.getAttribute("product");
        var q = r.getAttribute("no");
        var b = r.getAttribute("bo");
        if (this.game_id == "009" || this.game_id == "012") {
            var f = this.game_id + "1" + b;
            var m = "<a action='add' class='ico up' href='?'>+</a><a class='pl' href='?' id='" + f + "' title='{#|8d54|7387#}'>".keyComment() + this.data.odds[f] + "</a><a action='lower' class='ico dn' href='?'>-</a>　";
            f = this.game_id + "2" + b;
            m += "<a action='add' class='ico up' href='?'>+</a><a class='pl' href='?' id='" + f + "' title='{#|8d54|7387#}'>".keyComment() + this.data.odds[f] + "</a><a action='lower' class='ico dn' href='?'>-</a>"
        } else {
            var m = "<a action='add' class='ico up' href='?'>+</a><a class='pl' href='?' id='" + o + "' title='{#|8d54|7387#}'>".keyComment() + this.data.odds[o] + "</a><a action='lower' class='ico dn' href='?'>-</a>"
        }
        m += "<br/><div class='mx'><a action='detail' href='?' key='" + o + "' title='查看{#|6ce8|5355#}明細' class='popup'".keyComment() + (0 === this.getFlag(this.colorLimit.flag, o) ? ' style="color:' + this.getColor(this.data.amts[o][0], 0) + '"' : "") + ">" + this.data.amts[o][0] + "</a></div>";
        if (this.data.amts[o].length == 2) {
            m += "<span class='sp'>/</span><div class='bh'><a action='supplement' href='?' key='" + o + "' " + p + " class='popup'" + (1 === this.getFlag(this.colorLimit.flag, o) ? ' style="color:' + this.getColor(this.data.amts[o][1], 1) + '"' : "") + ">" + this.data.amts[o][1] + "</a></div>"
        }
        d[g].innerHTML = m;
        var a = d[g].childNodes;
        if (this.game_id == "009" || this.game_id == "012") {
            this.pro_odds[q] = [a[1], a[5]];
            this.key_odds[a[1].id] = a[1];
            this.key_odds[a[5].id] = a[5]
        } else {
            this.pro_odds[q] = a[1];
            this.key_odds[o] = a[1]
        }
        this.no_name[q] = r;
        if (this.game_id == "009" || this.game_id == "012") {
            this.key_detail[o] = [a[8].firstChild]
        } else {
            this.key_detail[o] = this.data.amts[o].length == 1 ? [a[4].firstChild] : [a[4].firstChild, a[6].firstChild]
        }
        this.buhuo.val(h.limit)
    }
    this.ajax_init_stop_game(this.data.stop);
    this.set_new_bet();
    if ($.isArray(h.stops)) {
        this.stops = h.stops;
        this.setStops()
    }
}
;
Monitor.prototype.setStops = function() {
    var a = this;
    if ("1" == a.status) {
        $("#jiandutop td").each(function(b) {
            if (0 === a.stops[b]) {
                $(this).addClass("sp")
            } else {
                $(this).removeClass("sp")
            }
            if ($(this).is(".on")) {
                on = b
            }
        })
    }
}
;
Monitor.prototype.set_total = function(j, h, g) {
    if (!h) {
        return
    }
    var b = [];
    for (var f = 0; f < h.length; f++) {
        var d = j.firstChild;
        var c = d.childNodes[f + 1].innerHTML;
        j.firstChild.childNodes[f + 1].innerHTML = h[f];
        if (0 !== this.chg_odds_set && g && c != h[f]) {
            b.push(j.firstChild.childNodes[f + 1])
        }
    }
    $.lightOn(b)
}
;
Monitor.prototype._refersh = function() {
    var a = this;
    if (a.ajaxload) {
        return
    }
    a.ajaxload = 1;
    $.ajax({
        url: "ajax_req.htm?act=get_monitor_data&menu_id=" + this.menu_id + "&odds_set=" + this.odds_set + "&time_stamp=" + this.time_stamp + "&cat_ids=" + this.init_stop_game() + "&is_total_win_loss=" + this.is_total_win_loss,
        dataType: "json",
        timeout: $.ajaxtimout,
        complete: function() {
            a.ajaxload = 0
        },
        success: function(b) {
            a.refersh.call(a, b);
            if (a.chg_odds_set !== 1) {
                a.chg_odds_set = 1
            }
        }
    })
}
;
Monitor.prototype.refersh = function(a) {
    this.reset_alarm_time();
    if (!a) {
        return
    }
    this.data = a;
    this.time_stamp = a.time ? a.time.join(",") : this.time_stamp;
    this.refersh_rate();
    this.refersh_detail();
    this.refersh_total();
    this.set_new_bet();
    this.buhuo.val(a.limit);
    this.ajax_init_stop_game(this.data.stop);
    if (a.bChangeOrder !== undefined) {
        parent.$.trigger("isbChangeOrder", [a.bChangeOrder])
    }
    if ($.isArray(a.stops)) {
        if (a.stops.toString() == this.stops.toString()) {
            return
        }
        this.stops = a.stops;
        this.setStops()
    }
}
;
Monitor.prototype.changeSteps = function() {
    if (document.getElementById("wubuzhong")) {
        return
    }
    var c = document.getElementById("adjustment_type");
    var b = 2;
    if (c.value == "all" || c.value == "0") {
        if (this.step_type_all === null) {
            for (var a = 1; a < c.options.length; a++) {
                if (!$.is_odds_declen3(c.options[a].value)) {
                    this.step_type_all = 2;
                    break
                }
                this.step_type_all = 3
            }
        }
        b = this.step_type_all
    } else {
        b = $.is_odds_declen3(c.value) ? 3 : 3
    }
    this.setStepsOpts(b)
}
;
Monitor.prototype.setStepsOpts = function(b) {
    var c = $("#adjustment_steps");
    this.c_step_type = b;
    var a = c.val();
    if (2 == b) {
        if (a < 0.01 && a > 0) {
            a = "0.010"
        }
        if (a < 0 && a > -0.01) {
            a = "-0.010"
        }
        this.set_odds_step(this.menu_id, a);
        $("#adjustment_steps").val(a)
    }
}
;
Monitor.prototype.refersh_rate = function() {
    var a = [], c;
    if (this.odds_set !== this.data.odds_set) {
        return
    }
    for (var b in this.data.odds) {
        if (this.data.odds.hasOwnProperty(b)) {
            if (!this.key_odds[b]) {
                continue
            }
            if (0 !== this.chg_odds_set && this.key_odds[b].innerHTML !== this.data.odds[b]) {
                a.push(this.key_odds[b]);
                if (c) {
                    a.push(c)
                }
            }
            this.key_odds[b].innerHTML = this.data.odds[b];
            c = $("#orders").find("#" + b)[0];
            if (c) {
                c.innerHTML = this.data.odds[b]
            }
        }
    }
    $.lightOn(a)
}
;
Monitor.prototype.refersh_detail = function() {
    for (var b in this.data.amts) {
        if (this.data.amts.hasOwnProperty(b)) {
            if (!this.key_detail[b]) {
                continue
            }
            for (var a = 0; a < this.data.amts[b].length; a++) {
                var c = this.key_detail[b][a];
                if (c) {
                    c.innerHTML = this.data.amts[b][a];
                    if (this.getFlag(this.colorLimit.flag, b) === a) {
                        c.style.color = this.getColor(this.data.amts[b][a], a)
                    }
                }
            }
        }
    }
    $("#totalwinlos:disabled").removeAttr("disabled")
}
;
Monitor.prototype.getFlag = function(b, a) {
    if (b === 0) {
        return 0
    } else {
        var c = a.substring(0, 3);
        if ("000" == c || "016" == c || ("002" <= c && "007" >= c)) {
            return 1
        }
        return 0
    }
}
;
Monitor.prototype.getColor = function(b, a) {
    var d = parseInt(b.toString().replace(/,/g, ""), 10), f = this.colorLimit, g;
    g = "";
    if (a == 1) {
        if (d > -f.val[0]) {
            g = ""
        } else {
            if (d > -f.val[1]) {
                g = f.color[0]
            } else {
                if (d > -f.val[2]) {
                    g = f.color[1]
                } else {
                    if (d <= -f.val[2]) {
                        g = f.color[2]
                    }
                }
            }
        }
    } else {
        if (d < f.val[0]) {
            g = ""
        } else {
            if (d < f.val[1]) {
                g = f.color[0]
            } else {
                if (d < f.val[2]) {
                    g = f.color[1]
                } else {
                    if (d >= f.val[2]) {
                        g = f.color[2]
                    }
                }
            }
        }
    }
    return g
}
;
Monitor.prototype.refersh_total = function() {
    for (var a in this.data.menus) {
        if (this.data.menus.hasOwnProperty(a)) {
            if (!this.play_total[a]) {
                continue
            }
            this.set_total(this.play_total[a], this.data.menus[a], true)
        }
    }
}
;
Monitor.prototype.set_new_bet = function() {
    var b = document.getElementById("orders");
    $("#orders tbody tr").each(function() {
        this.className = ""
    });
    if (!this.data.news || !this.data.amts) {
        return
    }
    if (this.data.news.length !== 0 || this.data.amts.length !== 0) {
        $("#orders tbody td").each(function() {
            if (this.cellIndex !== 0) {
                $(this).text("")
            }
        })
    }
    var f = 1;
    var h = this.data.news
        , g = "title='{#|8865|8d27#}'".keyComment();
    if (this.gms_fcorp === 1) {
        g = ""
    }
    for (var c in h) {
        if (h.hasOwnProperty(c)) {
            var a = h[c];
            if (b.rows[f]) {
                b.rows[f].cells[1].innerHTML = '<strong><span class="' + $.getBallColor(a[0]) + '">' + a[0] + "</span></strong>";
                b.rows[f].cells[2].innerHTML = a[1];
                b.rows[f].cells[3].innerHTML = a[2];
                b.rows[f].cells[4].innerHTML = '<a class="red" href="?" bh="' + c + '" ' + g + ">" + a[3] + "</a>";
                if (a[4]) {
                    b.rows[f].className = "chg"
                }
            }
            f++
        }
    }
}
;
Monitor.prototype.regist_clicks = function() {
    var a = this;
    $("#rate_type,#odds_type").change(function() {
        a.chg_odds_set = 0;
        a.time_stamp = 0;
        var b = document.getElementById("odds_type").value;
        if (document.getElementById("rate_type")) {
            b += "_" + document.getElementById("rate_type").value
        }
        a.odds_set = b;
        a._refersh()
    });
    $("#alarm").change(function() {
        a.alarm = this.value
    });
    $("#mon_top").click(function(c) {
        var d = c.target;
        var b = $(d);
        if (d.nodeName == "A") {
            if (b.attr("tp") == "adjustment") {
                a.changeSteps();
                a.ajax_batch_chg_odds(a.menu_id, $("#adjustment_type").val(), $("#adjustment_steps").val(), a.game_id)
            } else {
                if (b.attr("tp") == "refersh_rate") {
                    a._refersh()
                } else {
                    if (b.attr("cat_id")) {
                        if (b.attr("start") == "stop") {
                            if (!confirm("你確定要啟用" + b.text() + "嗎?")) {
                                return false
                            }
                            a.ajax_stop_game(b.attr("cat_id"), 1, d)
                        } else {
                            if (!confirm("你確定要{#|505c|62bc#}".keyComment() + b.text() + "嗎?")) {
                                return false
                            }
                            a.ajax_stop_game(b.attr("cat_id"), 0, d)
                        }
                    }
                }
            }
            return false
        }
    });
    $("#buzhongmenu,#lianmamenu").click(function(c) {
        var b = c.target;
        if ("A" != b.tagName) {
            b = b.parentNode
        }
        if ("A" != b.tagName) {
            return
        }
        location.replace(b.getAttribute("href"));
        return false
    });
    $(document).bind("oddsdata", function(c, d, b) {
        $.getJSON("ajax_req.htm?act=chg_odds&number=" + c.target.id + "&odds_set=" + a.odds_set + "&type=1&value=" + d + "&ov=" + b, function(f) {
            if (f.status == 2) {
                return
            }
            a.set_sign_rate(f);
            a.reset_alarm_time()
        })
    });
    $(document).bind("ftongji", function() {
        $('A[tp="refersh_rate"]').trigger("click")
    });
    $(a.dom).click(function(c) {
        var b = c.target;
        if (b.tagName == "A") {
            var d = b.className ? b.className : "";
            if ($(b.parentNode).attr("product")) {
                if (a.gms_fcorp === 0) {
                    a.popup_buhuo(b.parentNode)
                }
            } else {
                if (0 === d.indexOf("pl")) {
                    if (a.gms_fcorp === 0) {
                        $(b).trigger("oddspupop", [b.parentNode.previousSibling.innerHTML, b.parentNode.previousSibling.className])
                    }
                } else {
                    if (d == "ico up") {
                        a.rate_add_low(b)
                    } else {
                        if (d == "ico dn") {
                            a.rate_add_low(b)
                        } else {
                            if (d.indexOf("popup") >= 0) {
                                a.popup(b)
                            } else {
                                if (b.href && !b.disabled) {
                                    $url = b.href + (b.className.indexOf("red") > -1 ? "&amt=" + $(b).text() : "");
                                    if (b.href.indexOf("waidiaobuhuo.htm") != -1) {
                                        if (a.gms_fcorp === 0) {
                                            JqueryDialog.Open('<h2 class="g-tit">公司間外調{#|8865|8d27#}</h2>'.keyComment(), $url, 480, $.popup_size[1], false)
                                        }
                                    } else {
                                        JqueryDialog.Open1("{#|4e0b|6ce8#}明細".keyComment(), $url, 800, 330, false, true, false, false)
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false
        } else {
            if ($(b).attr("product")) {
                a.popup_buhuo(b)
            }
        }
    });
    if (this.order_hander) {
        $(this.order_hander.parentNode).css({
            position: "relative"
        });
        $(this.order_hander).addClass("g-hs").click(function() {
            this.blur();
            a.leftDom.toggleClass("g-hr");
            $.get("ajax_req.htm?act=set_hide_status&menu_id=" + a.menu_id + "&status=" + (a.leftDom.hasClass("g-hr") ? 1 : 0));
            return false
        });
        $("#orders").click(function(f) {
            var d = f.target;
            if ("A" == d.tagName) {
                var c = d.getAttribute("bh");
                if (c) {
                    if (a.gms_fcorp === 0) {
                        var b = "../statis/waidiaobuhuo.htm?id=" + c;
                        JqueryDialog.Open('<h2 class="g-tit">公司間外調{#|8865|8d27#}</h2>'.keyComment(), b, 480, $.popup_size[1], false)
                    }
                    return false
                }
            }
        })
    }
    $("#adjustment_type").change(function() {
        a.changeSteps()
    });
    $("#adjustment_steps").change(function() {
        if (this.value != 0 && Math.abs(this.value) < 0.01) {
            a.c_step_type = 3
        }
        a.set_odds_step(a.menu_id, this.value)
    });
    parent.$.bind("gameupdate." + a.dom.id, function(b, c) {
        if (c.status) {
            a.status = c.status;
            a.onOffStatus()
        }
    });
    parent.$.bind("get_monitor_data." + a.dom.id, function(c, b) {
        a.refersh(b)
    });
    $("#buhuo_limit").submit(function() {
        if ($.validateEm(this.buhuo)) {
            if (this.buhuo.value == a.data.limit) {
                alert("請修改後再保存");
                return false
            }
            a.ajax_chg_short_covering_limit(a.menu_id, this.buhuo.value)
        }
        return false
    })
}
;
Monitor.prototype.set_odds_step = function(a, b) {
    $.get("ajax_req.htm?act=set_odds_step&category_id=" + a + "&item_type=1&step=" + b)
}
;
Monitor.prototype.popup_buhuo = function(c) {
    var b = $(c).next("td")[0];
    if (b) {
        var a = $("a[action=supplement]:first", b)[0];
        if (a) {
            this.popup(a)
        }
    }
}
;
Monitor.prototype.rate_add_low = function(c) {
    var b = document.getElementById("adjustment_steps").value.replace("-", "");
    var a = c.getAttribute("action");
    if (a == "lower") {
        b = "-" + b
    }
    this.set_rate(b, a == "lower" ? c.previousSibling : c.nextSibling)
}
;
Monitor.prototype.ajax_batch_chg_odds = function(a, f, c, b) {
    var d = this;
    $.getJSON("ajax_req.htm?act=batch_chg_odds&menu_id=" + a + "&game_id=" + b + "&play_type=" + f + "&odds_set=" + this.odds_set + "&value=" + c + "&time_stamp=" + d.time_stamp, function(h) {
        if (!h.status) {
            var j = h.list
                , g = [];
            for (var l in j) {
                if (j.hasOwnProperty(l)) {
                    var k = document.getElementById(l);
                    if (k) {
                        k.innerHTML = j[l];
                        g.push(k);
                        d.odds_refersh[k.id] = j[l]
                    }
                    k = $("#orders").find("#" + l)[0];
                    if (k) {
                        k.innerHTML = j[l];
                        g.push(k)
                    }
                }
            }
            d.time_stamp = h.time_stamp || d.time_stamp;
            d.reset_alarm_time();
            $.lightOn(g)
        }
    })
}
;
Monitor.prototype.ajax_chg_short_covering_limit = function(a, b) {
    $.getJSON("ajax_req.htm?act=chg_short_covering_limit&menu_id=" + a + "&max_value=" + b, function(c) {
        if (!c.status) {
            alert("修改{#|8865|8d27#}限額成功！".keyComment())
        } else {
            alert("修改{#|8865|8d27#}限額失敗！".keyComment())
        }
    })
}
;
Monitor.prototype.ajax_stop_game = function(d, a, c) {
    var b = this;
    $.getJSON("ajax_req.htm?act=stop_game&category_id=" + d + "&status=" + a, function(g) {
        if (undefined !== g.status && !g.status) {
            b._refersh();
            alert("操作成功！");
            var f;
            if (d == "-1") {
                f = $('a[cat_id!="00"][cat_id!="-2"]', "#stop_mark")
            } else {
                f = $(c)
            }
            if (1 === a) {
                f.addClass("green").removeClass("red").attr("start", "open").attr("title", "當前處於啟用狀態，點擊{#|505c|62bc#}{#|73a9|6cd5#}".keyComment())
            } else {
                f.addClass("red").removeClass("green").attr("start", "stop").attr("title", "當前處於{#|505c|62bc#}狀態，點擊啟用{#|73a9|6cd5#}".keyComment())
            }
        } else {
            alert("操作失敗！尚未{#|5f00|76d8#}或其他原因！".keyComment())
        }
    })
}
;
Monitor.prototype.init_stop_game = function() {
    var a = "";
    $("#stop_mark a").each(function(b) {
        if (!a) {
            a = this.getAttribute("cat_id")
        } else {
            a = a + "," + this.getAttribute("cat_id")
        }
    });
    return a
}
;
Monitor.prototype.ajax_init_stop_game = function(a) {
    if (!a) {
        return
    }
    $("#stop_mark a").each(function() {
        var b = a[this.getAttribute("cat_id")] == 1 ? "open" : "stop";
        if (b == "stop") {
            $(this).addClass("red").removeClass("green");
            this.setAttribute("start", "stop");
            this.setAttribute("title", "當前處於{#|505c|62bc#}狀態，點擊啟用{#|73a9|6cd5#}".keyComment())
        } else {
            $(this).addClass("green").removeClass("red");
            this.setAttribute("start", "open");
            this.setAttribute("title", "當前處於啟用狀態，點擊{#|505c|62bc#}{#|73a9|6cd5#}".keyComment())
        }
    })
}
;
Monitor.prototype.reset_alarm_time = function() {
    this.alarm = document.getElementById("alarm").value - ("" === this.alarm ? 0 : 1);
    var a = "&menu_id=" + this.menu_id + "&odds_set=" + this.odds_set + "&time_stamp=" + this.time_stamp + "&cat_ids=" + this.init_stop_game() + "&is_total_win_loss=" + this.is_total_win_loss;
    parent.$.trigger("change_ajax_timer", ["get_monitor_data", {
        timer: (this.alarm + 1) * 1000,
        active: true,
        param: a
    }])
}
;
Monitor.prototype.set_rate = function(f, g) {
    if (parseFloat(g.childNodes[0].data) + parseFloat(f) < 0) {
        alert("當前{#|8d54|7387#}值修改後不能為負數！".keyComment())
    } else {
        var c = g.id;
        var d = c.substr(0, 3);
        var a = $.is_odds_declen3(d) ? 3 : 3;
        if (this.c_step_type != a && a == 2 && Math.abs(f) < 0.01) {
            f = f < 0 ? -0.01 : 0.01
        }
        this.setStepsOpts(a);
        var b = "ajax_req.htm?act=chg_odds&number=" + c + "&odds_set=" + this.odds_set + "&type=0&value=" + f + "&time_stamp=" + this.time_stamp;
        $.ajaxAction(this, this.set_sign_rate, b)
    }
    this.reset_alarm_time();
    this.odds_refersh[g.id] = f
}
;
Monitor.prototype.set_sign_rate = function(b) {
    var a = [];
    if ("-1" == b.status) {
        alert("超過最高{#|8d54|7387#}".keyComment() + b.max_odds);
        return false
    }
    if (!b.status && typeof (b.odds) != "undefined") {
        var c = document.getElementById(b.number);
        c.innerHTML = b.odds;
        a.push(c);
        c = $("#orders").find("#" + b.number)[0];
        if (c) {
            c.innerHTML = b.odds;
            a.push(c)
        }
    }
    this.odds_data = b;
    this.time_stamp = b.time_stamp || this.time_stamp;
    $.lightOn(a)
}
;
Monitor.prototype.set_alarm = function() {
    document.getElementById("alarm_show").value = this.alarm;
    this.alarm--;
    if (this.alarm < 0) {
        this.reset_alarm_time()
    }
}
;
Monitor.prototype.popup = function(a) {
    var f = a.getAttribute("action");
    var g = f == "detail" ? "../statis/xiazhumingxi.htm?id=" : "../statis/waidiaobuhuo.htm?id=";
    var b = f == "detail" ? $.popup_size[0] : 480;
    var j = a.getAttribute("key");
    g += j;
    if (f == "detail") {
        var d = a.offsetParent;
        var k = $(d.parentNode.cells[d.cellIndex - 1]).text();
        g += "&name=" + encodeURI(k)
    }
    var c = j.substring(0, 3);
    var h = $.popup_size[1];
    if (f == "detail") {
        JqueryDialog.Open1("{#|6ce8|5355#}明細".keyComment(), g, b, h, false, true)
    } else {
        if (this.gms_fcorp === 0) {
            JqueryDialog.Open('<h2 class="g-tit">公司間外調{#|8865|8d27#}</h2>'.keyComment(), g, b, $.popup_size[1], false)
        }
    }
}
;
Monitor.prototype.init_plays = function() {
    if (document.getElementById("others")) {
        this.plays = {
            "013": ["单1", "单2", "单3", "单4", "单5", "单6", "特单", "双1", "双2", "双3", "双4", "双5", "双6", "特双", "大1", "大2", "大3", "大4", "大5", "大6", "特大", "小1", "小2", "小3", "小4", "小5", "小6", "特小"],
            "014": ["鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"],
            "015": ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"],
            "016": ["{#|7ea2|5927#}".keyComment(), "{#|84dd|5927#}".keyComment(), "{#|7eff|5927#}".keyComment(), "{#|7ea2|5c0f#}".keyComment(), "{#|84dd|5c0f#}".keyComment(), "{#|7eff|5c0f#}".keyComment(), "{#|7ea2|5355#}".keyComment(), "{#|84dd|5355#}".keyComment(), "{#|7eff|5355#}".keyComment(), "{#|7ea2|53cc#}".keyComment(), "{#|84dd|53cc#}".keyComment(), "{#|7eff|53cc#}".keyComment()],
            "017": ["{#|516d|8096#}".keyComment()],
            "034": ["特鼠", "特牛", "特虎", "特兔", "特龙", "特蛇", "特马", "特羊", "特猴", "特鸡", "特狗", "特猪"]
        }
    } else {
        if (document.getElementById("weishulian")) {
            this.plays = {
                "041": ["a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a0"],
                "042": ["b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b0"],
                "043": ["c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c0"],
                "044": ["d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d0"],
                "045": ["e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e0"],
                "046": ["f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f0"]
            }
        } else {
            if (document.getElementById("shengxiaolian")) {
                this.plays = {
                    "035": ["a鼠", "a牛", "a虎", "a兔", "a龙", "a蛇", "a马", "a羊", "a猴", "a鸡", "a狗", "a猪"],
                    "036": ["b鼠", "b牛", "b虎", "b兔", "b龙", "b蛇", "b马", "b羊", "b猴", "b鸡", "b狗", "b猪"],
                    "037": ["c鼠", "c牛", "c虎", "c兔", "c龙", "c蛇", "c马", "c羊", "c猴", "c鸡", "c狗", "c猪"],
                    "038": ["d鼠", "d牛", "d虎", "d兔", "d龙", "d蛇", "d马", "d羊", "d猴", "d鸡", "d狗", "d猪"],
                    "039": ["e鼠", "e牛", "e虎", "e兔", "e龙", "e蛇", "e马", "e羊", "e猴", "e鸡", "e狗", "e猪"],
                    "040": ["f鼠", "f牛", "f虎", "f兔", "f龙", "f蛇", "f马", "f羊", "f猴", "f鸡", "f狗", "f猪"]
                }
            } else {
                this.plays = $.products
            }
        }
    }
}
;
$.extend({
    jdLinkClick: function(a) {
        $(a).click(function(c) {
            var b = c.target;
            if ("A" != b.tagName) {
                b = b.parentNode
            }
            if ("A" != b.tagName) {
                return
            }
            location.replace(b.getAttribute("href"));
            return false
        })
    },
    hoverDiv: function(h) {
        var g, f = 0, c = h.getElementsByTagName("div")[1], b = $(window), a = $(h);
        $.bind("bover", function(k, l, j, d, m) {
            if (g) {
                clearTimeout(g);
                g = null
            }
            f = j;
            $.getJSON("ajax_req.htm?act=get_crop_odds&odds_set=" + l + "&number=" + j, function(n) {
                n = n[f];
                if (n) {
                    var q = [];
                    for (var p = 0; p < n.length; p++) {
                        q.push("<tr><td>" + n[p][1] + "</td><td>" + n[p][2] + "</td></tr>")
                    }
                    c.innerHTML = "<table><thead><tr><td>公司</td><td>{#|8d54|7387#}</td></tr></thead><tbody>".keyComment() + q.join("") + "</tbody></table>";
                    var o = (d + a.outerWidth()) - (b.width() + b.scrollLeft());
                    var r = (m + a.outerHeight()) - (b.height() + b.scrollTop());
                    h.style.left = d - (o > 0 ? o : 0) + "px";
                    h.style.top = m - (r > 0 ? r : 0) + "px";
                    h.style.display = "block"
                }
            })
        });
        $.bind("bout", function(j, d) {
            g = setTimeout(function() {
                g = null;
                f = 0;
                h.style.display = "none"
            }, 99)
        });
        a.hover(function() {
            if (g) {
                clearTimeout(g);
                g = null
            }
        }, function() {
            f = 0;
            h.style.display = "none"
        })
    }
});
$.extend({
    report: function(b) {
        $("form:first", b).submit(function(d) {
            var c = $(this).find("select");
            if (!c[0].value || !c[1].value) {
                alert("沒有報表數據！");
                return false
            }
            if (c[0].value > c[1].value) {
                alert("起始日期不能大於結束日期！");
                return false
            }
            if (a()) {
                return false
            }
            this.action = $(b).find('input[name="kind"]:checked').val()
        });
        $("button", b).click(function() {
            var c = this.getAttribute("href");
            var d = $('input[name="gameType"]:checked', b).val();
            if (d) {
                c = c + "?gameType=" + d
            }
            if ((this.id == "mon_btn1" || this.id == "mon_btn2") ) {
                c = $("input[name=kind]:checked", b).val() + c.replace(/.*(\?.*)/, "$1")
            }
            location.href = c;
            return false
        });
        $('input[name="crf"]', b).click(function() {
            var f = $(b).find('input[name="crf"]:checked').val();
            if (f) {
                var c = location.href;
                var d = c.indexOf("?");
                c = (d != -1) ? c.substr(c, 0, d) : c;
                location.href = c + "?crf=" + f
            }
            return true
        });
        $("input[name=gameType]", b).click(function() {
            var c = this.value
                , d = $("input[name=kind]", b);
            if (c == 1) {
                d.removeAttr("disabled")
            } else {
                d[0].click();
                d[1].setAttribute("disabled", "disabled")
            }
            return true
        });
        var a = function() {
            var d = $(b).find('select[name="draw_date"]')[0];
            var g = $(b).find('select[name="draw_date2"]')[0];
            var f = parseInt(document.getElementById("report_date_limit").innerHTML, 10);
            var c = g.selectedIndex - d.selectedIndex;
            if (f < Math.abs(c)) {
                alert("查詢{#|671f|6570#}跨度不能超過".keyComment() + f + "期！ ");
                return true
            }
            return false
        }
    },
    reportHideCol: function(b, a) {
        $("thead .hc", b).click(function(l) {
            var g = $(l.target).parents("td")[0], d, k = $(g).parents("table").find("tr"), j = a || 14;
            for (var f = 0; f < k[0].cells.length; f++) {
                if (k[0].cells[f] === g) {
                    d = f;
                    break
                }
            }
            var h = (d === j || d === 11) ? 1 : 0;
            var c = (k[0].cells[d - 1 - h].className + " ").indexOf("hid ");
            k.each(function(m) {
                if (-1 !== c) {
                    $(this.cells[d - 1 - h]).removeClass("hid");
                    $(this.cells[d - 2 - h]).removeClass("hid")
                } else {
                    $(this.cells[d - 1 - h]).addClass("hid");
                    $(this.cells[d - 2 - h]).addClass("hid")
                }
            })
        })
    },
    freportHideCol: function(a) {
        $.reportHideCol(a, 13)
    }
});
var TotalLm = function() {
    this.table = {};
    this.init();
    this.alarm = "";
    this.list = ""
};
TotalLm.prototype.init = function() {
    this.init_date()
}
;
TotalLm.prototype.init_date = function() {
    this.list = $.lianma_list;
    var h = this.list.game;
    for (var a in h) {
        if (h.hasOwnProperty(a)) {
            document.getElementById("amt" + a).innerHTML = h[a].amt;
            var d = document.getElementById(a);
            d.rows[1].cells[1].innerHTML = h[a].sum[0];
            d.rows[1].cells[2].innerHTML = h[a].sum[1];
            var c = h[a].list;
            var g = "";
            var b = 1;
            for (var f in c) {
                if (c.hasOwnProperty(f)) {
                    g += "<tr id=" + f + "><td>" + (b++) + "</td><td>" + f + "</td><td>" + c[f][0] + "</td><td>" + c[f][0] + "</td></tr>"
                }
            }
            $(d).html("<tr>" + d.rows[0].innerHTML + "</tr>" + g + "<tr>" + d.rows[1].innerHTML + "</tr>")
        }
    }
}
;
TotalLm.prototype.refersh = function(f) {
    this.refersh_list = $.lianma_list;
    var h = this.refersh_list.game;
    for (var a in h) {
        if (h.hasOwnProperty(a)) {
            document.getElementById("amt" + a).innerHTML = h[a].amt;
            var c = document.getElementById(a);
            c.rows[c.rows.length - 1].cells[1].innerHTML = h[a].sum[0];
            c.rows[c.rows.length - 1].cells[2].innerHTML = h[a].sum[1];
            var b = h[a].list;
            for (var g in b) {
                if (b.hasOwnProperty(g)) {
                    var d = document.getElementById(g);
                    d.cells[2] = b[g][0];
                    d.cells[3] = b[g][1]
                }
            }
        }
    }
}
;
TotalLm.prototype.set_alarm = function() {
    $("#alarm_show").val(this.alarm == "no" ? "" : this.alarm--);
    if (this.alarm == -1) {
        this.reset_alarm_time()
    }
    var a = this;
    setTimeout(function() {
        a.set_alarm.call(a)
    }, 1000)
}
;
TotalLm.prototype.reset_alarm_time = function() {
    this.alarm = document.getElementById("alarm").value
}
;
$.extend({
    tongjiHead: function(u) {
        if (self === top) {
            $("body").empty();
            alert("新窗口不可用，請關閉該窗口。");
            return
        }
        var r = $(u), o = r.find(".n2")[0], l = $(".g-jt td", r), s, w, x = 1, g = window.gms_fcorp ? 1 : 0;
        parent.$.bind("init." + u.id, function(z, d) {
            parent.$.unbind("init." + u.id);
            s = d.status;
            var t = function() {
                if (w !== s) {
                    if ("1" == s) {
                        $("body:first").removeClass("off")
                    } else {
                        $("body:first").addClass("off")
                    }
                    w = s
                }
            };
            t();
            parent.$.bind("gameupdate." + u.id, function(B, A) {
                if (A.status) {
                    s = A.status;
                    t()
                }
            })
        });
        parent.$.trigger("getinit");
        $(window).unload(function() {
            parent.$.unbind("." + u.id)
        });
        if (o) {
            var h, v, j = null;
            var f = document.getElementById("pulse");
            var p = o.getElementsByTagName("select")[0];
            var y = function(d) {
                if ("no" == p.value) {
                    if (j) {
                        clearInterval(j);
                        j = null;
                        h = "";
                        f.value = ""
                    }
                    parent.$.trigger("change_ajax_timer", ["get_statics_data", {
                        active: false
                    }])
                } else {
                    h = parseInt(p.value, 10);
                    v = h;
                    f.value = v;
                    var t = arguments.length === 2 ? arguments[1] : d;
                    parent.$.trigger("change_ajax_timer", ["get_statics_data", {
                        param: $.get_params(),
                        timer: (h) * 1000,
                        active: t == "init" ? false : true
                    }]);
                    if (!j && t != "init") {
                        j = setInterval(function() {
                            if (x) {
                                v--;
                                f.value = v;
                                if (0 >= v) {
                                    v = h
                                }
                            }
                        }, 1000)
                    }
                }
            };
            $(p).change(y);
            y("init");
            $.bind("chtime", y);
            $("#refresh").click(function() {
                v = h;
                f.value = v || "";
                $.trigger("tongji");
                return false
            });
            var c = u.getElementsByTagName("form")[0];
            $.bind("tongjipost", function() {
                c.submit()
            });
            var m = $("select:eq(1)", u);
            if (m) {
                m.change(function(d) {
                    $.trigger("setplbc", [d.target.value])
                })
            }
            $.bind("resettime", function() {
                v = h;
                f.value = v || ""
            })
        }
        $(u).click(function(A) {
            var d = A.target;
            var z = d.getAttribute("href") || d.parentNode.getAttribute("href");
            if (z && !d.disabled) {
                parent.$.unbind("get_statics_data");
                parent.$.trigger("change_ajax_timer", ["get_statics_data", {
                    active: false
                }]);
                location.replace(z);
                return false
            }
        });
        $.bind("stopstatis", function(t, d) {
            l.each(function(z) {
                if (0 === d[z]) {
                    $(this).addClass("sp")
                } else {
                    $(this).removeClass("sp")
                }
            })
        });
        $("#totalwinlos").bind("change change_totalwinlos", function(t) {
            var d = document.getElementById("totalwinlos_td");
            if (t.type === "change") {
                if (this.checked === true) {
                    $.hv.totalwinlos = 1
                } else {
                    $.hv.totalwinlos = 0
                }
                $.hv.totalwinlos_click = 1;
                parent.$.trigger("change_ajax_timer", ["get_statics_data", {
                    param: $.get_params()
                }]);
                $.trigger("tongji");
                this.disabled = true
            }
            if (t.type === "change_totalwinlos") {
                if (d) {
                    if (this.checked === true) {
                        d.innerHTML = "總項贏虧"
                    } else {
                        d.innerHTML = "{#|80dc|51fa|91d1|989d#}".keyComment()
                    }
                }
                this.disabled = false;
                delete $.hv.totalwinlos_click;
                parent.$.trigger("change_ajax_timer", ["get_statics_data", {
                    param: $.get_params()
                }])
            }
        });
        $.bind("runtime", function(t, d) {
            x = d;
            if (d) {
                $.trigger("releaseOdd")
            }
        });
        var b = {};
        $("td[id]", u).each(function() {
            b[this.id] = this.getElementsByTagName("sup")[0]
        });
        $.bind("menudata", function(A, d) {
            var t = [];
            for (var z in d) {
                if (b[z] && b[z].innerHTML != d[z]) {
                    b[z].innerHTML = d[z];
                    t.push(b[z])
                }
            }
            $.lightOn(t)
        });
        var k = $("input[name='shortCoverRadio']");
        var q = document.getElementById("shortCoverPlay");
        var a = $("input[name='shortCoverRadio']:checked").val();
        if (undefined != q) {
            $(q).focus();
            $(q).bind("change", function() {
                n(a, q.value)
            });
            $(q).keyup(function(d) {
                if ("40" == d.keyCode || "38" == d.keyCode) {
                    n(a, q.value)
                }
            })
        }
        k.click(function(d) {
            a = d.target.value;
            n(a, q.value)
        });
        var n = function(z, t) {
            var d = "short_cover_list.htm?game_id=" + t + "&radio=" + z;
            location.replace(d)
        }
    },
    hv: {
        odds_set: "S",
        isHide: 1,
        totalwinlos: 0
    },
    get_params: function() {
        var a = $.hv.category_id != undefined ? "&category_id=" + $.hv.category_id : "";
        a += $.hv.game_id != undefined ? "&game_id=" + $.hv.game_id : "";
        a += $.hv.time_stamp != undefined ? "&time_stamp=" + $.hv.time_stamp : "";
        a += $.hv.fresh != undefined ? "&fresh=" + $.hv.fresh : "";
        a += $.hv.odds_set != undefined ? "&odds_set=" + $.hv.odds_set : "";
        a += $.hv.pageId != undefined ? "&pageId=" + $.hv.pageId : "";
        a += "&ishide=" + $.hv.isHide;
        if (document.getElementById("totalwinlos")) {
            a += "&totalwinlos=" + $.hv.totalwinlos;
            if ($.hv.totalwinlos_click != undefined) {
                a += "&totalwinlos_click=1"
            }
        }
        return a
    },
    tongjiFresh: function(n) {
        var g = $(n)
            , p = $("input:hidden", g);
        var r = [];
        p.each(function() {
            $.hv[this.name] = this.value
        });
        var l = $(".bd", g);
        var m, q = $('select[name="plbc"]').val(), k = 0, f = window.gms_fcorp ? 1 : 0;
        var o = function() {
            if ("0" !== $.hv.level) {
                return
            }
            $("td[act=pl]", n).each(function() {
                var s = this.parentNode;
                var d = s.parentNode.parentNode;
                $("tbody>tr :nth-child(" + ($.getCellIndex(this) + 1) + ")", d).each(function() {
                    this.innerHTML = '<a href="javascript:void(0)" class="ico up" act="up">+</a><a href="javascript:void(0)" act="spl" class="pl">' + this.innerHTML + '</a><a href="javascript:void(0)" class="ico dn" act="down">-</a>'
                })
            })
        };
        o();
        $.bind("setplbc", function(s, d) {
            q = d;
            $.get("ajax_req.htm?act=set_odds_step&category_id=" + $.hv.category_id + "&step=" + d, function(t) {
                if (!t) {
                    return
                }
                if (t == "Lost session" || t == "Duplicate session") {
                    location.reload()
                }
            })
        });
        $.trigger("chtime");
        var a = false
            , h = false;
        var b = function(s) {
            if (s.bChangeOrder !== undefined) {
                parent.$.trigger("isbChangeOrder", [s.bChangeOrder])
            }
            if (!s || !s.cnt) {
                return
            }
            if (s == "Lost session" || s == "Duplicate session") {
                location.reload()
            }
            if (h) {
                return
            }
            l.empty();
            l.html(s.cnt);
            if (document.getElementById("totalwinlos")) {
                $("#totalwinlos").trigger("change_totalwinlos")
            }
            if (f === 1) {
                $("select[act!=qh]", l).addClass("hid")
            }
            if (s.menus) {
                $.trigger("menudata", [s.menus])
            }
            if (s.page_object) {
                $(".fr").html(s.page_object)
            }
            $("input:hidden", l).each(function() {
                $.hv[this.name] = this.value
            });
            o();
            $.movod();
            if (m) {
                clearTimeout(m)
            }
            m = setTimeout(function() {
                $(".light", l).removeClass("light");
                m = null
            }, $.odds_light);
            if ($.isArray(s.stops) && s.stops.toString() != r.toString()) {
                r = s.stops;
                $.trigger("stopstatis", [r])
            }
            $.trigger("chtime")
        };
        var c = function() {
            if (k) {
                return
            }
            k = 1;
            var d = "ajax_req.htm?act=get_statics_data" + $.get_params();
            $.ajax({
                url: d,
                dataType: "json",
                timeout: $.ajaxtimout,
                complete: function() {
                    k = 0
                },
                success: function(s) {
                    b(s)
                }
            })
        };
        $.bind("ftongji", function() {
            $.hv.fresh = "1";
            $.trigger("resettime");
            c()
        });
        $.bind("tongji", function() {
            c()
        });
        parent.$.unbind("get_statics_data");
        parent.$.bind("get_statics_data." + n.id, function(s, t) {
            b(t)
        });
        var j = function(s, d) {
            $.getJSON("ajax_req.htm?act=chg_odds&number=" + s.parentNode.parentNode.id + "&odds_set=" + $.hv.odds_set + "&type=0&value=" + d + "&time_stamp=" + $.hv.time_stamp + "&flag=s", function(u) {
                if ("-1" == u.status) {
                    alert("超過最高{#|8d54|7387#}".keyComment() + u.max_odds);
                    return false
                }
                var t = $("span:visible", s.parentNode)[0]
                    , v = $.hv.odds_set === "S" ? ($.hv.category_id === "00" ? "AA" : "A") : $.hv.odds_set;
                if (u.status || !t) {
                    return
                }
                t.innerHTML = u.odds[v];
                $.lightOn([t]);
                $.trigger("resettime");
                $("span:hidden", s.parentNode).text(function() {
                    return u.odds[this.getAttribute("oddsset")]
                });
                $.hv.time_stamp = u.time_stamp
            })
        };
        l.delegate("select[act=qh]", "change", function(u) {
            var d = u.target;
            var s = d.value === "S" ? ($.hv.category_id === "00" ? "AA" : "A") : d.value;
            $.each($("span[oddsSet]", l), function(t, v) {
                if (v.getAttribute("oddsSet") === s) {
                    v.className = ""
                } else {
                    v.className = "hid"
                }
            });
            $.hv.odds_set = d.value;
            parent.$.trigger("change_ajax_timer", ["get_statics_data", {
                param: $.get_params()
            }])
        });
        l.bind("click", function(J) {
            var D = J.target, z;
            if ("spl" == D.parentNode.getAttribute("act")) {
                if (f !== 1) {
                    var E = $(document).scrollTop()
                        , d = $(D).parents("tr");
                    var O = $("td:eq(1)>a", d);
                    $(D).trigger("oddspupop", [O.text(), O[0].className, d[0].id.slice(0, 3)]);
                    $(document).scrollTop(E);
                    h = true;
                    $.trigger("chtime", "init")
                }
                return false
            }
            var L = D.getAttribute("act");
            if (L && !D.disabled && L !== "qh") {
                switch (L) {
                    case "db":
                        var F = D.getAttribute("gid");
                        var s = [];
                        var I = false;
                        var B;
                        if ((F >= "008" && F <= "012") || (F >= "035" && F <= "046") || F == "054" || F == "055") {
                            B = $("table[gid='" + F + "']");
                            z = 3
                        } else {
                            B = $(D).parents("table");
                            z = $.getCellIndex(D.parentNode)
                        }
                        $(" tbody>tr", B).each(function(P) {
                            var t = this.id;
                            var R = $(this.cells[1]).find("a").text();
                            var Q = $(this.cells[z]).find("a").text();
                            if (t && "0" != Q) {
                                s.push(t + "|" + Q + "|" + R);
                                if (P >= 29) {
                                    I = true
                                }
                            }
                        });
                        var y = D.getAttribute("to");
                        if (F && I || (F == "017" || F == "018")) {
                            y = y + "&ids=-1"
                        } else {
                            y = y + "&ids=" + encodeURI(s.join("@"))
                        }
                        var w = $.hv.category_id && $.hv.category_id == "10" ? 2045 : 2083;
                        var N = $.browser.msie ? (y.length >= w ? true : false) : (y.length >= 4098 ? true : false);
                        if (N) {
                            alert("一次{#|8865|8d27#}的球號太多，請嘗試手動{#|8865|8d27#}幾項後再多補！".keyComment());
                            return false
                        }
                        if ($.hv.level == "0") {
                            JqueryDialog.Open('<h2 class="g-tit">公司間外調{#|8865|8d27#}(多補) -- [以A盘{#|8d54|7387#}为准]</h2>'.keyComment(), y, $.popup_size[0], $.popup_size[1], true)
                        } else {
                            JqueryDialog.Open('<h2 class="g-tit">下級給上級{#|8865|8d27#}(多補) -- [以A盘{#|8d54|7387#}为准]</h2>'.keyComment(), y, $.popup_size[0], $.popup_size[1], true)
                        }
                        $.disableAWhile(D, 5);
                        break;
                    case "up":
                        j(D, q);
                        break;
                    case "down":
                        j(D, "-" + q);
                        break;
                    case "hide":
                        var A = $(D).parents("td")[0]
                            , u = $(A).parents("table").find("tr");
                        z = $.getCellIndex(A);
                        var x = (u[0].cells[z + 1].className + " ").indexOf("hid ");
                        u.each(function(t) {
                            if (-1 !== x) {
                                $(this.cells[z + 4]).removeClass("hid");
                                $(this.cells[z + 3]).removeClass("hid");
                                $(this.cells[z + 2]).removeClass("hid");
                                $(this.cells[z + 1]).removeClass("hid");
                                $.hv.isHide = 0
                            } else {
                                $(this.cells[z + 4]).addClass("hid");
                                $(this.cells[z + 3]).addClass("hid");
                                $(this.cells[z + 2]).addClass("hid");
                                $(this.cells[z + 1]).addClass("hid");
                                $.hv.isHide = 1
                            }
                        });
                        break
                }
                parent.$.trigger("change_ajax_timer", ["get_statics_data", {
                    param: $.get_params()
                }])
            }
            var H = D.getAttribute("to");
            if (H && !D.disabled) {
                var G = $.popup_size[0];
                var y = encodeURI(H) + (D.className.indexOf("red") > -1 ? "&amt=" + $(D).text().replace(/\,/g, "") : "");
                if (H.indexOf("short_covering.htm") != -1 && $.hv.level != "0") {
                    JqueryDialog.Open('<h2 class="g-tit">下級給上級{#|8865|8d27#}</h2>'.keyComment(), y, $.popup_size[0], $.popup_size[1], false)
                } else {
                    if (H.indexOf("waidiaobuhuo.htm") != -1) {
                        if (f !== 1) {
                            G = $.hv.category_id == "05" ? 555 : 480;
                            JqueryDialog.Open('<h2 class="g-tit">外調{#|8865|8d27#}</h2>'.keyComment(), y, G, $.popup_size[1], false)
                        }
                    } else {
                        if (D.getAttribute("op") == "more") {
                            JqueryDialog.Open1("{#|8fde|7801#}明細".keyComment(), y, G, $.popup_size[1] + 80, false, true)
                        } else {
                            var v = H.indexOf("=") + 1;
                            var C = v + 3;
                            var K = H.substring(v, C);
                            var M = $.popup_size[1];
                            JqueryDialog.Open1("{#|4e0b|6ce8#}明細".keyComment(), y, G, M, false, true, false, false)
                        }
                    }
                }
                return false
            }
        });
        l.bind("oddsdata", function(u, v, s) {
            var d = u.target;
            $.ajax({
                url: "ajax_req.htm?act=chg_odds&number=" + $(d).parents("tr")[0].id + "&odds_set=" + $.hv.odds_set + "&type=1&value=" + v + "&ov=" + s + "&flag=s",
                dataType: "json",
                success: function(t) {
                    if ("-1" == t.status) {
                        alert("超過最高{#|8d54|7387#}".keyComment() + t.max_odds);
                        return false
                    }
                    if (t.status) {
                        return
                    }
                    var w = $.hv.odds_set === "S" ? ($.hv.category_id === "00" ? "AA" : "A") : $.hv.odds_set;
                    d.innerHTML = t.odds[w];
                    $.lightOn([d]);
                    $.trigger("resettime");
                    $("span:hidden", d.parentNode).text(function() {
                        return t.odds[this.getAttribute("oddsset")]
                    });
                    $.hv.time_stamp = t.time_stamp
                }
            })
        });
        $.bind("releaseOdd", function() {
            $.trigger("chtime");
            h = false
        })
    },
    tongjiPopup: function(b) {
        var a = window.gms_fcorp ? window.gms_fcorp : 0;
        $(b.getElementsByTagName("table")[0]).click(function(k) {
            var g = k.target;
            var c = g.getAttribute("to");
            if (c && !g.disabled) {
                var d = $.popup_size[0]
                    , j = $.popup_size[1];
                var f = (screen.width) ? (screen.width - d) / 2 + 20 : 0;
                var l = (screen.height) ? (screen.height - j) / 2 + 20 : 0;
                if (c.indexOf("waidiaobuhuo.htm") != -1) {
                    if (!a) {
                        JqueryDialog.Open('<h2 class="g-tit">公司間外調{#|8865|8d27#}</h2>'.keyComment(), c, $.popup_size[0] - 60, $.popup_size[1] - 50, false)
                    }
                } else {
                    if (c.indexOf("short_covering.htm") != -1) {
                        if (!a) {
                            JqueryDialog.Open('<h2 class="g-tit">下級給上級{#|8865|8d27#}</h2>'.keyComment(), c, $.popup_size[0] - 60, $.popup_size[1] - 50, false)
                        }
                    } else {
                        JqueryDialog.Open1("{#|4e0b|6ce8#}明細".keyComment(), c, d - 170, j - 36, false, true)
                    }
                }
                return false
            }
        });
        $.bind("ftongji", function() {
            location.reload(true)
        })
    }
});
$.extend({
    waidiaobuhuo: function(k) {
        var j = k.getAttribute("act");
        var c = document.forms[0];
        var h = c.game_id.value;
        var b = c.number.value.replace(/[^,]/g, "");
        if ("013" === h) {
            $("#gg_odds").blur(function(r) {
                this.value = this.value.replace(/，/g, ",");
                var n = (this.value).split(",");
                var d = 1;
                for (var p = 0; p < n.length; p++) {
                    if (!((/^[1-9]\d{0,3}(\.\d{1,3})?$/).test(n[p]) && parseFloat(n[p]) > 1)) {
                        alert("{#|8d54|7387#}大於1，長度為1-4位整數，允許最多帶三位小數".keyComment());
                        $.selectEm(this);
                        return false
                    }
                    d = d * n[p]
                }
                d = d.toString();
                var o = d.indexOf(".");
                if (-1 == o) {
                    d = d + ".000"
                } else {
                    d = d + "000";
                    d = d.substr(0, o + 4)
                }
                var q = $("input:first", this.parentNode).get(0);
                if (q) {
                    q.value = d
                }
            })
        }
        if (j && j == "modify") {
            $("input[name=submit_type]").bind("click", function() {
                var r = c;
                if (!$.validateEm(r.amount)) {
                    window.parent.JqueryDialog.ResetButton();
                    return false
                }
                r.odds.value = r.odds.value.replace(/，/g, ",");
                var p = r.odds.value;
                var d = (p).split(",");
                p = p.replace(/[^,]/g, "");
                if ("013" === h && p.length !== b.length) {
                    alert("請輸入" + (b.length + 1) + "個{#|8d54|7387#}，用逗號','隔開".keyComment());
                    $.selectEm(r.odds);
                    window.parent.JqueryDialog.ResetButton();
                    return false
                }
                if (("009" == h || "012" == h) && 1 != p.length) {
                    alert("請輸入兩個{#|8d54|7387#}，用逗號','隔開".keyComment());
                    $.selectEm(r.odds);
                    window.parent.JqueryDialog.ResetButton();
                    return false
                }
                if ("013" != h && "009" != h && "012" != h && 0 !== p.length) {
                    alert("請輸入當前{#|73a9|6cd5#}的最終{#|8d54|7387#}(多個{#|8d54|7387#}中最小{#|8d54|7387#})".keyComment());
                    $.selectEm(r.odds);
                    window.parent.JqueryDialog.ResetButton();
                    return false
                }
                for (var n = 0; n < d.length; n++) {
                    var o = "兩";
                    var q = true;
                    if (parseFloat(d[n]) <= 1) {
                        q = false
                    }
                    if ($.is_odds_declen3(h)) {
                        o = "三";
                        if (q && !((/^[1-9]\d{0,3}(\.\d{1,3})?$/).test(d[n]))) {
                            q = false
                        }
                    } else {
                        if (q && !((/^[1-9]\d{0,3}(\.\d{1,3})?$/).test(d[n]))) {
                            q = false
                        }
                    }
                    if (!q) {
                        alert("{#|8d54|7387#}大於1，長度為1-4位整數，允許最多帶".keyComment() + o + "位小數");
                        $.selectEm(r.odds);
                        q = false;
                        break
                    }
                }
                if (!q || !$.validateEm(r.discount)) {
                    window.parent.JqueryDialog.ResetButton();
                    return false
                }
                $.coverSubmit();
                r.submit()
            });
            $(document).keypress(function(d) {
                if (13 === d.keyCode) {
                    d.target.blur();
                    parent.JqueryDialog.Ok()
                }
            });
            return true
        }
        var m = function(o) {
            if (o.getAttribute("uncheck")) {
                return
            }
            var d = $(o).parents("tr");
            var n = d.find(":radio");
            if (n.length > 0) {
                n[0].checked = true;
                c.corp.value = n[0].value;
                c.corpname.value = n[0].getAttribute("corp_name")
            }
        };
        var g = h == "000";
        $(":radio").get(0).checked = true;
        c.corp.value = $(":radio").get(0).value;
        c.corpname.value = $(":radio").get(0).getAttribute("corp_name");
        var a = function() {
            c.odds2.value = c.odds2.value.replace(/，/g, ",");
            var n = c.odds2.value;
            var d = (n).split(",");
            n = n.replace(/[^,]/g, "");
            if ("013" === h && n.length !== b.length) {
                alert("請輸入" + (b.length + 1) + "個{#|8d54|7387#}，用逗號','隔開".keyComment());
                $.selectEm(c.odds2);
                return false
            }
            if (("009" == h || "012" == h) && 1 != n.length) {
                alert("請輸入兩個{#|8d54|7387#}，用逗號','隔開".keyComment());
                $.selectEm(c.odds2);
                return false
            }
            if ("013" != h && "009" != h && "012" != h && 0 !== n.length) {
                alert("請輸入當前{#|73a9|6cd5#}的最終{#|8d54|7387#}(多個{#|8d54|7387#}中最小{#|8d54|7387#})".keyComment());
                $.selectEm(c.odds2);
                return false
            }
            for (var o = 0; o < d.length; o++) {
                var p = "兩";
                var q = true;
                if (parseFloat(d[o]) <= 1) {
                    q = false
                }
                if ($.is_odds_declen3(h)) {
                    p = "三";
                    if (q && !((/^[1-9]\d{0,3}(\.\d{1,3})?$/).test(d[o]))) {
                        q = false
                    }
                } else {
                    if (q && !((/^[1-9]\d{0,3}(\.\d{1,3})?$/).test(d[o]))) {
                        q = false
                    }
                }
                if (!q) {
                    alert("{#|8d54|7387#}大於1，長度為1-4位整數，允許最多帶".keyComment() + p + "位小數");
                    $.selectEm(c.odds2);
                    return false
                }
            }
            return ( $.validateEm(c.discount2))
        };
        var l = {};
        $("select[name='member_selector']").each(function() {
            if (this.options.length === 0) {
                return
            }
            var n = this.parentNode.cellIndex;
            tr = this.parentNode.parentNode,
                option = this.options[this.selectedIndex],
                id = this.id.replace("member", "oddset"),
                oddsetS = document.getElementById(id),
                user = this.value,
                userValue = null,
                selectL = oddsetS.options.length,
                temp = [];
            l[id] = [];
            tr.setAttribute("odds", option.getAttribute("com_odds"));
            tr.cells[n + 2].innerHTML = option.getAttribute("discount");
            tr.cells[n + 3].innerHTML = option.getAttribute("odds");
            if (oddsetS.options.length > 0) {
                for (var d = selectL - 1; d >= 0; d--) {
                    userValue = oddsetS.options[d].getAttribute(user);
                    l[id].push(oddsetS.options[d]);
                    if (!userValue) {
                        temp.push(d)
                    }
                }
                for (var d = 0; d < temp.length; d++) {
                    oddsetS.remove(temp[d])
                }
                temp = null
            }
            oddsetS.value = option.getAttribute("oddset").split("|")[0]
        });
        $("select").change(function() {
            var d = this.parentNode.cellIndex;
            var t = this.parentNode.parentNode;
            if (this.options.length == 0) {
                return
            }
            var n = this.options[this.selectedIndex]
                , q = document.getElementById(this.id.replace("member", "oddset"));
            if ("member_selector" == this.name) {
                var u = l[q.id];
                q.length = 0;
                for (var p = u.length - 1; p >= 0; p--) {
                    userValue = u[p].getAttribute(this.value);
                    if (userValue) {
                        try {
                            q.add(u[p], null)
                        } catch (s) {
                            q.add(u[p])
                        }
                    }
                }
                q.value = n.getAttribute("oddset").split("|")[0];
                var r = q.options[q.selectedIndex];
                t.cells[d + 2].innerHTML = r.getAttribute(this.value);
                t.cells[d + 3].innerHTML = r.getAttribute("odds");
                t.setAttribute("odds", r.getAttribute("com_odds"))
            } else {
                var o = t.cells[d - 1].firstChild.value;
                t.cells[d + 1].innerHTML = n.getAttribute(o);
                t.cells[d + 2].innerHTML = n.getAttribute("odds");
                t.setAttribute("odds", n.getAttribute("com_odds"))
            }
            m(this)
        }).keypress(function(d) {
            if (40 === d.keyCode || 38 === d.keyCode) {
                $(d.target).trigger("change")
            }
        });
        $("input[name=discount2]").focus(function() {
            m(this)
        });
        $("#auto").click(function(d) {
            m(d.target)
        });
        $("input[name=submit_type]").bind("click", function() {
            var o = c;
            var d = o.corp.value;
            if (!$.validateEm(o.amount)) {
                window.parent.JqueryDialog.ResetButton();
                return false
            }
            if (d == "waidiao") {
                if (!a()) {
                    window.parent.JqueryDialog.ResetButton();
                    return false
                }
                o.odds.value = o.odds2.value;
                o.discount.value = o.discount2.value;
                var p = "您選擇了【外調{#|8865|8d27#}】\r\n{#|8865|8d27#}金額：" + o.amount.value + "\r\n確認提交本次{#|8865|8d27#}？";
                if (!confirm(p.keyComment())) {
                    window.parent.JqueryDialog.ResetButton();
                    return false
                }
                o.submit_type.value = "waidiao"
            } else {
                var n = $("tr[corp_id=" + d + "]")[0];
                o.oddset.value = $("#oddset" + d).val();
                o.odds.value = n.getAttribute("odds");
                o.member.value = $("#member" + d).val();
                o.discount.value = n.cells[3].innerHTML;
                o.submit_type.value = "corp";
                var p = "您選擇了【公司間{#|8865|8d27#}】\r\n{#|8865|8d27#}金額：" + o.amount.value + "  被{#|8865|8d27#}公司：" + o.corpname.value + "\r\n確認提交本次{#|8865|8d27#}？";
                if (!confirm(p.keyComment())) {
                    window.parent.JqueryDialog.ResetButton();
                    return false
                }
            }
            $.setCover("{#|8865|8d27#}中，請不要刷新頁面。<span class='loadding2'/>".keyComment());
            cover.show();
            o.submit();
            return true
        });
        var f = (new Date()).getTime();
        $(":input[name=submit_time_msec]").val(f);
        $(document).keypress(function(d) {
            if (13 === d.keyCode) {
                d.target.blur();
                parent.JqueryDialog.Ok()
            }
        });
        $("input[name=amount]").get(0).focus()
    },
    shangxiabuhuo: function() {
        var b = document.forms.frmBuhuo;
        var a = function() {
            var h = $("#odds_set option:selected");
            var d = h.attr("odds");
            var f = h.attr("detailOdds");
            var g = h.attr("disc");
            $("#odds_show").html(d);
            $("#discount_show").html(g);
            $("input[name=odds]").val(d);
            $("input[name=detailOdds]").val(f)
        };
        $("#odds_set").change(a);
        $(":text").keypress(function(d) {
            if (13 === d.keyCode) {
                parent.JqueryDialog.Ok()
            }
        });
        var c = (new Date()).getTime();
        $(":input[name=submit_time_msec]").val(c);
        $(b).submit(function() {
            return false
        });
        $(":text").get(0).focus()
    },
    GongsiBuHuoMember: function(a) {
        $("input[name=order_flag]", a).keypress(function(c) {
            var b = c.target;
            b.value = b.value.replace(/[^0-9]/g, "");
            if ("0" == b.value) {
                b.value = ""
            }
        });
        $("form", a).submit(function(d) {
            var b = d.target;
            var c = $.trim(b.__login_id.value);
            b.__login_id.value = c;
            if (!$.validateForm(this)) {
                return false
            }
            if (b.password.value != b.password2.value) {
                alert("確認密碼和密碼不一致");
                b.password2.select();
                return false
            }
            if (!confirm("確定賬號密碼輸入正確？")) {
                return false
            }
        })
    },
    Ok: function() {
        var do_Ok = function(frm, oFunction) {
            if (frm) {
                eval(oFunction + "(frm);")
            }
        };
        var form = document.forms[0];
        if (!form) {
            return false
        }
        var func = form.getAttribute("motai");
        if (!func) {
            return false
        }
        func = "$." + func + "_ok";
        do_Ok(form, func)
    },
    shangxiabuhuo_ok: function(a) {
        if (!$.validateForm(a)) {
            window.parent.JqueryDialog.ResetButton();
            return false
        }
        $.coverSubmit();
        a.submit()
    },
    waidiaobuhuo_ok: function(a) {
        $("input[name=submit_type]").click()
    },
    duobu_ok: function(f) {
        var g = $("#duobu")[0];
        var b = $(g).find(":checkbox");
        var a = b.length;
        if (a < 2) {
            return
        }
        for (var c = 1; c < a; c++) {
            if (b[c].checked) {
                $.setCover("多補中，請不要刷新頁面。<span class='loadding2'/>");
                cover.show();
                f.submit();
                return false
            }
        }
        alert("最少選擇一項{#|8865|8d27#}".keyComment());
        window.parent.JqueryDialog.ResetButton();
        return false
    },
    cancelorder: function(a) {
        $("a[name='cancel']", a).click(function(g) {
            if (!confirm("確定要取消當前{#|6ce8|5355#}嗎？".keyComment())) {
                return false
            }
            var f = $(this).parent().parent().children()[0];
            var k = $(this).parent().attr("shortCoverFlag");
            var d = $(this).parent().attr("toCorpId");
            var j = $(this).parent().attr("toHubId");
            var c = $(this).parent().attr("refOrderId");
            var b = $(this).parent().attr("orderTime");
            var h = $("#nnnn").val();
            $.getJSON("ajax_req.htm?act=cancel_order&id=" + f.innerHTML + "&op=cancel&shortCoverFlag=" + k + "&toCorpId=" + d + "&toHubId=" + j + "&refOrderId=" + c + "&nnnn=" + h + "&orderTime=" + b, function(l) {
                if ("1" == l.status) {
                    alert("取消成功！" + (l.msg ? l.msg : ""));
                    location.reload()
                } else {
                    alert("取消失敗！" + (l.msg ? l.msg : ""))
                }
            });
            return false
        });
        $("a[name='reset']", a).click(function(g) {
            if (!confirm("確定要恢復當前{#|6ce8|5355#}嗎？".keyComment())) {
                return false
            }
            var f = $(this).parent().parent().children()[0];
            var k = $(this).parent().attr("shortCoverFlag");
            var c = $(this).parent().attr("refOrderId");
            var b = $(this).parent().attr("orderTime");
            var d = $(this).parent().attr("toCorpId");
            var j = $(this).parent().attr("toHubId");
            var h = $("#nnnn").val();
            $.getJSON("ajax_req.htm?act=cancel_order&id=" + f.innerHTML + "&op=reset&shortCoverFlag=" + k + "&toCorpId=" + d + "&toHubId=" + j + "&refOrderId=" + c + "&nnnn=" + h + "&orderTime=" + b, function(l) {
                if ("1" == l.status) {
                    alert("恢復成功！" + (l.msg ? l.msg : ""));
                    location.reload()
                } else {
                    alert("恢復失敗！" + (l.msg ? l.msg : ""))
                }
            });
            return false
        });
        $.popLink(a)
    }
});
$(document).ready(function() {
    if (window.parent && window.parent.JqueryDialog) {
        window.parent.JqueryDialog.ResetButton()
    }
});
$.extend({
    checkTime: function(b) {
        var a = $("input");
        setTimeout(function() {
            try {
                a[0].focus()
            } catch (c) {}
        }, 0);
        $("form:first", b).submit(function() {
            var c = $(":submit", b);
            c.attr("disabled", true);
            var k = this.elements;
            var m = k.length;
            var p = false;
            var h = $(":hidden[name=op]", b).val();
            if (h == "upd") {
                for (var g = 0; g < m; g++) {
                    var d = k[g];
                    var l = d.type;
                    if (l == "text" && d.name == "draws_drawName") {
                        if (d.value != d.defaultValue) {
                            p = true;
                            break
                        }
                    }
                    if (l == "text" && d.name != "draws_drawName") {
                        if (parseInt(d.value) != parseInt(d.defaultValue)) {
                            p = true;
                            break
                        }
                    }
                }
                if (!p) {
                    alert("請修改後再保存");
                    c.attr("disabled", false);
                    return false
                }
            }
            if (!$.trim(a[0].value)) {
                alert("{#|671f|6570#}名稱不能為空".keyComment());
                c.attr("disabled", false);
                return false
            }
            if (!(/^[^\*]*$/).test(a[0].value)) {
                alert("{#|671f|6570#}名稱含有非法字符，請重新輸入".keyComment());
                c.attr("disabled", false);
                return false
            }
            $.formatTime(this.odtm1, this.odtd1, this.otmh1, this.otmn1, this.otmh2, this.otmn2, this.otmh3, this.otmn3);
            if (!$.validateForm(this) || (this.op.value == "create" && !$.isValidDate(a, 1, "{#|5f00|76d8#}時間不正確，請檢查".keyComment()))) {
                c.attr("disabled", false);
                return false
            }
            var n = this.otmh1.value + this.otmn1.value;
            var f = this.otmh2.value + this.otmn2.value;
            var o = this.otmh3.value + this.otmn3.value;
            if (n >= f || n >= o) {
                alert("非{#|7279|7801#}{#|505c|62bc#}/{#|5173|76d8#}時間不能早於或等於{#|5f00|76d8#}時間".keyComment());
                c.attr("disabled", false);
                return false
            }
            if (f < o) {
                alert("非{#|7279|7801#}{#|505c|62bc#}時間不能晚於{#|5173|76d8#}時間".keyComment());
                c.attr("disabled", false);
                return false
            }
            var j = this.odty1.value + "-" + this.odtm1.value + "-" + this.odtd1.value + " ";
            this.draws_startTime.value = j + this.otmh1.value + ":" + this.otmn1.value + ":00";
            this.draws_endTime.value = j + this.otmh2.value + ":" + this.otmn2.value + ":00";
            this.draws_nTime.value = j + this.otmh3.value + ":" + this.otmn3.value + ":00";
            return true
        })
    },
    drawsRefresh: function(b) {
        $("tbody:first", b).click(function(f) {
            var c = f.target.getAttribute("act");
            var d = f.target;
            if ("del" == c) {
                var g = d.parentNode.parentNode.cells[0];
                if (f.target.getAttribute("msg")) {
                    return confirm("您確認要刪除" + g.innerHTML + "這一期嗎？\r\n\r\n【注意：刪除當前期會引起部分數據異常，請慎重操作！！】")
                } else {
                    return confirm("您確認要刪除" + g.innerHTML + "這一期嗎？\r\n\r\n【注意：刪除{#|671f|6570#}可能會引起數據出錯，請慎重操作！！】".keyComment())
                }
            }
        });
        var a = $(b).find('input[name="create"]');
        if (parseInt(a, 10) >= 0) {
            parent.$.trigger("qisustate", a.val())
        }
        parent.$.bind("pagefresh.qishu", function() {
            var c = location.toString();
            var d = c.indexOf("?");
            if (d > 0) {
                c = c.substr(0, d)
            }
            location.replace(c)
        });
        $(window).unload(function() {
            parent.$.unbind("pagefresh.qishu")
        });
        $("a[name=closedraw]").click(function() {
            if (confirm("你確認要強制{#|5173|76d8#}嗎".keyComment())) {
                $.get("ajax_req.htm?act=close_draw", function(c) {
                    if ("no_close_draw" == c) {
                        alert("當前沒有{#|5f00|76d8#}{#|671f|6570#}，不能執行此操作".keyComment());
                        return
                    }
                    if ("" != c) {
                        alert("{#|5173|76d8#}失敗".keyComment());
                        return
                    }
                    alert("{#|5173|76d8#}成功".keyComment());
                    parent.$.trigger("lightOperator", 0);
                    location.reload(true)
                })
            }
            return false
        })
    },
    reopen_draw: function(c) {
        var b = $("#drkusukp form")[0];
        var a = function(g, d, j) {
            $("#drkusukp h2").text("重開當前{#|671f|6570#}".keyComment());
            var m = b.name;
            if (m) {
                $(m).parent().text(g)
            }
            var f = d.split("-");
            var l = j.split("-");
            $("span[name='draw_dt_fix']").text(f[0] + " 年 " + f[1] + "月 " + f[2] + " 日 ");
            b.name.value = g;
            b.oth.value = f[3];
            b.otm.value = f[4];
            b.nth.value = l[3];
            b.ntm.value = l[4];
            cover.show();
            $("#drkusukp").show();
            setTimeout(function() {
                b.oth.focus()
            }, 0);
            var h = function() {
                cover.hide();
                $(b.submit).removeAttr("disabled");
                $("#drkusukp").hide()
            };
            var k = function(n) {
                if ("error" == n.status) {
                    alert(n.msg);
                    $(b.submit).removeAttr("disabled")
                } else {
                    alert("重新{#|5f00|76d8#}成功! ".keyComment() + (n.msg ? n.msg : ""));
                    h();
                    location.reload()
                }
            };
            b.onsubmit = function() {
                $(this.submit).attr("disabled", "disabled");
                var n = function() {
                    if (b.oth.value + b.otm.value >= b.nth.value + b.ntm.value) {
                        return true
                    } else {
                        alert("非{#|7279|7801#}{#|505c|62bc#}時間不能大於{#|5173|76d8#}時間".keyComment());
                        return false
                    }
                };
                $.formatTime(b.oth, b.otm, b.nth, b.ntm);
                if (!$.validateForm(this) || !n()) {
                    $(this.submit).removeAttr("disabled");
                    return false
                }
                $.getJSON("ajax_req.htm?act=reopen_draw&hour=" + this.oth.value + "&minute=" + this.otm.value + "&nhour=" + this.nth.value + "&nminute=" + this.ntm.value, k);
                return false
            }
            ;
            b.cancel.onclick = function() {
                h()
            }
        };
        $("a[name='reopen']", c).click(function(f) {
            var d = f.target;
            if (!d.disabled && confirm("你確認要{#|5f00|76d8#}嗎".keyComment())) {
                $.getJSON("ajax_req.htm?act=reopen_draw", function(g) {
                    if ("error" == g.status) {
                        alert(g.msg)
                    } else {
                        if ("create" == g.status) {
                            a(g.name, g.end, g.stop)
                        }
                    }
                })
            }
            return false
        })
    },
    qishu_sure_del: function(a) {
        $("#submit").click(function() {
            $(this).attr("disabled", "disabled");
            setTimeout(function() {
                $("#submit").removeAttr("disabled")
            }, 5000);
            var d = $(":input[name=validate]").val();
            if (d == "") {
                alert("為了防止錯誤刪除{#|671f|6570#}，請輸入驗證碼".keyComment());
                return false
            }
            var c = $("#draw_id").val();
            var d = $("#validatecode").val();
            var b = "list.htm?op=dlt&id=" + c + "&validate=" + d;
            window.location.href = b
        });
        $("#validate-img").click(function() {
            var b = (new Date()).getTime();
            $(this).attr("src", "sure.htm?op=img&t=" + b)
        });
        $("#cancel").click(function() {
            window.location.href = "list.htm"
        })
    }
});
$.extend({
    oplist: function(b) {
        var a = $("select", b);
        $(a[0]).change(function(c) {
            location.replace("list.htm?op=slt&date=" + this.value + "&type=" + a[1].value + "&catid=" + a[2].value)
        });
        $(a[1]).change(function(c) {
            location.replace("list.htm?op=slt&date=" + a[0].value + "&type=" + this.value + "&catid=" + a[2].value)
        });
        $(a[2]).change(function(c) {
            location.replace("list.htm?op=slt&date=" + a[0].value + "&type=" + a[1].value + "&catid=" + this.value)
        });
        $("#btn").click(function(d) {
            var c = encodeURIComponent($("#keywords").val());
            location.replace("list.htm?op=slt&date=" + a[0].value + "&type=" + a[1].value + "&catid=" + a[2].value + "&keyword=" + c)
        })
    },
    chooseParent: function(b) {
        var a = b.getElementsByTagName("form")[0];
        b.getElementsByTagName("select")[0].onchange = function() {
            if ($.isRPint(this.value)) {
                a.submit()
            }
        }
    }
});
$.extend({
    kaijiang: function(h) {
        if (self === top) {
            $("body").empty();
            alert("新窗口不可用，請關閉該窗口。");
            return
        }
        var c = h.getElementsByTagName("form")[0];
        if (!c) {
            return
        }
        var g = c.getElementsByTagName("input");
        var f = c.getElementsByTagName("select")[0];
        $(c).keyup(function(j) {
            if (j.keyCode == 9) {
                return false
            }
            var d = j.target;
            if (d.type != "text") {
                return
            }
            if (isNaN(d.value)) {
                alert("請輸入數字");
                d.value = "";
                return false
            } else {
                if (2 == d.value.length) {
                    var k = d.parentNode;
                    if (k.cellIndex < 7) {
                        k.parentNode.cells[k.cellIndex + 1].firstChild.focus()
                    }
                }
            }
        });
        var b = function() {
            if (0 === f.selectedIndex && parent.$("#open").attr("disabled")) {
                alert("請先{#|5173|76d8#}！".keyComment());
                return false
            }
            return true
        };
        var a = function(l) {
            if (!b()) {
                return false
            }
            var n = "#";
            var m = -1;
            for (var j = 0; j < 7; j++) {
                var d = g[j].value;
                if (l) {
                    if (!d) {
                        if (m == -1) {
                            m = j
                        }
                        continue
                    }
                    if (m > -1 && m < j) {
                        alert("請依次輸入球號！");
                        g[m].select();
                        return false
                    }
                }
                var k = $.isBall(d);
                if (k) {
                    k = parseInt(k, 10);
                    if (n.indexOf("#" + k + "#") != -1) {
                        alert("球號不能有相同！");
                        g[j].select();
                        return false
                    }
                    n += k + "#"
                } else {
                    alert("請輸入正確球號!");
                    g[j].select();
                    return false
                }
            }
            if (l && "#" == n) {
                alert("請輸入球號!");
                g[0].select();
                return false
            }
            return true
        };
        $(c).submit(a);
        $(h).click(function(l) {
            var k = l.target;
            if (k.tagName != "A" || k.className.substr(0, 3) == "ico") {
                return
            }
            switch (k.getAttribute("act")) {
                case "reset":
                    if (!confirm("確認清除號碼嗎？") || !b()) {
                        return
                    }
                    var m = true;
                    for (var j = 0; j < 7; j++) {
                        if (g[j].value - 0) {
                            m = false
                        }
                        g[j].value = ""
                    }
                    if (m) {
                        alert("尚未輸入號碼！");
                        return
                    }
                    c.action = "./result.htm?op=save&clear=1";
                    c.submit();
                    break;
                case "cls":
                    if (!f.value) {
                        alert("請選擇{#|671f|6570#}！".keyComment())
                    } else {
                        if (!confirm("確認清除結果嗎？") || !b()) {
                            return
                        }
                        $.get("../ajax_req.htm?act=clear_result&" + $(c).serialize(), function(o) {
                            var n = {
                                "0": "清除結果成功！",
                                "1001": "{#|671f|6570#}和月份限制！".keyComment(),
                                "1004": "報表計算中，請稍候...",
                                "1005": "衹能對當前期執行此操作。",
                                "1006": "請先{#|5173|76d8#}！".keyComment(),
                                "1007": "尚未{#|5f00|5956#}計算，請先執行{#|5f00|5956#}計算".keyComment()
                            };
                            alert(n[o] ? n[o] : "本次計算不成功，稍後再試！")
                        })
                    }
                    break;
                case "cal_result":
                    if (!f.value) {
                        alert("請選擇{#|671f|6570#}！".keyComment())
                    } else {
                        if (!parent.$("#rptprg").hasClass("hid")) {
                            alert("報表計算中，請稍候...");
                            return
                        }
                        if (!a()) {
                            return
                        }
                        parent.$.setCover("正在{#|5f00|5956#}計算中，目前進度為<span id='progress_cover'>0</span>%，請不要刷新頁面!<span class='loadding2'/>".keyComment());
                        parent.cover.show();
                        var d = c.draw_id.value;
                        $.show_calc_status(1, true);
                        $.get_status(d);
                        $.get("../ajax_req.htm?act=calc_result&" + $(c).serialize(), function(o) {
                            if (o == "-2") {
                                return
                            }
                            if (o == "0") {
                                $.show_calc_status(8, true);
                                parent.$.setCover("計算完成 <span id='progress_cover'>100</span>%")
                            }
                            clearInterval($.status_timer);
                            $.status_timer = null;
                            var n = {
                                "0": "計算結束，可以查看相關報表！",
                                "1000": "保存號碼失敗！",
                                "1001": "{#|671f|6570#}和月份限制！".keyComment(),
                                "1002": "未全部錄入{#|4e2d|5956#}號碼，不能執行此操作！".keyComment(),
                                "1003": "先保存{#|4e2d|5956#}號碼！".keyComment(),
                                "1004": "報表計算中，請稍候...",
                                "1005": "衹能對當前期執行此操作。",
                                "1006": "請先{#|5173|76d8#}！".keyComment()
                            };
                            alert(n[o] ? n[o] : "本次計算不成功，稍後再試！");
                            parent.cover.setStr();
                            parent.cover.hide()
                        })
                    }
                    break
            }
            k.blur();
            return false
        });
        $(f).change(function() {
            $.getJSON("../ajax_req.htm?act=reload_result&draw_id=" + this.value, function(j) {
                for (var d = 0; d < 7; d++) {
                    g[d].value = j[d]
                }
            })
        })
    },
    status_timer: null,
    get_status: function(b) {
        var a = "ajax_req.htm?act=result_status&draw_id=" + (b ? b : "");
        $.status_timer = setInterval(function() {
            $.get(a, function(c) {
                status = parseInt(c, 10);
                $.show_calc_status(status, true);
                if (status == 8 || status == -1) {
                    clearInterval($.status_timer);
                    $.status_timer = null;
                    setTimeout(function() {
                        parent.cover.hide()
                    }, 3000)
                }
            })
        }, $.time_result_status)
    }
});
if (document.uniqueID && !window.XMLHttpRequest) {
    try {
        document.execCommand("BackgroundImageCache", false, true)
    } catch (e) {}
}
try {
    $.extend(window.setting)
} catch (ex) {}
$.ajaxSetup({
    cache: false,
    global: false,
    error: function(c, f, d) {
        try {
            var a = function() {
              /*  if (parent) {
                    parent.location.href = $.login_path
                } else {
                    location.href = $.login_path
                }*/
            };
            if (typeof (c.responseText) == "string") {
                if (c.responseText == "Duplicate session") {
                    alert("您已經在其它地方登錄");
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
            }
            if (c.status == 404) {
                a()
            }
            if (this.url && this.url.indexOf("act=refersh_draw") > 0) {
                $.trigger("ajaxconnect", [-1])
            }
            if (window.console) {
                console.info(c, f, d)
            }
        } catch (b) {}
    },
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
    checkLogin: function(f) {
        var c, b;
        c = f.getElementsByTagName("form")[0];
        $(":text,:password", c).val("");
        $(c.name).focus(function() {
            if (b) {
                clearInterval(b);
                b = null
            }
            if (!c.password.value) {
                b = setInterval(function() {
                    c.password.value = ""
                }, 99)
            }
        }).blur(function() {
            if (b) {
                clearInterval(b);
                c.password.value = "";
                b = null
            }
        });
        if (c.status.value == "adrerror") {
            alert("該用戶不能在此網站登錄")
        } else {
            if (c.status.value != "init") {
                var a;
                a = parseInt(c.status.value, 10);
                if (a == 2) {
                    alert("賬號或密碼有誤")
                } else {
                    if (a < 0 && a > -5) {
                        alert("賬號或密碼有誤")
                    } else {
                        alert("賬號已經被停用，請聯繫管理員 ")
                    }
                }
            }
        }
        setTimeout(function() {
            c.name.focus()
        }, 0);
        c.onsubmit = function() {
            if (!$.validateForm(this)) {
                return false
            }
        }
    },
    resizeFrame: function(c) {
        var b, a;
        b = 0;
        a = function() {
            var d;
            d = (document.documentElement.clientHeight || document.body.clientHeight) - $(c).offset().top;
            if (d !== b && d > 0) {
                c.style.height = d + "px";
                b = d
            }
        }
        ;
        a();
        $(window).resize(a)
    },
    resetPassword: function() {
        var a = document.forms[0];
        setTimeout(function() {
            a.oldpwd.focus()
        }, 0);
        a.onsubmit = function() {
            var d = function(f) {
                if (f.newpwd1.value != f.newpwd2.value) {
                    alert("新密碼與確認密碼輸入不一致");
                    setTimeout(function() {
                        a.newpwd1.focus()
                    }, 0);
                    return false
                }
                if (f.oldpwd.value == f.newpwd1.value) {
                    alert("新密碼與舊密碼不能相同");
                    setTimeout(function() {
                        a.newpwd1.focus()
                    }, 0);
                    return false
                }
            };
            return $.validateForm(this) && d(this)
        }
        ;
        document.getElementById("title").innerHTML = "0" == a.title.value ? "初次登錄，請修改密碼" : "密碼變更";
        switch (a.status.value) {
            case "2":
                alert("新密碼與確認密碼輸入不一致");
                a.newpwd1.select();
                break;
            case "3":
                alert("舊密碼輸入錯誤");
                a.oldpwd.select();
                break;
            case "5":
                alert("為了賬號安全，密碼不能和賬號相同");
                a.newpwd1.select();
                break;
            case "6":
                if ($.isStrongPwd) {
                    alert("1.密碼長度為6-12位，必須包含字母和數字；\n2.不能使用常用密碼。")
                } else {
                    alert("密碼由4-16位字符組成")
                }
                a.newpwd1.select();
                break;
            case "4":
                alert("密碼修改成功");
                var c = window.parent || window;
                c.location = "../index.htm";
                break;
            default:
                break
        }
        var b = $("<div></div>");
        b.css({
            position: "absolute",
            top: 0,
            left: 0,
            width: "100%",
            height: "100%",
            opacity: 0.3,
            background: "white",
            display: "none"
        }).prependTo(document.body);
        $("#oftenPasswordBtn").click(function(f) {
            b.show();
            var d = $("#drkusukp").show();
            d.css({
                marginLeft: -1 * d.width() / 2,
                marginTop: -1 * d.height() / 2
            })
        });
        $("#cancel").click(function() {
            $("#drkusukp").hide();
            b.hide()
        })
    },
    loginAddress: function(k) {
        var p = $(k)
            , l = 0
            , g = $("#addresses")
            , c = [].concat(logCity || [])
            , n = []
            , j = '<tr><td class="bg">地址<span>{index}</span>：</td><td>{select}</td></tr>'
            , f = '   <a href="javascript:" class="del_address">刪除</a>';
        function m(d, t) {
            var u, s = "", r = ["<option value='null'>请选择</option>"], q = "<option {selected} value='{value}'>{name}</option>";
            for (u in d) {
                if (isNaN(parseInt(u, 10))) {
                    continue
                }
                if (u === t) {
                    s = "selected"
                } else {
                    s = ""
                }
                r.push(q.replace("{value}", u).replace("{name}", d[u].name || d[u]).replace("{selected}", s))
            }
            if (r.length == 2) {
                r.shift()
            }
            return r.join("")
        }
        function h(d, s) {
            var r = []
                , q = l++;
            d,
                pidSelect = "<select  id='pid_" + q + "' >{options}</select>",
                cidSelect = "<select  id='cid_" + q + "' >{options}</select>";
            if (s && d) {
                r = cityInfo[d].city
            }
            pidSelect = pidSelect.replace("{options}", m(cityInfo, d));
            cidSelect = cidSelect.replace("{options}", m(r, s));
            return pidSelect + cidSelect
        }
        function a(r) {
            var s, u = [], q = r || [];
            if (r.length === 0) {
                u.push(j.replace("{index}", 1).replace("{select}", h()))
            } else {
                for (var d = 0, t = r.length; d < t; d++) {
                    s = r[d].split("|");
                    n.push(s[1]);
                    u.push(j.replace("{index}", d + 1).replace("{select}", h(s[0], s[1]) + (d !== 0 ? f : "")))
                }
            }
            return u.join("")
        }
        function o() {
            var q = g.find("select")
                , d = [];
            $.each(q, function(r, s) {
                if (/pid/.test(this.id)) {
                    var u = this.id.replace("pid_", "")
                        , t = document.getElementById("cid_" + u);
                    if (this.value !== "null" && t.value !== "null") {
                        d.push(t.value)
                    }
                }
            });
            return d
        }
        p.delegate("select", "change", function() {
            if (/pid/.test(this.id)) {
                if (this.value === "null") {
                    $("#" + this.id.replace("pid", "cid")).html("<option value='null'>請選擇</option>");
                    return
                }
                $("#" + this.id.replace("pid", "cid")).html(m(cityInfo[this.value].city))
            }
        });
        p.delegate("a", "click", function() {
            if (this.className === "del_address") {
                $(this).closest("tr").remove();
                g.find("span").html(function(q) {
                    return q + 1
                })
            }
            if (this.id === "add_address") {
                var d = g.find("tr").length;
                if (d === 5) {
                    alert("最多允許添加5個地點！");
                    return false
                }
                g.append(j.replace("{index}", d + 1).replace("{select}", h() + f))
            }
        });
        $("form", p).bind("reset", function() {
            g.html(a(c))
        }).bind("submit", function() {
            var v = document.getElementById("use_address")
                , d = false
                , t = false
                , r = {};
            if (v.checked !== v.defaultChecked) {
                d = true
            }
            var u = o();
            if (u.length === 0) {
                alert("至少選擇一個常用登錄地址");
                return false
            }
            for (var q = 0, s = u.length; q < s; q++) {
                if (r[u[q]]) {
                    alert("請刪除相同的地址!");
                    return false
                }
                r[u[q]] = 1;
                if (n[q] !== u[q]) {
                    t = true
                }
            }
            if (s !== n.length) {
                t = true
            }
            if (d === false && t === false) {
                alert("請修改後保存");
                return false
            }
            if (t) {
                this.insertAdjacentHTML("beforeEnd", '<input name="city" type="hidden" value="' + u.join("|") + '">')
            }
            if (d) {
                this.insertAdjacentHTML("beforeEnd", '<input name="use_address" type="hidden" value="' + (v.checked ? "1" : "0") + '">')
            }
        });
        g.html(a(c));
        var b = document.getElementsByName("status")[0].value;
        if (b === "success") {
            alert("保存成功")
        }
    },
    popLink: function(a) {
        $(a).click(function(k) {
            var c = k.target;
            c = k.target.tagName == "SPAN" ? $(c.parentNode) : $(c);
            if ("popup" === c.attr("target") && c.attr("href")) {
                var f = (c.attr("fix") || "").split("|");
                var b = c.attr("href")
                    , g = c.attr("poptitle") || "{#|73a9|6cd5#}明細".keyComment();
                if (b.indexOf("order_modify.htm") != -1) {
                    var d = 450;
                    var j = 160;
                    if (parseInt(f[0]) >= 600) {
                        d = 600;
                        j = 176
                    }
                    JqueryDialog.Open('<h2 class="g-tit">修改外調{#|8865|8d27#}{#|6ce8|5355#}</h2>'.keyComment(), b, d, j, true)
                } else {
                    if ("yes" == c.attr("par")) {
                        parent.JqueryDialog.Open1(g, b, f[0] - 100, parseInt(f[1]) - 200, false, true)
                    } else {
                        if ("report" == c.attr("from_page")) {
                            var h = c.attr("game_id");
                            if ("047" <= h && "052" >= h) {
                                var d = parseInt(f[0]) + 110 + 200
                            } else {
                                var d = parseInt(f[0]) + 110
                            }
                            JqueryDialog.Open1(g, b, d, parseInt(f[1]) - 200, false, true)
                        } else {
                            JqueryDialog.Open1(g, b, f[0] - 100, parseInt(f[1]) - 200, false, true)
                        }
                    }
                }
                return false
            }
        })
    },
    selectBox: function(c) {
        var b = $(c).find(":checkbox");
        var a = b.length;
        $(b).click(function(j) {
            var h = j.target;
            if ("check_all" == h.name) {
                var f = this.checked;
                for (var g = 1; g < a; g++) {
                    b[g].checked = f
                }
            } else {
                if (!this.checked) {
                    b[0].checked = false
                } else {
                    var d = true;
                    for (var g = 1; g < a; g++) {
                        if (!b[g].checked) {
                            d = false
                        }
                    }
                    if (d) {
                        b[0].checked = true
                    }
                }
            }
        });
        $(c.getElementsByTagName("form")[0]).submit(function() {
            if (a < 2) {
                return
            }
            for (var d = 1; d < a; d++) {
                if (b[d].checked) {
                    cover.show();
                    $(this.submit).attr("disabled", "disabled");
                    $.coverSubmit();
                    return
                }
            }
            alert("最少選擇一項{#|8865|8d27#}");
            return false
        });
        $(":checked").keyup(function(d) {
            if (13 === d.keyCode) {
                parent.JqueryDialog.Ok()
            }
        });
        $(":checked").get(0).focus()
    },
    xiazhumingxi: function(b) {
        var a = $("a[name='op_order']", b);
        a.click(function(m) {
            var r = m.target;
            var j = r.getAttribute("status");
            var u = "";
            var p = "";
            if ("2" == j) {
                j = 3;
                u = "取消";
                p = "恢復"
            } else {
                j = 2;
                u = "恢復";
                p = "取消"
            }
            if (!confirm("確定要" + u + "整個{#|6ce8|5355#}嗎？".keyComment())) {
                return false
            }
            var o = r.getAttribute("order_id");
            var f = r.getAttribute("time");
            var d = r.getAttribute("game_id");
            var k = encodeURI(r.getAttribute("number"));
            var l = r.getAttribute("shortCoverFlag");
            var n = r.getAttribute("refOrderId");
            var h = r.getAttribute("orderTime");
            var s = r.getAttribute("toCorpId");
            var q = r.getAttribute("toHubId");
            var c = $("#nnnn").val();
            var g = $("#page_type").val();
            $.getJSON("ajax_req.htm?act=change_order&agvs=" + f + "|" + o + "|" + j + "|" + d + "|" + k + "|" + l + "|" + n + "|" + h + "|" + s + "|" + c + "|" + q, function(t) {
                if ("1" == t.status) {
                    alert(u + "成功！");
                    location.reload();
                    return
                } else {
                    if ("-1" == t.status) {
                        alert(u + "失敗！該{#|6ce8|5355#}不存在".keyComment())
                    } else {
                        if ("-2" == t.status) {
                            alert(u + "失敗！該{#|6ce8|5355#}已經被".keyComment() + u)
                        } else {
                            if ("-4" == t.status) {
                                alert(u + "失敗！{#|5f00|5956#}計算中不能取消或恢復{#|6ce8|5355#}".keyComment())
                            } else {
                                if ("-5" == t.status) {
                                    alert(u + "失敗！不能取消或恢復往期{#|6ce8|5355#}".keyComment())
                                } else {
                                    alert(u + "失敗！" + (t.msg ? t.msg : ""))
                                }
                            }
                        }
                    }
                }
            });
            return false
        })
    },
    newpeilv: function(b) {
        var a;
        $.bind("newpeilv", function(g, f, h, d) {
            if (f) {
                a = h;
                a.show();
                $.get("ajax_req.htm?act=getMarqueeOddsMore&flag=" + d, function(c) {
                    $("table", b).replaceWith(c);
                    $("h2 span", b).text(d == 1 ? "本公司" : "{#|8865|8d27#}公司".keyComment());
                    b.style.display = "block"
                })
            } else {
                b.style.display = "none"
            }
        });
        $(":button", b).click(function() {
            b.style.display = "none";
            a.hide()
        })
    },
    oddsPupop: function(j) {
        var a = $(":text", j)[0], c = $("span", j)[0], g, f, h;
        $(document).bind("oddspupop", function(m, p, d, k) {
            g = m.target;
            c.innerHTML = p;
            c.className = d || "";
            $(c).removeClass("hand");
            var n = $(g).offset();
            var l = n.left + $(j).width() + 10 - $(window).width() - $(window).scrollLeft();
            var o = n.top + $(j).height() + 10 - $(window).height() - $(window).scrollTop();
            j.style.left = (n.left - (l > 0 ? l : 0)) + "px";
            j.style.top = (n.top - (o > 0 ? o : 0)) + "px";
            j.style.display = "block";
            a.value = g.innerHTML;
            $.trigger("runtime", [0]);
            f = a.value;
            h = k;
            cover.show();
            a.select()
        });
        var b = function() {
            j.style.display = "none";
            cover.hide();
            $.trigger("runtime", [1])
        };
        $("input[type=button]").click(b);
        cover.onBodyClick(b);
        $("form", j).submit(function() {
            if (f == a.value) {
                b();
                return false
            }
            var d = $("a", j).attr("gid") || h;
            if ($.validateEm(a, d)) {
                $(g).trigger("oddsdata", [parseFloat(a.value), f]);
                b()
            }
            return false
        })
    },
    submitDelay: function(a) {
        $(":submit", a.target).each(function() {
            var b = this;
            b.disabled = true;
            setTimeout(function() {
                b.disabled = false
            }, 1000)
        })
    },
    changeSpinner: function(c) {
        var b = "不能設置{#|9000|6c34#}值高於該用戶上級的最低{#|9000|6c34#}值，請重新設置。".keyComment();
        var a = "不可以設置{#|9000|6c34#}值小於0。".keyComment();
        $(":text[maxval][minval]").spinner({
            insval: 0.1,
            fixed: 1,
            allownull: 0,
            msg_down: a,
            msg_up: b,
            msg_status: true,
            is_discount: true
        })
    },
    gsbho: function(a) {
        $(":text[maxval][minval]", a).spinner({
            insval: 0.01,
            fixed: 2,
            allownull: 0,
            msg_status: true
        });
        $("form", a).submit(function(g) {
            var f = g.target;
            var d = false;
            var b = $(":text[minval][maxval]", f);
            var h = f.to_corp_id.value;
            if (adjust_odds[h]) {
                for (var c = 0; c < b.length; c++) {
                    if (adjust_odds[h][b[c].name] != b[c].value) {
                        d = true;
                        break
                    }
                }
            } else {
                d = true
            }
            if (d === false) {
                alert("請修改後再保存");
                return false
            }
            return d
        })
    },
    is_odds_declen3: function(a) {
        return $.game_odds3.indexOf("," + a + ",") > 0
    },
    show_calc_status: function(a, b) {
        a = parseInt(a, 10);
        if (-1 == a) {
            if (!$("#rptprg").hasClass("hid")) {
                $.progress(8, b)
            }
        } else {
            $.progress(a, b)
        }
    },
    c_re_pgs: 0,
    is_delay_time: false,
    progress: function(c, d) {
        var a = [0, 20, 30, 50, 60, 70, 80, 90, 100, 100];
        var g = d === true ? parent.$("#progress_cover") : $("#progress");
        $("#rptprg").removeClass("hid");
        $("#odds_new").addClass("hid");
        var b = function() {
            $.is_delay_time = true;
            setTimeout(function() {
                $.is_delay_time = false;
                $("#rptprg").addClass("hid");
                $("#odds_new").removeClass("hid");
                g.text("");
                $.c_re_pgs = 0
            }, 3000)
        };
        if (8 == c && !$.is_delay_time) {
            b()
        }
        $.c_re_pgs = $.c_re_pgs < a[c] ? a[c] : $.c_re_pgs;
        var f = setInterval(function() {
            if ($.c_re_pgs == a[c + 1]) {
                g.text($.c_re_pgs)
            }
            if ($.c_re_pgs == 100) {
                b()
            }
            if ($.c_re_pgs < a[c + 1]) {
                g.text($.c_re_pgs++)
            } else {
                clearInterval(f);
                f = null
            }
        }, $.time_result_progress)
    },
    order_set_width: function() {},
    syszaxiang: function() {
        $("#submit").click(function() {
            if (!$.validateForm(this)) {
                return false
            }
        })
    }
});
var buhuo = null;
var monitor = null;
var result = null;
var totalLm = null;
var cover = new Cover("#fff",0.3,4);
var init = {
    ready_count: 1,
    ready_timmer: null,
    cover: new Cover("#fff",0.01,4),
    ready_try: function() {
        if ((self == top) || (parent && parent.$)) {
            init.ready()
        } else {
            if (init.ready_timmer) {
                clearTimeout(init.ready_timmer)
            }
            init.ready_count++;
            init.ready_timmer = setTimeout(function() {
                init.ready_try()
            }, 500);
            if (init.ready_count == 6) {
                init.cover.setStr("您可能遇到網絡問題，請繼續等待，或<a herf='javascript:' onclick='location.replace(location.href);'>刷新</a><span class='loadding2'/>")
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
            a("adminheader", function(c) {
                header = new Header(c)
            });
            a("main", $.resizeFrame);
            a("adminlogin", $.checkLogin);
            a("config_other", $.otherConfig);
            a("config_other2", $.otherConfig2);
            a("sysconfig", $.sysConfig);
            a("psdlist", $.resetPassword);
            a("loginAddress", $.loginAddress);
            a("order", $.registerOrder);
            a("reportmingxi", $.popLink);
            a("reportwanfa", $.popLink);
            a("shoufutongji", $.tongjiHead);
            a("tongjitema", $.tongjiFresh);
            a("tongjiothers", $.tongjiFresh);
            a("tjzhengmate", $.tongjiFresh);
            a("tjlianma", $.tongjiFresh);
            a("tjguoguan", $.tongjiFresh);
            a("tjlianmamingxi", $.tongjiPopup);
            a("shangxiabuhuo", $.shangxiabuhuo);
            a("waidiaobuhuo", $.waidiaobuhuo);
            a("tjscl", $.cancelorder);
            a("qishu", $.reopen_draw);
            a("xiazhumingxi", $.xiazhumingxi);
            a("sysli", $.heightLightSysconfig);
            a("sysbuhuo", function() {
                buhuo = new BuHuo()
            });
            a("rate_detail", function(c) {
                monitor = new Monitor(c)
            });
            a("duobu", $.selectBox);
            a("amhover", $.hoverDiv);
            a("jiandutop", $.jdLinkClick);
            a("gongsibuhuo", function(c) {
                gsbuhuo = new GongsiBuHuo(c)
            });
            a("gsbhm", $.GongsiBuHuoMember);
            a("gongsibuhuo", $.popLink);
            a("admcreate", $.adminRelaod);
            a("u1create", $.gudongRelaod);
            a("u2create", $.zdlRelaod);
            a("u3create", $.dlsRelaod);
            a("newreport", $.reportHideCol);
            a("reportdagudong", $.reportHideCol);
            a("reportgudong", $.reportHideCol);
            a("reportzongdaili", $.reportHideCol);
            a("reportdaili", $.reportHideCol);
            a("fnewreport", $.freportHideCol);
            a("freportdagudong", $.freportHideCol);
            a("freportgudong", $.freportHideCol);
            a("freportzongdaili", $.freportHideCol);
            a("freportdaili", $.freportHideCol);
            a("ampp", $.oddsPupop);
            a("nepeli", $.newpeilv);
            a("gsbho", $.gsbho);
            a("kaijiang", $.kaijiang);
            a("report", $.report);
            a("qishuguanli", $.checkTime);
            a("qishu", $.drawsRefresh);
            a("u1create", $.userCheck);
            a("admcreate", $.userCheck);
            a("u2create", $.userCheck);
            a("u3create", $.userCheck);
            a("memcreate", $.userCheck);
            a("guanliyuan", $.adminReloadData);
            a("dagudong", $.dgdList);
            a("gudong", $.gdList);
            a("zongdaili", $.zdlList);
            a("dailishang", $.dlList);
            a("huiyuan", $.memberReloadData);
            a("oplist", $.oplist);
            a("choose", $.chooseParent);
            a("u1create", $.changeSpinner);
            a("u2create", $.changeSpinner);
            a("u3create", $.changeSpinner);
            a("memcreate", $.changeSpinner);
            a("userli", $.heightLightAcount);
            a("xiazhumsg", $.xiazhumsg);
            a("xiazhumsg", $.popLink);
            a("detail_order_data", $.order_set_width);
            a("qishu_sure_del", $.qishu_sure_del);
            a("syszaxiang", $.syszaxiang);
            a("odetail", $.odetail);
            a("game_rule", $.gameRule);
            a("marquee_config", $.marqueeConfig);
            $.movod();
            init.cover.hide()
        })
    }
};
init.cover.setStr("系統正在準備，請稍候...<span class='loadding2'/>");
init.cover.show();
init.ready_try();
