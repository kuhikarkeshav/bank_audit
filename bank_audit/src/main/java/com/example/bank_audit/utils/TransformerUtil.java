//package com.example.bank_audit.utils;
//
//import java.lang.reflect.Method;
//
//public class TransformerUtil {
//	
//	private static final String PREF_GET = "get";
//    private static final String PREF_IS = "is";
//    private static final String PREF_SET = "set";
//
//    public static void copyAllUtility(Object source, Object target) {
//        Method[] sourcePublicMethods = source.getClass().getMethods();
//        Method[] targetPublicMethods = target.getClass().getMethods();
//
//        try {
//            for (int i = 0; i < sourcePublicMethods.length; i++) {
//                if (sourcePublicMethods[i].getName().startsWith("get")) {
//                    if (sourcePublicMethods[i].getParameterTypes().length > 0)
//                        continue;
//
//                    String setterName = "set"
//                            + sourcePublicMethods[i].getName().substring(3);
//                    for (Method pubMethod : targetPublicMethods) {
//                        if (pubMethod.getName().equals(setterName)) {
//                            if (pubMethod.getParameterTypes().length != 1)
//                                continue;
//                            if (pubMethod.getParameterTypes()[0]
//                                    .equals(sourcePublicMethods[i]
//                                            .getReturnType())) {
//                                pubMethod.invoke(target, sourcePublicMethods[i]
//                                        .invoke(source));
//                            }
//                        }
//                    }
//                } else if (sourcePublicMethods[i].getName().startsWith("is")) {
//                    if (sourcePublicMethods[i].getParameterTypes().length > 0)
//                        continue;
//                    String setterName = "set"
//                            + sourcePublicMethods[i].getName().substring(2);
//                    for (Method pubMethod : targetPublicMethods) {
//                        if (pubMethod.getName().equals(setterName)) {
//                            if (pubMethod.getParameterTypes().length != 1)
//                                continue;
//                            if (pubMethod.getParameterTypes()[0]
//                                    .equals(sourcePublicMethods[i]
//                                            .getReturnType())) {
//                                pubMethod.invoke(target, sourcePublicMethods[i]
//                                        .invoke(source));
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//}
