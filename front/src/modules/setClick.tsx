const SET_CLICK = 'setClick' as const;

export const setCLICK = (click: boolean) => ({
  type: SET_CLICK,
  click,
});

type state = {
  click: boolean;
};

type setClickAction = ReturnType<typeof setCLICK>;

const initialState: state = {
  click: false,
};

const setClick = (state: state = initialState, action: setClickAction) => {
  switch (action.type) {
    case SET_CLICK:
      return { ...state, click: !action.click };
    default:
      return state;
  }
};

export default setClick;
