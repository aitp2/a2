import { stepData } from '../services/api';

export default {
  namespace: 'steps',

  state: {
    list: [],
    loading: false,
    steps: {},
  },

  effects: {
    *fetch(_, { call, put }) {
      yield put({
        type: 'changeLoading',
        payload: true,
      });
      const response = yield call(stepData);
      yield put({
        type: 'save',
        payload: response,
      });
      yield put({
        type: 'changeLoading',
        payload: false,
      });
    },
    *fetchCurrent(_, { call, put }) {
      const response = yield call(stepData);
      yield put({
        type: 'saveCurrentUser',
        payload: response,
      });
    },
  },

  reducers: {
    save(state, action) {
      return {
        ...state,
        list: action.payload,
      };
    },
    changeLoading(state, action) {
      return {
        ...state,
        loading: action.payload,
      };
    },
    saveCurrentUser(state, action) {
      return {
        ...state,
        steps: action.payload,
      };
    },
    changeNotifyCount(state, action) {
      return {
        ...state,
        steps: {
          ...state.steps,
          notifyCount: action.payload,
        },
      };
    },
  },
};
