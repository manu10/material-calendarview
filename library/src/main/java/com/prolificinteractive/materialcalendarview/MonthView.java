package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/**
 * Display a month of {@linkplain DayView}s and
 * seven {@linkplain WeekDayView}s.
 */
@SuppressLint("ViewConstructor") class MonthView extends CalendarPagerView {

  public MonthView(
      @NonNull final MaterialCalendarView view,
      final CalendarDay month,
      final DayOfWeek firstDayOfWeek,
      final boolean showWeekDays,
      final boolean decoratorFillsCell,
      final int decoratorPadding,
      final boolean dayOfWeekInDayCell) {
    super(view, month, firstDayOfWeek, showWeekDays,decoratorFillsCell, decoratorPadding, dayOfWeekInDayCell);
  }

  @Override protected void buildDayViews(
          final Collection<DayView> dayViews,
          final LocalDate calendar,
          boolean decoratorFillsCell,
          int decoratorPadding,
          boolean dayOfWeekInDayCell) {
    LocalDate temp = calendar;
    for (int r = 0; r < DEFAULT_MAX_WEEKS; r++) {
      for (int i = 0; i < DEFAULT_DAYS_IN_WEEK; i++) {
        addDayView(dayViews, temp, decoratorFillsCell, decoratorPadding, dayOfWeekInDayCell);
        temp = temp.plusDays(1);
      }
    }
  }

  public CalendarDay getMonth() {
    return getFirstViewDay();
  }

  @Override protected boolean isDayEnabled(final CalendarDay day) {
    return day.getMonth() == getFirstViewDay().getMonth();
  }

  @Override protected int getRows() {
    return showWeekDays ? DEFAULT_MAX_WEEKS + DAY_NAMES_ROW : DEFAULT_MAX_WEEKS;
  }
}
